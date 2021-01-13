package tschausepp.view;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import tschausepp.controller.CardController;
import tschausepp.model.Card;
import tschausepp.model.Player;

/**
 * provides view of player's card hand
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
@SuppressWarnings("serial")
public class CardHandView extends JList<Card> implements ListDataListener {
	
	private Player player;

	/**
	 * alternative constructor
	 */
	public CardHandView(Player player) {
		
		setPlayer(player);
		getPlayer().getCards().addListDataListener(this);
		
		setCellRenderer(new CardHandRenderer());
		setLayoutOrientation(JList.HORIZONTAL_WRAP);
		setVisibleRowCount(1);
		addListSelectionListener(new CardController(getPlayer(), this));
	}
	
	/**
	 * custom list cell renderer
	 */
	public class CardHandRenderer extends DefaultListCellRenderer {
		
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			
            JLabel label;
            
            label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setIcon(new CardView((Card) value).getScaledInstance());
            label.setText(null);
            
            return label;
		}
	}
	
	/**
	 * override method contents changed
	 */
	@Override
	public void contentsChanged(ListDataEvent e) {
		
		updateListContent();
	}
	
	/**
	 * override method interval added
	 */
	@Override
	public void intervalAdded(ListDataEvent e) {
		
		updateListContent();
	}
	
	/**
	 * override method interval removed
	 */
	@Override
	public void intervalRemoved(ListDataEvent e) {
		
		updateListContent();
	}
	
	/**
	 * reload the cards
	 */
	private void updateListContent() {
		
		Card[] cards;
		
		cards = new Card[getPlayer().getCards().size()];
		
		for (int i = 0; i < getPlayer().getCards().size(); i ++) {
			cards[i] = getPlayer().getCards().getElementAt(i);
		}
		
		setListData(cards);
		
		revalidate();
		repaint();
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