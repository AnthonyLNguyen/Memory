/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_2;

/**
 * This class represents a card on the memory grid. Instances of this class have
 * an attribute {@link #isFlipped} which means the card is physically flipped.
 * Another attribute {@link #isActivated} means that a card has been activated
 * and matched correctly by the player.
 * 
 * @author Anthony
 *
 *
 */
public abstract class Card {

	/**
	 * Tells whether or not the card is physically turned over.
	 */
	private boolean isFlipped;

	/**
	 * Tells that the card has been correctly matched with its pair.
	 */
	private boolean isActivated = false;

	private String symbol;

	public Card(boolean f) {
		setFlipped(f);
	}

	public String cardSymbol() {
		return (isActivated() || isFlipped()) ? symbol : "X";
	}

	public boolean isFlipped() {
		return isFlipped;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setFlipped(boolean isFlipped) {
		this.isFlipped = isFlipped;
	}

	/**
	 * This method permanently 'activates' the card so the card has now been matched.
	 */
	public void activate() {
		isActivated = true;
	}

	/**
	 * This method 'flips' the card which makes it visible.
	 */
	public void flip() {
		isFlipped = true;
	}

	/**
	 * This method 'unflips' the card which makes it no longer visible.
	 */
	public void unflip() {
		isFlipped = false;

	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
