package com.skilldistillery.player;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackJackDealer extends BlackJackPlayer {
	private Deck deck = new Deck();
	
	public BlackJackDealer(String name) {
		super(name);
	}
	
	public void dealOneCard(BlackJackPlayer player) {
		Card card = this.deck.dealCard();
		player.addCardToHand(card);
	}
	
	public void displayHandMinus1() {
		Card dontShow = hand.removeCard();
		System.out.println("Dealer hand: " + this.hand.toString() +
				"one face down card.");
		hand.addCard(dontShow);
	}
	
//	public void displayAllDealerHand() {
//		System.out.println(this.hand.toString());
//	}
	
	public void shuffle() {
		this.deck.shuffle();
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public boolean hasBlackJack() {
		return hand.isBlackJack();
	}

	
}
