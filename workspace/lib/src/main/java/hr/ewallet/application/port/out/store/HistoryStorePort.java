package hr.ewallet.application.port.out.store;

import java.lang.reflect.Parameter;

import hr.ewallet.driver.init.bean.Bean;

public interface HistoryStorePort<T> extends Bean {
	boolean save(Parameter ... parameter);
	T inquiry();
}
