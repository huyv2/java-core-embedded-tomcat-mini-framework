package hr.ewallet.driver.init;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.List;

import hr.ewallet.common.constant.ParamConstant;
import hr.ewallet.adapter.in.dto.request.BaseRequestDto;
import hr.lib.cache.Cache;
import hr.lib.cache.CacheManager;
import hr.lib.constant.CacheConstant;
import hr.lib.init.BaseInit;
import hr.lib.util.FileUtil;
import hr.lib.util.ResourceUtil;

public class RequestDtoInit extends BaseInit {

	@SuppressWarnings("rawtypes")
	@Override
	public void init() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		String dtoPackage = ParamConstant.DTO_PACKAGE;
		Cache literalRequestClassCache = (Cache) CacheManager.getInstance().createCache(CacheConstant.LITERAL_REQUEST_CLASS);
		List<Class> initLiteralList = FileUtil.getClasses(dtoPackage, BaseRequestDto.class);
		for(Class literal : initLiteralList) {
			if (Modifier.isAbstract(literal.getModifiers())
					|| Modifier.isInterface(literal.getModifiers())) {
				continue;
			}
			literalRequestClassCache.put(ResourceUtil.getUrlPatternConfigurationByRequestName(literal.getSimpleName()), literal);
		}
		ResourceUtil.clearRequestUrlPatternConfiguratione();
	}

	@Override
	public void destroy() {
		
	}
}
