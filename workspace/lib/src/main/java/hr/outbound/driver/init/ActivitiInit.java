package hr.outbound.driver.init;

import hr.lib.init.BaseInit;

public class ActivitiInit extends BaseInit {

	@Override
	public void init() {
		log.info("Start initializing Process Engine");
		/*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		if (processEngine == null) {
			log.error("Could not start the Activiti Engine");
		} else {
			log.info("Initialzing Process Engine finishes");
		}*/
	}

	@Override
	public void destroy() {
		log.info("Start destroying Process Engine");
		//ProcessEngines.destroy();
		log.info("Destroying Process Engine finishes");
	}

}
