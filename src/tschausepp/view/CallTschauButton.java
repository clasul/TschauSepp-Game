package tschausepp.view;

import javax.swing.JButton;

import tschausepp.controller.CallTschauController;
import tschausepp.model.Player;

/**
 * button to call tschau
 * 
 * @author	Clarissa Sullivan
 * @since	2020-07-03
 * @version	1.0
 */
@SuppressWarnings("serial")
public class CallTschauButton extends JButton {
	
	/**
	 * alternate constructor
	 */
	public CallTschauButton(Player player) {
		
		setText("Call Tschau");
		addActionListener(new CallTschauController(player));
	}
}