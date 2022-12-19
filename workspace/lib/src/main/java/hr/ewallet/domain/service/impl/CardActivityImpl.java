package hr.ewallet.domain.service.impl;

import hr.ewallet.domain.card.Card;
import hr.ewallet.domain.service.CardActivity;

public class CardActivityImpl implements CardActivity {
	public static CardActivityImpl createActivity() {
		return new CardActivityImpl();
	}
	
	private CardActivityImpl() {
		// Load card gl account service here
	}
	
	public boolean moveMoney(Card sourceCard, Card destinationCard, long amount) {
		boolean isSuccess = false;
		
		// Same bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
	
	public boolean withdraw(Card account, long amount) {
		boolean isSuccess = false;
		
		// Different bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
	
	public boolean deposit(Card account, long amount) {
		boolean isSuccess = false;
		
		// Different bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
}
