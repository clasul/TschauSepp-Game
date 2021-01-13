package tschausepp.view;

import javax.swing.JButton;

import tschausepp.controller.DrawCardController;
import tschausepp.model.Player;

/**
 * button for drawing a card
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
@SuppressWarnings("serial")
public class DrawCardButton extends JButton {
	
	/**
	 * alternate constructor
	 */
	public DrawCardButton(Player player) {
		
		setText("Draw Card");
		addActionListener(new DrawCardController(player));
	}
}