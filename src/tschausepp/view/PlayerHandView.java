package tschausepp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tschausepp.model.Player;

/**
 * player hand view
 * 
 * @author	Clarissa Sullivan
 * @since	2020-07-03
 * @version	1.0
 */
@SuppressWarnings("serial")
public class PlayerHandView extends JPanel {
	
	private Player player;
	
	/**
	 * alternative constructor
	 * 
	 * @param player
	 */
	public PlayerHandView(Player player) {
		
		JLabel nameLabel;
		JPanel center, buttonPanel;
		
		setPlayer(player);
		
		setBorder(new LineBorder(Color.BLACK, 1));
		setLayout(new BorderLayout());
		
		nameLabel = new JLabel(getPlayer().getName());
		nameLabel.setFont(new Font(nameLabel.getFont().getFontName(), Font.PLAIN, 18));
		nameLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(9, 1));
		buttonPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new DrawCardButton(getPlayer()));
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new CallTschauButton(getPlayer()));
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new CallSeppButton(getPlayer()));
		
		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.add(new JScrollPane(new CardHandView(getPlayer())), BorderLayout.CENTER);
		center.add(buttonPanel, BorderLayout.EAST);
		
		add(nameLabel, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
	}
	
	/**
	 * getter for player
	 * 
	 * @return player
	 */
	public Player getPlayer() {
		
		return player;
	}
	
	/**
	 * setter for player
	 * 
	 * @param player
	 */
	private void setPlayer(Player player) {
		
		this.player = player;
	}
}