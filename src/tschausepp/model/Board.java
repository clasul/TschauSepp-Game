package tschausepp.model;

import java.util.Collections;
import java.util.Stack;

import javax.swing.DefaultListModel;

/**
 * board which holds and displays the cards
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public class Board {
	
	private DefaultListModel<Card> laidCards;
	private Stack<Card> cardStack;
	
	/**
	 * default constructor
	 */
	public Board() {
		
		setLaidCards(new DefaultListModel<Card>());
	}
	
	/**
	 * obtain a card stack from the dealer
	 * 
	 * @param cardStack
	 */
	public void obtainCardStack(Stack<Card> cardStack) {
		
		setCardStack(cardStack);
		
		for (int i = 0; i < getCardStack().size(); i ++) {
			if (getCardStack().get(i).getType() == CardType.NUMBER_CARD) {
				addLaidCard(getCardStack().remove(i));
				return;
			}
		}
	}
	
	/**
	 * add a card to the laid cards
	 * 
	 * @param card
	 */
	public void addLaidCard(Card card) {
		
		getLaidCards().addElement(card);
		
		System.out.println("Card laid: " + card);
	}
	
	/**
	 * get a card from the card stack
	 * 
	 * @return card
	 */
	public Card getCardFromStack() {
		
		if (getCardStack().isEmpty()) {
			refillCardStack();
		}
		
		return getCardStack().pop();
	}
	
	/**
	 * get the card on top
	 * 
	 * @return card on top
	 */
	public Card getCardOnTop() {
		
		 return getLaidCards().lastElement();
	}
	
	/**
	 * getter for laid cards
	 * 
	 * @return laidCards
	 */
	public DefaultListModel<Card> getLaidCards() {
		
		return laidCards;
	}
	
	/**
	 * refill the card stack
	 */
	private void refillCardStack() {
		
		for (int i = 0; i < getLaidCards().size() - 1; i ++) {
			getCardStack().add(getLaidCards().remove(i));
		}
		
		Collections.shuffle(getCardStack());
	}
	
	/**
	 * getter for laid cards
	 * 
	 * @param laidCards
	 */
	private void setLaidCards(DefaultListModel<Card> laidCards) {
		
		this.laidCards = laidCards;
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