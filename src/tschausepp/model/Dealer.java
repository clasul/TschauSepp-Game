package tschausepp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * dealer who deals the cards
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public class Dealer {
	
	private Stack<Card> cardStack;
	
	/**
	 * default constructor
	 */
	public Dealer() {
		
		setCardStack(CardDeckFactory.generateCardDeck());
		shuffle();
	}
	
	/**
	 * spread out the cards to the players
	 * 
	 * @param players
	 */
	public void spreadOut(ArrayList<Player> players) {
		
		for (int i = 0; i < players.size(); i ++) {
			for (int j = 0; j < 7; j ++) {
				players.get(i).obtainCard(getCardStack().pop());
			}
		}
	}
	
	/**
	 * add card stack to the board
	 * 
	 * @param board
	 */
	public void addCardStack(Board board) {
		
		board.obtainCardStack(getCardStack());
	}
	
	/**
	 * shuffle the cards
	 */
	private void shuffle() {
		
		Collections.shuffle(getCardStack());
	}
	
	/**
	 * setter for card stack
	 * 
	 * @param cardStack
	 */
	private void setCardStack(Stack<Card> cardStack) {
		
		this.cardStack = cardStack;
	}
	
	/**
	 * getter for card stack
	 * 
	 * @return cardStack
	 */
	private Stack<Card> getCardStack() {
		
		return cardStack;
	}
}