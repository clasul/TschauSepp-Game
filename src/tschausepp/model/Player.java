package tschausepp.model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * actions of the defined player in game
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public class Player {
	
	private boolean cardLaid;
	private boolean tschauCalled;
	private boolean seppCalled;
	private boolean skipNextPlayer;
	private int cardsToDraw;
	private Direction direction;
	private CardColor desiredColor;
	private Board board;
	private String name;
	private DefaultListModel<Card> cards;
	private PlayerStatusModel status;
	private ArrayList<Player> players;
	
	/**
	 * alternative constructor
	 * 
	 * @param name
	 * @param board
	 */
	public Player(String name, Board board) {
		
		setName(name);
		setBoard(board);
		setCards(new DefaultListModel<Card>());
		setStatus(new PlayerStatusModel(this));
	}
	
	/**
	 * start the game
	 */
	public void startGame() {
		
		playTurn(0, Direction.CLOCKWISE_ROTATION, null);
	}
	
	/**
	 * start of the player turn
	 * 
	 * @param cardsToDraw
	 * @param direction
	 */
	public void playTurn(int cardsToDraw, Direction direction, CardColor desiredColor) {
		
		setCardsToDraw(cardsToDraw);
		setDirection(direction);
		setDesiredColor(desiredColor);
		
		setCardLaid(false);
		setTschauCalled(false);
		setSeppCalled(false);
		setSkipNextPlayer(false);
		
		getStatus().setPlayerStatus(PlayerStatus.PLAYING);
		
		sortCards();
		
		System.out.println("My turn: " + getName());
	}
	
	/**
	 * add a card to the cards
	 * 
	 * @param card
	 */
	public void obtainCard(Card card) {
		
		getCards().addElement(card);
	}
	
	/**
	 * lay a card
	 * 
	 * @param card
	 */
	public void layCard(Card card) {
		
		if (isValid(card)) {
			
			
			board.addLaidCard(getCards().remove(getCards().indexOf(card)));
			
			setCardLaid(true);
			
			finishTurn();
		} else {
			getStatus().setPlayerStatus(PlayerStatus.CANNOT_LAY_THIS_CARD);
			
			System.out.println("You can't lay this card!");
		}
	}
	
	/**
	 * draw a card
	 */
	public void drawCard() {
		
		if (!canLayCard()) {
			Card drawnCard;
			
			drawnCard = getBoard().getCardFromStack();
			
			if (isValid(drawnCard)) {

				
				getBoard().addLaidCard(drawnCard);
			} else {
				obtainCard(drawnCard);
			}
			
			finishTurn();
		} else {
			getStatus().setPlayerStatus(PlayerStatus.CANNOT_DRAW_CARD);
			
			System.out.println("You can't draw a card right now!");
		}
	}
	
	/**
	 * call tschau
	 */
	public void callTschau() {
		
		if (getCards().size() == 2 && canLayCard()) {
			setTschauCalled(true);
			getStatus().setPlayerStatus(PlayerStatus.CALLING_TSCHAU);
			
			System.out.println(getName() + ": Sepp!");
		} else {
			getStatus().setPlayerStatus(PlayerStatus.CANNOT_CALL_TSCHAU);
			
			System.out.println("You cannot call Tschau!");
		}
	}
	
	public void callSepp() {
		
		if (getCards().size() == 1 && canLayCard()) {
			setTschauCalled(true);
			getStatus().setPlayerStatus(PlayerStatus.CALLING_SEPP);
			
			System.out.println(getName() + ": Sepp!");
		} else {
			getStatus().setPlayerStatus(PlayerStatus.CANNOT_CALL_SEPP);
			
			System.out.println("You cannot call Sepp!");
		}
	}
	
	/**
	 * setter for players
	 * 
	 * @param players
	 */
	public void setPlayers(ArrayList<Player> players) {
		
		this.players = players;
	}
	
	/**
	 * getter for name
	 * 
	 * @return name
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * getter for cards
	 * 
	 * @return cards
	 */
	public DefaultListModel<Card> getCards() {
		
		return cards;
	}
	
	/**
	 * getter for status
	 * 
	 * @return status
	 */
	public PlayerStatusModel getStatus() {
		
		return status;
	}
	
	/**
	 * obtain cards from the board
	 * 
	 * @param counter
	 */
	private void obtainCards(int counter) {
		
		for (int i = 0; i < counter; i ++) {
			getCards().addElement(getBoard().getCardFromStack());
		}
	}
	
	/**
	 * skip the next player
	 */
	private void skipNextPlayer() {
		
		setSkipNextPlayer(true);
	}
	
	/**
	 * add cards to draw
	 * 
	 * @param cardsToDraw
	 */
	private void addCardsToDraw(int cardsToDraw) {
		
		setCardsToDraw(getCardsToDraw() + cardsToDraw);
	}
	
	/**
	 * change the direction
	 */
	private void changeDirection() {
		
		if (getDirection() == Direction.CLOCKWISE_ROTATION) {
			setDirection(Direction.COUNTERCLOCKWISE_ROTATION);
		} else {
			setDirection(Direction.CLOCKWISE_ROTATION);
		}
	}
	
	/**
	 * end of the player turn
	 */
	private void finishTurn() {
		
		if (!hasCards()) {
			getStatus().setPlayerStatus(PlayerStatus.WINNER);
			
			System.out.println(getName() + " won!");
		}
		else if (getCards().size() == 2) {
			if (!hasCalledSepp()) {
				obtainCards(4);
			}
		}
		
		else if (getCards().size() == 1) {
			if (!hasCalledSepp()) {
				obtainCards(2);
			}
		}
		
		if (getCardsToDraw() > 0) {
			if (!hasLaidCard()) {
				obtainCards(getCardsToDraw());
				setCardsToDraw(0);
			 
			}
		}
		
		getStatus().setPlayerStatus(PlayerStatus.WAITING);
		
		switchTurn();
	}
	
	/**
	 * switch the current player
	 */
	private void switchTurn() {
		
		if (getDirection() == Direction.CLOCKWISE_ROTATION) {
			if (!getSkipNextPlayer()) {
				if (getPlayerIndex() == 0 || getPlayerIndex() == 1 || getPlayerIndex() == 2) {
					getPlayers().get(getPlayerIndex() + 1).playTurn(getCardsToDraw(), getDirection(), getDesiredColor());
				} else {
					getPlayers().get(0).playTurn(getCardsToDraw(), getDirection(), getDesiredColor());
				}
			} else {
				if (getPlayerIndex() == 0 || getPlayerIndex() == 1) {
					getPlayers().get(getPlayerIndex() + 2).playTurn(getCardsToDraw(), getDirection(), getDesiredColor());
				}
				else if (getPlayerIndex() == 2) {
					getPlayers().get(0).playTurn(getCardsToDraw(), getDirection(), getDesiredColor());
				} else {
					getPlayers().get(1).playTurn(getCardsToDraw(), getDirection(), getDesiredColor());
				}
			}
		} else {
			if (!getSkipNextPlayer()) {
				if (getPlayerIndex() == 1 || getPlayerIndex() == 2 || getPlayerIndex() == 3) {
					getPlayers().get(getPlayerIndex() - 1).playTurn(getCardsToDraw(), getDirection(), getDesiredColor());
				} else {
					getPlayers().get(3).playTurn(getCardsToDraw(), getDirection(), getDesiredColor());
				}
			} else {
				if (getPlayerIndex() == 2 || getPlayerIndex() == 3) {
					getPlayers().get(getPlayerIndex() - 2).playTurn(getCardsToDraw(), getDirection(), getDesiredColor());
				}
				else if (getPlayerIndex() == 1) {
					getPlayers().get(3).playTurn(getCardsToDraw(), getDirection(), getDesiredColor());
				} else {
					getPlayers().get(2).playTurn(getCardsToDraw(), getDirection(), getDesiredColor());
				}
			}
		}
	}
	
	/**
	 * sort the cards
	 */
	private void sortCards() {
		
		boolean orderChanged;
		
		orderChanged = true;
		
		while (orderChanged) {
			
			orderChanged = false;
			
			for (int i = 0; i < getCards().size(); i ++) {
				if (i < getCards().size() - 1) {
					if (getCards().getElementAt(i).getColor().getSortingValue() > getCards().getElementAt(i + 1).getColor().getSortingValue()) {
						swapCards(i, i + 1);
						orderChanged = true;
					}
				}
			}
		}
		
		orderChanged = true;
		
		while (orderChanged) {
			
			orderChanged = false;
			
			for (int i = 0; i < getCards().size(); i ++) {
				if (i < getCards().size() - 1) {
					if (getCards().get(i).getColor() == getCards().get(i + 1).getColor()) {
						if (getCards().get(i).getValue().getSortingValue() > getCards().get(i + 1).getValue().getSortingValue()) {
							swapCards(i, i + 1);
							orderChanged = true;
						}
					}
				}
			}
		}
	}
	
	/**
	 * swap two cards
	 * 
	 * @param cards
	 * @param i
	 * @param j
	 */
	private void swapCards(int i, int j) {
		
		Card tempCard;
		
		tempCard = getCards().getElementAt(i + 1);
		
		getCards().set(i + 1, getCards().getElementAt(i));
		getCards().set(i, tempCard);
	}
	
	/**
	 * checks whether a card is valid or not
	 * 
	 * @param card
	 * @return valid
	 */
	private boolean isValid(Card card) {
		
		if (card.getType() == CardType.NUMBER_CARD) {
			return true;
		} else {
			if (getBoard().getCardOnTop().getType() != CardType.NUMBER_CARD) {
				if (getBoard().getCardOnTop().getColor() == card.getColor() || getBoard().getCardOnTop().getValue() == card.getValue()) {
					return true;
				} else {
					return false;
				}
			} else {
				if (getDesiredColor() == card.getColor() || getBoard().getCardOnTop().getValue() == card.getValue()) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
	/**
	 * checks whether the player can lay a card or not
	 * 
	 * @return true if can lay card
	 */
	private boolean canLayCard() {
		
		for (int i = 0; i < getCards().size(); i ++) {
			if (isValid(getCards().get(i))) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * checks whether the player has laid a card or not
	 * 
	 * @return cardLaid
	 */
	private boolean hasLaidCard() {
		
		return getCardLaid();
	}
	
	/**
	 * checks whether the player has called tschau or not
	 * 
	 * @return unoCalled
	 */
	private boolean hasCalledTschau() {
		
		return getTschauCalled();
	}
	
	/**
	 * checks whether the player has called sepp or not
	 * 
	 * @return unoCalled
	 */
	private boolean hasCalledSepp() {
		
		return getSeppCalled();
	}
	
	/**
	 * checks whether the player has cards or not
	 * 
	 * @return true if this list contains no elements
	 */
	private boolean hasCards() {
		
		return !getCards().isEmpty();
	}
	
	/**
	 * get the player index in the player array
	 * 
	 * @return index
	 */
	private int getPlayerIndex() {
		
		for (int i = 0; i < getPlayers().size(); i ++) {
			if (getPlayers().get(i) == this) {
				return i;
			}
		}
		
		return 0;
	}
	
	/**
	 * setter for card laid
	 * 
	 * @param cardLaid
	 */
	private void setCardLaid(boolean cardLaid) {
		
		this.cardLaid = cardLaid;
	}
	
	/**
	 * getter for card laid
	 * 
	 * @return cardLaid
	 */
	private boolean getCardLaid() {
		
		return cardLaid;
	}
	
	/**
	 * setter for tschau called
	 * 
	 * @param tschauCalled
	 */
	private void setTschauCalled(boolean tschauCalled) {
		
		this.tschauCalled = tschauCalled;
	}
	
	/**
	 * getter for tschau called
	 * 
	 * @return tschauCalled
	 */
	private boolean getTschauCalled() {
		
		return tschauCalled;
	}
	
	/**
	 * setter for sepp called
	 * 
	 * @param tschauCalled
	 */
	private void setSeppCalled(boolean seppCalled) {
		
		this.tschauCalled = seppCalled;
	}
	
	/**
	 * getter for sepp called
	 * 
	 * @return tschauCalled
	 */
	private boolean getSeppCalled() {
		
		return seppCalled;
	}
	
	/**
	 * setter for skip next player
	 * 
	 * @param skipNextPlayer
	 */
	private void setSkipNextPlayer(boolean skipNextPlayer) {
		
		this.skipNextPlayer = skipNextPlayer;
	}
	
	/**
	 * getter for skip next player
	 * 
	 * @return skipNextPlayer
	 */
	private boolean getSkipNextPlayer() {
		
		return skipNextPlayer;
	}
	
	/**
	 * setter for cards to draw
	 * 
	 * @param cardsToDraw
	 */
	private void setCardsToDraw(int cardsToDraw) {
		
		this.cardsToDraw = cardsToDraw;
	}
	
	/**
	 * getter for cards to draw
	 * 
	 * @return cardsToDraw
	 */
	private int getCardsToDraw() {
		
		return cardsToDraw;
	}
	
	/**
	 * setter for direction
	 * 
	 * @param direction
	 */
	private void setDirection(Direction direction) {
		
		this.direction = direction;
	}
	
	/**
	 * getter for direction
	 * 
	 * @return direction
	 */
	private Direction getDirection() {
		
		return direction;
	}
	
	/**
	 * setter for desired color
	 * 
	 * @param desiredColor
	 */
	private void setDesiredColor(CardColor desiredColor) {
		
		this.desiredColor = desiredColor;
	}
	
	/**
	 * getter for desired color
	 * 
	 * @return desiredColor
	 */
	private CardColor getDesiredColor() {
		
		return desiredColor;
	}
	
	/**
	 * setter for board
	 * 
	 * @param board
	 */
	private void setBoard(Board board) {
		
		this.board = board;
	}
	
	/**
	 * getter for board
	 * 
	 * @return board
	 */
	private Board getBoard() {
		
		return board;
	}
	
	/**
	 * setter for name
	 * 
	 * @param name
	 */
	private void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * setter for cards
	 * 
	 * @param cards
	 */
	private void setCards(DefaultListModel<Card> cards) {
		
		this.cards = cards;
	}
	
	/**
	 * setter for status
	 * 
	 * @param status
	 */
	private void setStatus(PlayerStatusModel status) {
		
		this.status = status;
	}
	
	/**
	 * getter for players
	 * 
	 * @return players
	 */
	private ArrayList<Player> getPlayers() {
		
		return players;
	}
}