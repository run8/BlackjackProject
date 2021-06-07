package com.skilldistillery.blackjackapp;

import java.util.Scanner;

import com.skilldistillery.cards.common.BlackJackHand;
import com.skilldistillery.player.BlackJackDealer;
import com.skilldistillery.player.BlackJackPlayer;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		BlackJackDealer dealer = new BlackJackDealer("Dealer");
		BlackJackPlayer player = new BlackJackPlayer("Player");
		
		// Deal initial hands   Maybe initialize dealer/player hands in constructor
		dealer.dealOneCard(player);
		dealer.dealOneCard(player);
		dealer.dealOneCard(dealer);
		dealer.dealOneCard(dealer);

		// Display hands
		player.displayHand();
		dealer.displayHandMinus1();

		if (player.hasBlackJack()) {
			System.out.println("Player won.");
		} else if (player.playerWantsToHit(scanner)) {
			dealer.dealOneCard(player);
			player.displayHand();
			if (player.isBust()) {
				System.out.println("Player busted.");
				return;
			} 
		} 
		dealer.displayHand();
		stayActivities(dealer);
		
		if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("Player won!");
		} else {
			System.out.println("Dealer won ");
		}
		
		System.out.println("Do you want to play again? y/n");
		String yesno = scanner.next();
		if (yesno.equals("y")) {
			run();
		} 
		System.out.println("Nice playin with ya.");
		return;
	}
	
	public void stayActivities(BlackJackDealer dealer) {
		while (dealer.getHandValue() < 17) {
			dealer.dealOneCard(dealer);
			dealer.displayHand();
	
		}
		if (dealer.isBust()) {
			System.out.println("Dealer busted!");;
		}
	}

}
