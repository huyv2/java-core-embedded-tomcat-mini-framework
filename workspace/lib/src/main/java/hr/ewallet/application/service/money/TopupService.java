package hr.ewallet.application.service.money;

import hr.ewallet.application.port.in.momo.money.TopupUseCase;
import hr.ewallet.common.constant.ParamConstant;
//import hr.ewallet.domain.card.Activity;
//import hr.ewallet.domain.card.Card;
//import hr.ewallet.domain.account.Account;
//import hr.ewallet.domain.account.Activity;

public class TopupService implements TopupUseCase {

	@Override
	public boolean topup(String token, Long amount, String type) {
		boolean isSuccess = false;
		
		if (type.equals(ParamConstant.ACCOUNT_TYPE)) {
			//Account account = new Account();
			//Activity accountActivity = Activity.createActivity();
			
			// Proccess to move money here using Account, Activity and something to do then return true or false
		} else if (type.equals(ParamConstant.CARD_TYPE)) {
			//Card card = new Card();
			//Activity cardActivity = Activity.createActivity();
			
			// Proccess to move money here using Account, Activity and something to do then return true or false
		}
		
		return isSuccess;
	}

}
