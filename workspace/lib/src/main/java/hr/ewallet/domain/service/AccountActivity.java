package hr.ewallet.domain.service;

import hr.ewallet.domain.account.Account;
import hr.lib.factory.bean.Bean;

public interface AccountActivity extends Bean {
	boolean moveMoney(Account sourceAccount, Account destinationAccount, long amount);
	boolean withdraw(Account account, long amount);
	boolean deposit(Account account, long amount);
}
