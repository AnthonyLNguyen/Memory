/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_2;

/**
 * Engine of the game.
 * 
 * @author Anthony
 *
 */
public class GameEngine {

	private Grid gameBoard = new Grid();
	private boolean gameFinished = false;
	private boolean gameWon = false;
	private int matchedCards = 0;
	private int turns = 0;
	private boolean debug = false;

	public void fillBoard() {
		gameBoard.makeCards();
	}

	public void printBoard() {
		System.out.println(gameBoard.printGrid());
	}

	public void flipCards(int x1, int y1, int x2, int y2) {
		Card[][] board = gameBoard.getGrid();
		board[x1][y1].flip();
		board[x2][y2].flip();
	}

	/**
	 * 
	 * Tests two cards. Checks to see if they have already been matched and if
	 * they are the same card.
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void testMatch(int x1, int y1, int x2, int y2) {
		Card[][] board = gameBoard.getGrid();
		if ((board[x1][y1].isActivated()) || board[x2][y2].isActivated()) {
			System.out.println("You've selected a card you've already matched! Choose your first card again.");
		} else if (x1 == x2 && y1 == y2){
			System.out.println("You already picked that card! Choose your first card again.");
			board[x1][y1].unflip();
			board[x2][y2].unflip();
		} 
		else if (!(board[x1][y1].cardSymbol().equals(board[x2][y2].cardSymbol()))) {
			System.out.println("You've failed to match.");
			board[x1][y1].unflip();
			board[x2][y2].unflip();
			turns++;
		} else {
			System.out.println("You've matched the two [ " + board[x1][y1].cardSymbol() + " ] card!");
			board[x1][y1].activate();
			board[x2][y2].activate();
			matchedCards++;
			turns++;
		}
	}

	public boolean gameWon() {
		return gameWon;
	}

	public int getScore() {
		return matchedCards;
	}

	public void setScore(int matchedCards) {
		this.matchedCards = matchedCards;
	}

	public int getTurns() {
		return turns;
	}

	/**
	 * Enables debug mode if boolean {@link #debug} is false. Disable debug mode
	 * if boolean {@link #debug} is true.
	 */
	public void debug() {
		if (!debug) {
			for (Card[] a : gameBoard.getGrid()) {
				for (Card x : a) {
					x.flip();
				}
			}
			debug = true;
		} else {
			undebug();
			debug = false;
		}

	}

	/**
	 * Used to disable debug mode
	 */
	public void undebug() {
		for (Card[] a : gameBoard.getGrid()) {
			for (Card x : a) {
				x.unflip();
			}
		}

	}

	public void setGameWon(boolean gameWon) {
		this.gameWon = gameWon;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}
}
