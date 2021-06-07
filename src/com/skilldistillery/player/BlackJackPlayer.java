package com.skilldistillery.player;

import java.util.Scanner;

import com.skilldistillery.cards.common.BlackJackHand;
import com.skilldistillery.cards.common.Card;

public class BlackJackPlayer extends AbstractPlayer {
	protected BlackJackHand hand = new BlackJackHand();
	
	public BlackJackPlayer(String name) {
		super(name);
	}
	
	public BlackJackPlayer() {}

	public void displayHand() {
		System.out.println(this.getName() + " hand: " + hand.toString());
	}
	
	public Boolean playerWantsToHit(Scanner scanner) {
		System.out.println("Do you want to hit? y/n");
		if (scanner.next().equals("y")) {
			return true;
		}
		System.out.println("Ok, player stays.");
		return false;
	}
	
	public void addCardToHand(Card card) {
		this.hand.addCard(card);
	}
	
	public void clearHand() {
		hand = new BlackJackHand();
	}
	
	public BlackJackHand getHand() {
		return hand;
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public boolean hasBlackJack() {
		return hand.isBlackJack();
	}
	
	public boolean isBust() {
		return hand.isBust();
	}
}
