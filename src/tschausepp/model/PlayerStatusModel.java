package tschausepp.model;

import java.util.ArrayList;

/**
 * model for the status of the player
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public class PlayerStatusModel {
	
	private Player player;
	private PlayerStatus playerStatus;
	private ArrayList<PlayerStatusListener> listeners;
	
	/**
	 * default constructor
	 */
	public PlayerStatusModel(Player player) {
		
		setPlayer(player);
		setListeners(new ArrayList<PlayerStatusListener>());
	}
	
	/**
	 * add a listener
	 * 
	 * @param listener
	 */
	public void addListener(PlayerStatusListener listener) {
		
		getListeners().add(listener);
	}
	
	/**
	 * remove a listener
	 * 
	 * @param listener
	 */
	public void removeListener(PlayerStatusListener listener) {
		
		getListeners().remove(listener);
	}
	
	/**
	 * notify listeners when status has changed
	 */
	private void firePlayerStatusChanged() {
		
		for (int i = 0; i < getListeners().size(); i ++) {
			getListeners().get(i).playerStatusChanged(getPlayer(), getPlayerStatus());
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
	 * setter for player status
	 * 
	 * @param playerStatus
	 */
	public void setPlayerStatus(PlayerStatus playerStatus) {
		
		this.playerStatus = playerStatus;
		
		firePlayerStatusChanged();
	}
	
	/**
	 * getter for player status
	 * 
	 * @return playerStatus
	 */
	public PlayerStatus getPlayerStatus() {
		
		return playerStatus;
	}
	
	/**
	 * setter for listeners
	 * 
	 * @param listeners
	 */
	public void setListeners(ArrayList<PlayerStatusListener> listeners) {
		
		this.listeners = listeners;
	}
	
	/**
	 * getter for listeners
	 * 
	 * @return listeners
	 */
	public ArrayList<PlayerStatusListener> getListeners() {
		
		return listeners;
	}
}