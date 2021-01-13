package tschausepp.model;

/**
 * player status listener, listens for the status of the player
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public interface PlayerStatusListener {
	
	public void playerStatusChanged(Player player, PlayerStatus newStatus);
}