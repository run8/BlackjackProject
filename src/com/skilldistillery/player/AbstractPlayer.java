package com.skilldistillery.player;

import com.skilldistillery.cards.common.Hand;

public abstract class AbstractPlayer {
	
	private String name;
	private Hand hand;
	
	public AbstractPlayer(String name) {
		this.name = name;
	}
	
	public AbstractPlayer(String name, Hand hand) {
		super();
		this.name = name;
		this.hand = hand;
	}
	
	public AbstractPlayer() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

//	public int getScore() {
//		return score;
//	}

//	public void setScore(int score) {
//		this.score = score;
//	}

//	public Hand getHand() {
//		return hand;
//	}
//
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
}
