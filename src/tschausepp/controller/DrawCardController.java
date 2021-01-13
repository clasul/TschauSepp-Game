package tschausepp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tschausepp.model.Player;

/**
 * draw card controller
 * 
 * @author	Clarissa Sullivan
 * @since	2020-07-02
 * @version	1.0
 */
public class DrawCardController implements ActionListener {
	
	private Player player;
	
	/**
	 * alternative constructor
	 * 
	 * @param player
	 */
	public DrawCardController(Player player) {
		
		setPlayer(player);
	}
	
	/**
	 * override actionPerformed method
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		getPlayer().drawCard();
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
}