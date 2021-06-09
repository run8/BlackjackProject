package com.skilldistillery.player;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackJackDealer extends BlackJackPlayer {
	private Deck deck = new Deck();
	
	public BlackJackDealer(String name) {
		super(name);
	}
	
	public void dealOneCard(BlackJackPlayer player) {
		System.out.println("Dealer deals 1 card to " + player.getName());
		Card card = this.deck.dealCard();
		player.addCardToHand(card);
	}
	
	public void displayHandMinus1() {
		Card dontShow = hand.removeCard();
		System.out.println("Dealer hand: " + this.hand.toString() +
				"one face down card. Total: " + getHandValue());
		hand.addCard(dontShow);
	}
	
	public void shuffle() {
		this.deck.shuffle();
	}

	public void displayRemainingDeck() {
		System.out.println(deck.toString());
	}
}
