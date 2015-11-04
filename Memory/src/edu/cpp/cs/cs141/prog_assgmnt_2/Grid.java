/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_2;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Anthony
 *
 *
 */
public class Grid {

	private Card[][] grid = new Card[4][4];

	public Card[][] getGrid() {
		return grid;
	}

	private ArrayList<Card> list = new ArrayList<Card>();

	/**
	 * Creates an array list of cards which is then filled with
	 * {@link #generateNumbers()} that was run with {@link #mixArray(int[])} in
	 * order to shuffle it
	 */
	public void makeCards() {

		int[] num = generateNumbers();

		for (int i = 0; i < 2; i++) {
			list.add(new CardAsterisk(false));
			list.add(new CardBang(false));
			list.add(new CardMinus(false));
			list.add(new CardOctothorpe(false));
			list.add(new CardPercent(false));
			list.add(new CardPlus(false));
			list.add(new CardQuestion(false));
			list.add(new CardSolidus(false));
		}

		int k = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = list.get(num[k]);
				k++;
			}
		}

	}

	/**
	 * 
	 * Shuffles an array randomly
	 * 
	 * @param array
	 * 
	 */
	private void mixArray(int[] array) {
		int index;
		int temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	/**
	 * @return an array of integers in order from 1 to 16
	 */
	public int[] generateNumbers() {
		int[] numbers = new int[16];
		for (int i = 0; i < 16; i++) {
			numbers[i] = i;

		}
		mixArray(numbers);
		return numbers;

	}

	/**
	 * @return the grid is printed out along with guide numbers on the side and
	 *         above the grid
	 */
	public String printGrid() {
		String s = "    0    1    2    3  \n";
		int row = 0;
		for (Card[] a : grid) {
			s += row + " ";
			row++;
			for (Card x : a) {
				s += "[ " + x.cardSymbol() + " ]";
			}
			s += "\n";
		}
		return s;
	}

}
