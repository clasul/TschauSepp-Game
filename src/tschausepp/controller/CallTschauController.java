package tschausepp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tschausepp.model.Player;

/**
 * call TSCHAU controller
 * 
 * @author	Clarissa Sullivan
 * @since	2020-07-03
 * @version	1.0
 */
public class CallTschauController implements ActionListener {

	private Player player;
	
	/**
	 * alternative constructor
	 * 
	 * @param player
	 */
	public CallTschauController(Player player) {
		
		setPlayer(player);
	}
	
	/**
	 * override actionPerformed method
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		getPlayer().callTschau();
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