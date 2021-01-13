package tschausepp.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tschausepp.model.Board;
import tschausepp.model.Player;
import tschausepp.model.PlayerStatus;
import tschausepp.model.PlayerStatusListener;

/**
 * game view
 * 
 * @author	Clarissa Sullivan
 * @since	2020-07-03
 * @version	1.0
 */
@SuppressWarnings("serial")
public class GameView extends JPanel implements PlayerStatusListener {
	
	private ArrayList<PlayerHandView> playerHands;
	
	/**
	 * alternative constructor
	 */
	public GameView(Board board, ArrayList<Player> players) {
		
		JPanel center, boardContainer, cardHolderPlayer1Container, cardHolderPlayer2Container, cardHolderPlayer3Container, cardHolderPlayer4Container;
		
		setPlayerHands(new ArrayList<PlayerHandView>());
		
		boardContainer = new JPanel();
		boardContainer.add(new BoardView(board));
		
		cardHolderPlayer1Container = new JPanel();
		cardHolderPlayer1Container.add(new CardHolderView(players.get(0)));
		
		cardHolderPlayer2Container = new JPanel();
		cardHolderPlayer2Container.setBorder(new EmptyBorder(40, 0, 0, 20));
		cardHolderPlayer2Container.add(new CardHolderView(players.get(1)));
		
		cardHolderPlayer3Container = new JPanel();
		cardHolderPlayer3Container.add(new CardHolderView(players.get(2)));
		
		cardHolderPlayer4Container = new JPanel();
		cardHolderPlayer4Container.setBorder(new EmptyBorder(40, 20, 0, 0));
		cardHolderPlayer4Container.add(new CardHolderView(players.get(3)));
		
		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.add(boardContainer, BorderLayout.CENTER);
		center.add(cardHolderPlayer1Container, BorderLayout.NORTH);
		center.add(cardHolderPlayer2Container, BorderLayout.EAST);
		center.add(cardHolderPlayer3Container, BorderLayout.SOUTH);
		center.add(cardHolderPlayer4Container, BorderLayout.WEST);
		
		setLayout(new BorderLayout());
		
		add(center, BorderLayout.CENTER);
		
		for (int i = 0; i < players.size(); i ++) {
			players.get(i).getStatus().addListener(this);
			getPlayerHands().add(new PlayerHandView(players.get(i)));
		}
	}
	
	/**
	 * update when player status changed
	 */
	@Override
	public void playerStatusChanged(Player player, PlayerStatus newStatus) {
		
		if (newStatus == PlayerStatus.PLAYING) {
			for (int i = 0; i < getPlayerHands().size(); i ++) {
				if (player == getPlayerHands().get(i).getPlayer()) {
					add(getPlayerHands().get(i), BorderLayout.SOUTH);
					revalidate();
					repaint();
				}
			}
		}
		else if (newStatus == PlayerStatus.WAITING) {
			for (int i = 0; i < getPlayerHands().size(); i ++) {
				if (player == getPlayerHands().get(i).getPlayer()) {
					remove(getPlayerHands().get(i));
					revalidate();
					repaint();
				}
			}
		}
		else if (newStatus == PlayerStatus.WINNER) {
			JOptionPane.showMessageDialog(this, player.getName() + " won!", "Game Finished", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		else if (newStatus == PlayerStatus.CANNOT_LAY_THIS_CARD) {
			JOptionPane.showMessageDialog(this, "You can't lay this card!", "Lay Card", JOptionPane.WARNING_MESSAGE);
		}
		else if (newStatus == PlayerStatus.CANNOT_DRAW_CARD) {
			JOptionPane.showMessageDialog(this, "You can't draw a card right now!", "Draw Card", JOptionPane.WARNING_MESSAGE);
		}
		else if (newStatus == PlayerStatus.CANNOT_CALL_TSCHAU) {
			JOptionPane.showMessageDialog(this, "You can't call Tschau right now!", "Call Tschau", JOptionPane.WARNING_MESSAGE);
		}
		else if (newStatus == PlayerStatus.CALLING_TSCHAU) {
			JOptionPane.showMessageDialog(this, player.getName() + ": Tschau!", "Call Tschau", JOptionPane.INFORMATION_MESSAGE);		
		}
		else if (newStatus == PlayerStatus.CANNOT_CALL_SEPP) {
				JOptionPane.showMessageDialog(this, "You can't call Sepp right now!", "Call Sepp", JOptionPane.WARNING_MESSAGE);
		}
		else if (newStatus == PlayerStatus.CALLING_SEPP) {
				JOptionPane.showMessageDialog(this, player.getName() + ": Sepp!", "Call Sepp", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * setter for player hands
	 * 
	 * @param playerHands
	 */
	private void setPlayerHands(ArrayList<PlayerHandView> playerHands) {
		
		this.playerHands = playerHands;
	}
	
	/**
	 * getter for player hands
	 * 
	 * @return playerHands
	 */
	private ArrayList<PlayerHandView> getPlayerHands() {
		
		return playerHands;
	}
}