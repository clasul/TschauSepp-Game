package tschausepp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tschausepp.model.Player;

/**
 * call SEPP controller
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public class CallSeppController implements ActionListener {

	private Player player;
	
	/**
	 * alternative constructor
	 * 
	 * @param player
	 */
	public CallSeppController(Player player) {
		
		setPlayer(player);
	}
	
	/**
	 * override actionPerformed method
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		getPlayer().callSepp();
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