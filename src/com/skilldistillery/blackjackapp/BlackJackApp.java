package com.skilldistillery.blackjackapp;

import java.util.Scanner;
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
		playHand(scanner, player, dealer);
	}

	public void playHand(Scanner scanner, BlackJackPlayer player, BlackJackDealer dealer) {
		dealer.clearHand();
		player.clearHand();
		boolean dealerBusted = false;
		boolean playerBusted = false;
		dealer.dealOneCard(player);
		dealer.dealOneCard(player);
		dealer.dealOneCard(dealer);
		dealer.dealOneCard(dealer);

		player.displayHand();
		dealer.displayHandMinus1();

		if (player.hasBlackJack()) {

		} else {
			while (player.playerWantsToHit(scanner)) {
				dealer.dealOneCard(player);
				player.displayHand();
				if (player.isBust() ? true : false) {
					playerBusted = true;
					System.out.println("Player busted.");
					break;
				}
			}

			if (!playerBusted) {
				dealerBusted = stayActivities(dealer);
			}
		}

		if (dealerBusted || (player.getHandValue() > dealer.getHandValue() && !playerBusted)) {
			System.out.println("Player won!");
		} else if (dealer.getHandValue() == player.getHandValue()) {
			System.out.println("This had is a draw.");
		} else {
			System.out.println("Dealer won.");
		}

		System.out.println("Do you want to print the deck? y/n");
		if (scanner.next().equals("y")) {
			dealer.displayRemainingDeck();
		}
		System.out.println("Do you want to play again? y/n");
		String yesNo = scanner.next();
		if (yesNo.equals("y")) {
			run();
		}
		System.out.println("Nice playin with ya.");
		scanner.close();
		return;
	}

	public boolean stayActivities(BlackJackDealer dealer) {
		dealer.displayHand();
		while (dealer.getHandValue() < 17) {
			dealer.dealOneCard(dealer);
			dealer.displayHand();
		}
		if (dealer.isBust()) {
			System.out.println("Dealer busted!");
			return true;
		}
		return false;
	}
}
