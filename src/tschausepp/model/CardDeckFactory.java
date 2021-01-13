package tschausepp.model;

import java.util.Stack;

/**
 * class to generate a card deck
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public class CardDeckFactory {
	
	/**
	 * generate a card deck
	 * 
	 * @return cardDeck
	 */
	public static Stack<Card> generateCardDeck() {
		
		Stack<Card> cardDeck;
		
		cardDeck = new Stack<Card>();
		
		for (int i = 0; i < 2; i ++) {
			cardDeck.add(new NumberCard(CardColor.SCHAUFEL_CARD, CardValue.NUM_10));
			cardDeck.add(new NumberCard(CardColor.SCHAUFEL_CARD, CardValue.NUM_9));
			cardDeck.add(new NumberCard(CardColor.SCHAUFEL_CARD, CardValue.NUM_8));
			cardDeck.add(new NumberCard(CardColor.SCHAUFEL_CARD, CardValue.NUM_7));
			cardDeck.add(new NumberCard(CardColor.SCHAUFEL_CARD, CardValue.NUM_6));
			cardDeck.add(new NumberCard(CardColor.SCHAUFEL_CARD, CardValue.NUM_BUBE));
			cardDeck.add(new NumberCard(CardColor.SCHAUFEL_CARD, CardValue.NUM_DAME));
			cardDeck.add(new NumberCard(CardColor.SCHAUFEL_CARD, CardValue.NUM_KOENIG));
			cardDeck.add(new NumberCard(CardColor.SCHAUFEL_CARD, CardValue.NUM_ASS));
		}
		
		for (int i = 0; i < 2; i ++) {
			cardDeck.add(new NumberCard(CardColor.HERZ_CARD, CardValue.NUM_10));
			cardDeck.add(new NumberCard(CardColor.HERZ_CARD, CardValue.NUM_9));
			cardDeck.add(new NumberCard(CardColor.HERZ_CARD, CardValue.NUM_8));
			cardDeck.add(new NumberCard(CardColor.HERZ_CARD, CardValue.NUM_7));
			cardDeck.add(new NumberCard(CardColor.HERZ_CARD, CardValue.NUM_6));
			cardDeck.add(new NumberCard(CardColor.HERZ_CARD, CardValue.NUM_BUBE));
			cardDeck.add(new NumberCard(CardColor.HERZ_CARD, CardValue.NUM_DAME));
			cardDeck.add(new NumberCard(CardColor.HERZ_CARD, CardValue.NUM_KOENIG));
			cardDeck.add(new NumberCard(CardColor.HERZ_CARD, CardValue.NUM_ASS));
		}
		

		for (int i = 0; i < 2; i ++) {
			cardDeck.add(new NumberCard(CardColor.KREUZ_CARD, CardValue.NUM_10));
			cardDeck.add(new NumberCard(CardColor.KREUZ_CARD, CardValue.NUM_9));
			cardDeck.add(new NumberCard(CardColor.KREUZ_CARD, CardValue.NUM_8));
			cardDeck.add(new NumberCard(CardColor.KREUZ_CARD, CardValue.NUM_7));
			cardDeck.add(new NumberCard(CardColor.KREUZ_CARD, CardValue.NUM_6));
			cardDeck.add(new NumberCard(CardColor.KREUZ_CARD, CardValue.NUM_BUBE));
			cardDeck.add(new NumberCard(CardColor.KREUZ_CARD, CardValue.NUM_DAME));
			cardDeck.add(new NumberCard(CardColor.KREUZ_CARD, CardValue.NUM_KOENIG));
			cardDeck.add(new NumberCard(CardColor.KREUZ_CARD, CardValue.NUM_ASS));
		}
		
		
		for (int i = 0; i < 2; i ++) {
			cardDeck.add(new NumberCard(CardColor.ECKE_CARD, CardValue.NUM_10));
			cardDeck.add(new NumberCard(CardColor.ECKE_CARD, CardValue.NUM_9));
			cardDeck.add(new NumberCard(CardColor.ECKE_CARD, CardValue.NUM_8));
			cardDeck.add(new NumberCard(CardColor.ECKE_CARD, CardValue.NUM_7));
			cardDeck.add(new NumberCard(CardColor.ECKE_CARD, CardValue.NUM_6));
			cardDeck.add(new NumberCard(CardColor.ECKE_CARD, CardValue.NUM_BUBE));
			cardDeck.add(new NumberCard(CardColor.ECKE_CARD, CardValue.NUM_DAME));
			cardDeck.add(new NumberCard(CardColor.ECKE_CARD, CardValue.NUM_KOENIG));
			cardDeck.add(new NumberCard(CardColor.ECKE_CARD, CardValue.NUM_ASS));
		}
		
		
		return cardDeck;
	}
}