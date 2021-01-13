package tschausepp.view;

import java.util.ArrayList;

import javax.swing.JFrame;

import tschausepp.model.Board;
import tschausepp.model.Player;

/**
 * JFrame to display the game
 * 
 * @author	Clarissa Sullivan
 * @since	2020-07-02
 * @version	1.0
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	
	/**
	 * alternative constructor
	 * 
	 * @param board
	 */
	public GameFrame(Board board, ArrayList<Player> players) {
		
		setTitle("Tschau Sepp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		getContentPane().add(new GameView(board, players));
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}