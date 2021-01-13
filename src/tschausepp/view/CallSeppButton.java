package tschausepp.view;

import javax.swing.JButton;

import tschausepp.controller.CallTschauController;
import tschausepp.model.Player;

/**
 * button to call tschau
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
@SuppressWarnings("serial")
public class CallSeppButton extends JButton {
	
	/**
	 * alternate constructor
	 */
	public CallSeppButton(Player player) {
		
		setText("Call Sepp");
		addActionListener(new CallTschauController(player));
	}
}