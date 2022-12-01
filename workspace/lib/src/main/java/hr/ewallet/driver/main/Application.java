package hr.ewallet.driver.main;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hr.lib.cache.Cache;
import hr.lib.cache.CacheManager;
import hr.lib.constant.CacheConstant;
import hr.lib.constant.ParamConstant;
import hr.lib.factory.ExecutorFactory;
import hr.lib.init.BaseInit;
import hr.lib.util.FileUtil;
import hr.lib.util.ResourceUtil;

public class Application {
	public final static Logger log = LogManager.getLogger(Application.class);
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void main(String[] args) {
		try {
			// Have to load in the main
			ResourceUtil.loadApplicationProperties();
			ResourceUtil.loadUrlPatternProperties();
			//
			
			Cache applicationSystemCache = (Cache) CacheManager.getInstance().createCache(CacheConstant.APPLICATION_SYSTEM);
			Cache literalClassCache = (Cache) CacheManager.getInstance().createCache(CacheConstant.LITERAL_INIT_CLASS);
			CacheManager.getInstance().init();
			
	        String serverPort = ResourceUtil.getApplicationConfiguration("server.port");
	        if(serverPort == null || serverPort.isEmpty()) {
	        	serverPort = ParamConstant.DEFAULT_PORT;
	        }
			
			Tomcat tomcat = new Tomcat();
			applicationSystemCache.put(ParamConstant.TOMCAT_WEB_SERVER, tomcat);
			//tomcat.setBaseDir("temp");
			tomcat.setPort(Integer.valueOf(serverPort));
			
			String contextPath = "";
			String docBase = new File(".").getAbsolutePath();
			Context context = tomcat.addContext(contextPath, docBase);
			String servletName = "";
			String urlPattern = ""; //ResourceUtil.getUrlPatternConfigurationByControllerName("TestServlet");
			
			String rootPackage = ParamConstant.ROOT_PACKAGE;
			
			List<Class> servletLiteralList = FileUtil.getClasses(rootPackage, HttpServlet.class);
			for(Class literal : servletLiteralList) {
				if (Modifier.isAbstract(literal.getModifiers())
						|| Modifier.isInterface(literal.getModifiers())) {
					continue;
				}
				servletName = literal.getName();
				Wrapper wrapper = tomcat.addServlet(contextPath, servletName, literal.getName());
				wrapper.setAsyncSupported(true);
				urlPattern = ResourceUtil.getUrlPatternConfigurationByControllerName(literal.getSimpleName());
				context.addServletMappingDecoded(urlPattern, servletName);
			}
			
			List<Class> initLiteralList = FileUtil.getClasses(rootPackage, BaseInit.class);
			for(Class literal : initLiteralList) {
				if (Modifier.isAbstract(literal.getModifiers())
						|| Modifier.isInterface(literal.getModifiers())) {
					continue;
				}
				literalClassCache.put(literal.getSimpleName(), literal.newInstance());
				BaseInit initBase = (BaseInit) literalClassCache.get(literal.getSimpleName());
				initBase.initBase();
			}
			
			ExecutorFactory.init();
			
			if (Runtime.getRuntime() != null) {
				Runtime.getRuntime().addShutdownHook(new Thread() {
					public void run() {
						Cache applicationSystemCache = (Cache) CacheManager.getInstance().getCache(CacheConstant.APPLICATION_SYSTEM);
						Tomcat tomcat = (Tomcat) applicationSystemCache.get(ParamConstant.TOMCAT_WEB_SERVER);
						
						Cache literalClassCache = (Cache) CacheManager.getInstance().getCache(CacheConstant.LITERAL_INIT_CLASS);
						ConcurrentHashMap<String, Object> cacheMaps = (ConcurrentHashMap<String, Object>) literalClassCache.getAll();
						for(Map.Entry<String, Object> cacheMap : cacheMaps.entrySet()) {
							String key = cacheMap.getKey();
							BaseInit initBase = (BaseInit) cacheMap.getValue();
							initBase.destroyBase();
							literalClassCache.remove(key);
						}
						try {
							CacheManager.getInstance().destroy();
							ExecutorFactory.shutdown();
							tomcat.stop();
						} catch (LifecycleException e) {
							
						}
					}
				});
			}
			
			tomcat.start();
			tomcat.getServer().await();
		} catch(Exception e) {
			log.error(e);
		}
	}
}
