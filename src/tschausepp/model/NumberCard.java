package tschausepp.model;

/**
 * defines standard card
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public class NumberCard extends Card {
	
	/**
	 * alternative constructor
	 * 
	 * @param color
	 * @param value
	 */
	public NumberCard(CardColor color, CardValue value) {
		
		super(color, value);
		
		setType(CardType.NUMBER_CARD);
	}
}