package hr.ewallet.application.port.in.momo.money;

import hr.ewallet.driver.init.bean.Bean;

public interface TopupUseCase extends Bean {
	boolean topup(String token, Long amount, String type);
}
