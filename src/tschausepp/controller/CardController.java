package tschausepp.controller;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tschausepp.model.Card;
import tschausepp.model.Player;

/**
 * card controller
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public class CardController implements ListSelectionListener {
	
	private Player player;
	private JList<Card> cards;
	
	/**
	 * alternative constructor
	 * 
	 * @param player
	 */
	public CardController(Player player, JList<Card> cards) {
		
		setPlayer(player);
		setCards(cards);
	}
	
	/**
	 * override value changed method
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if (e.getValueIsAdjusting()) {
			if (getCards().getSelectedValue() != null) {
				getPlayer().layCard(getCards().getSelectedValue());
			}
		}
	}
	
	/**
	 * setter for player
	 * 
	 * @param player
	 */
	private void setPlayer(Player player) {
		
		this.player = player;
	}
	
	/**
	 * getter for player
	 * 
	 * @return player
	 */
	private Player getPlayer() {
		
		return player;
	}
	
	/**
	 * setter for cards
	 * 
	 * @param cards
	 */
	private void setCards(JList<Card> cards) {
		
		this.cards = cards;
	}
	
	/**
	 * getter for cards
	 * 
	 * @return cards
	 */
	private JList<Card> getCards() {
		
		return cards;
	}
}