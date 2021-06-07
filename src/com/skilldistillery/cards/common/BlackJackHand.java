package com.skilldistillery.cards.common;

import java.util.List;

public class BlackJackHand extends Hand {

	public BlackJackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int sumCards = 0;
		for (Card card : hand) {
			sumCards += card.getValue();
		}
		return sumCards;
	}
	
	
	public boolean isBust() {
		return getHandValue() > 21;
	}

	public boolean isBlackJack() {
		return getHandValue() == 21;
	}
	
	

	@Override
	public String toString() {
		String handInfo = "";
		for (Card card : hand) {
			handInfo += card.toString() + " ";
		}
		return handInfo;
	}

//	public Card removeCard() {
//		hand.remove
//	}

}
