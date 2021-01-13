package tschausepp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import tschausepp.model.Board;

/**
 * provides view of the board
 * 
 * @author	Clarissa Sullivan
 * @since	2020-07-03
 * @version	1.0
 */
@SuppressWarnings("serial")
public class BoardView extends JPanel implements ListDataListener {
	
	private Board board;
	
	/**
	 * alternative constructor
	 * 
	 * @param board
	 */
	public BoardView(Board board) {
		
		setBoard(board);
		getBoard().getLaidCards().addListDataListener(this);
		
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(500, 300));
		setBackground(new Color(50, 130, 20));
		setBorder(new LineBorder(new Color(40, 90, 10), 14));
		
		loadCardStack();
	}
	
	/**
	 * load the card stack
	 */
	private void loadCardStack() {
		
		JLabel label;
		Image image;
		
		try {
			image = ImageIO.read(new File("cards\\back_side\\BACK_SIDE.png")).getScaledInstance(242, 362, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			image = null;
			e.printStackTrace();
		}
		
		label = new JLabel(new ImageIcon(image.getScaledInstance(160, 240, Image.SCALE_DEFAULT)));
		label.setBorder(new EmptyBorder(10, 50, 0, 0));
		
		add(label);
	}
	
	/**
	 * load the laid cards
	 */
	private void loadLaidCards() {
		
		JLabel cardLabel;
		
		if (getComponentCount() == 2) {
			remove(0);
		}
		
		cardLabel = new JLabel(new CardView(getBoard().getCardOnTop()).getScaledInstance());
		cardLabel.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		add(cardLabel, 0);
	}
	
	/**
	 * override method contents changed
	 */
	@Override
	public void contentsChanged(ListDataEvent e) {
		
		loadLaidCards();
	}
	
	/**
	 * override method interval added
	 */
	@Override
	public void intervalAdded(ListDataEvent e) {
		
		loadLaidCards();
	}
	
	/**
	 * override method interval removed
	 */
	@Override
	public void intervalRemoved(ListDataEvent e) {
		
		loadLaidCards();
	}
	
	/**
	 * setter for board
	 * 
	 * @param board
	 */
	private void setBoard(Board board) {
		
		this.board = board;
	}
	
	/**
	 * getter for board
	 * 
	 * @return board
	 */
	private Board getBoard() {
		
		return board;
	}
}