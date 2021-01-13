package tschausepp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import tschausepp.model.Player;
import tschausepp.model.PlayerStatus;
import tschausepp.model.PlayerStatusListener;

/**
 * provides card holder view
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
@SuppressWarnings("serial")
public class CardHolderView extends JLayeredPane implements PlayerStatusListener, ListDataListener {
	
	private Player player;
	
	/**
	 * alternative constructor
	 * 
	 * @param player
	 */
	public CardHolderView(Player player) {
		
		setPlayer(player);
		getPlayer().getStatus().addListener(this);
		getPlayer().getCards().addListDataListener(this);
		
		setPreferredSize(new Dimension(600, 200));
		setBackground(Color.GRAY);
		setOpaque(true);
		setBorder(new LineBorder(Color.BLACK, 5));
		
		add(getNameLabel());
	}
	
	/**
	 * display the cards
	 */
	private void displayCards() {
		
		int counter;
		BufferedImage image;
		ImageIcon imageIcon;
		
		try {
			image = ImageIO.read(new File(".\\cards\\back_side\\BACK_SIDE.png"));
		} catch (IOException e) {
			image = null;
			e.printStackTrace();
		}
		
		imageIcon = new ImageIcon(image.getScaledInstance(image.getWidth() / 5, image.getHeight() / 5, Image.SCALE_DEFAULT));
		
		counter = 300 - imageIcon.getIconWidth() / 4;
		
		for (int i = 0; i < getPlayer().getCards().size(); i ++) {
			JLabel label;
			
			if (i == 0) {
				counter -= 50 * getPlayer().getCards().size() / 2;
				
				if (counter < 15) {
					counter = 15;
				}
			} else {
				counter += 50;
			}
			
			label = new JLabel(imageIcon);
			label.setBounds(counter, 50, imageIcon.getIconWidth(), imageIcon.getIconHeight());
			
			add(label);
		}
	}
	
	/**
	 * override method player status changed
	 */
	@Override
	public void playerStatusChanged(Player player, PlayerStatus newStatus) {
		
		if (player == getPlayer()) {
			if (newStatus == PlayerStatus.WAITING) {
				displayCards();
			}
			else if (newStatus == PlayerStatus.PLAYING) {
				removeAll();
				
				add(getNameLabel());
			}
		}
	}
	
	/**
	 * override method contents changed
	 */
	@Override
	public void contentsChanged(ListDataEvent e) {
		
		// this method is not needed
	}
	
	/**
	 * override method interval added
	 */
	@Override
	public void intervalAdded(ListDataEvent e) {
		
		if (getPlayer().getStatus().getPlayerStatus() == null && getPlayer().getCards().size() == 7) {
			displayCards();
		}
	}
	
	/**
	 * override method interval removed
	 */
	@Override
	public void intervalRemoved(ListDataEvent e) {
		
		// this method is not needed
	}
	
	/**
	 * get name label of the player
	 * 
	 * @return nameLabel
	 */
	private JLabel getNameLabel() {
		
		JLabel nameLabel;
		
		nameLabel = new JLabel(player.getName());
		nameLabel.setFont(new Font(nameLabel.getFont().getFontName(), Font.PLAIN, 18));
		nameLabel.setBounds(262, 15, 100, 20);
		
		return nameLabel;
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