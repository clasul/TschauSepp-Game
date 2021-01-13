package tschausepp.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import tschausepp.model.Card;
import tschausepp.model.CardType;

/**
 * finds which image to use for the cards
 * 
 * @author	Clarissa Sullivan
 * @since	2020-07-03
 * @version	1.0
 */
@SuppressWarnings("serial")
public class CardView extends ImageIcon {
	
	/**
	 * alternative constructor
	 * 
	 * @param card
	 */
	public CardView(Card card) {
		
		if (card.getType() == CardType.NUMBER_CARD) {
			try {
				setImage(ImageIO.read(new File("cards\\" + card.getColor() + "\\" + card.getColor() + "_" + card.getValue() + ".png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
	
	/**
	 * get a scaled instance of the image icon
	 * 
	 * @return scaled instance
	 */
	public ImageIcon getScaledInstance() {
		
		return new ImageIcon(getImage().getScaledInstance(160, 240, Image.SCALE_DEFAULT));
	}
}