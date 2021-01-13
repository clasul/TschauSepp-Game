package tschausepp.main;

import java.util.ArrayList;

import tschausepp.model.Board;
import tschausepp.model.Dealer;
import tschausepp.model.Player;
import tschausepp.view.GameFrame;

/**
 * main
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public class Main {
	
	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Board board;
		Dealer dealer;
		ArrayList<Player> players;
		
		board = new Board();
		
		players = new ArrayList<Player>();
		
		for (int i = 0; i < 4; i ++) {
			players.add(new Player("Player " + (i + 1), board));
		}
		
		for (int i = 0; i < players.size(); i ++) {
			players.get(i).setPlayers(players);
		}
		
		new GameFrame(board, players);
		
		dealer = new Dealer();
		dealer.spreadOut(players);
		dealer.addCardStack(board);
		
		players.get(0).startGame();
	}
}