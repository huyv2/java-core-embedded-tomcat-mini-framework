package hr.lib.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseInit {
	protected final Logger log = LogManager.getLogger(this.getClass());
	
	public void initBase() {
		try {
			init();
		} catch(Exception e) {
			log.error(e);
		}
	}
	public void destroyBase() {
		try {
			destroy();
		} catch(Exception e) {
			log.error(e);
		}
	}
	public abstract void init() throws Exception;
	public abstract void destroy() throws Exception;
}