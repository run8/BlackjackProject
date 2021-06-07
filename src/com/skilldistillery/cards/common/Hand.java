package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public Card removeCard() {
		if (hand.size() > 0) {
			return hand.remove(0);
		} else {
		return null;
		}
	}

	public abstract int getHandValue();

	public abstract String toString();

	public void clear() {
		hand = new ArrayList<>();
	}

}
