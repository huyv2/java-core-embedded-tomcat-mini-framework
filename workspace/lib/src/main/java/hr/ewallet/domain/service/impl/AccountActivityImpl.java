package hr.ewallet.domain.service.impl;

import hr.ewallet.domain.account.Account;
import hr.ewallet.domain.service.AccountActivity;

public class AccountActivityImpl implements AccountActivity {
	
	public boolean moveMoney(Account sourceAccount, Account destinationAccount, long amount) {
		boolean isSuccess = false;
		
		// Same bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
	
	public boolean withdraw(Account account, long amount) {
		boolean isSuccess = false;
		
		// Different bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
	
	public boolean deposit(Account account, long amount) {
		boolean isSuccess = false;
		
		// Different bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
}
