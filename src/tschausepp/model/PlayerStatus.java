package tschausepp.model;

/**
 * status of the player
 * 
 * @author	Clarissa Sullivan
 * @since	2020-07-02
 * @version	1.0
 */
public enum PlayerStatus {
	
	PLAYING,
	WAITING,
	WINNER,
	CANNOT_LAY_THIS_CARD,
	CANNOT_DRAW_CARD,
	CANNOT_CALL_TSCHAU,
	CALLING_TSCHAU,
	CANNOT_CALL_SEPP,
	CALLING_SEPP;
}