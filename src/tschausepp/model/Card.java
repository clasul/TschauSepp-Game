package tschausepp.model;

/**
 * class to define different cards
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public abstract class Card {
	
	protected CardColor color;
	protected CardValue value;
	protected CardType type;
	
	/**
	 * alternative constructor
	 * 
	 * @param color
	 * @param value
	 */
	public Card(CardColor color, CardValue value) {
		
		setColor(color);
		setValue(value);
	}
	
	/**
	 * getter for color
	 * 
	 * @return color
	 */
	public CardColor getColor() {
		
		return color;
	}
	
	/**
	 * getter for value
	 * 
	 * @return value
	 */
	public CardValue getValue() {
		
		return value;
	}
	
	/**
	 * getter for type
	 * 
	 * @return type
	 */
	public CardType getType() {
		
		return type;
	}
	
	/**
	 * setter for color
	 * 
	 * @param color
	 */
	protected void setColor(CardColor color) {
		
		this.color = color;
	}
	
	/**
	 * setter for value
	 * 
	 * @param value
	 */
	protected void setValue(CardValue value) {
		
		this.value = value;
	}
	
	/**
	 * setter for type
	 * 
	 * @param type
	 */
	protected void setType(CardType type) {
		
		this.type = type;
	}
	
	/**
	 * override toString method
	 */
	@Override
	public String toString() {
		
		return getColor() + ", " + getValue();
	}
}