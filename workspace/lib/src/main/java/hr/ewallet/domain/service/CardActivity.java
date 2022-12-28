package hr.ewallet.domain.service;

import hr.ewallet.domain.card.Card;
import hr.lib.factory.bean.Bean;

public interface CardActivity extends Bean {
	boolean moveMoney(Card sourceCard, Card destinationCard, long amount);
	boolean withdraw(Card account, long amount);
	boolean deposit(Card account, long amount);
}
