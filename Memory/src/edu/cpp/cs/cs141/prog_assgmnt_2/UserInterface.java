package edu.cpp.cs.cs141.prog_assgmnt_2;

import java.util.Scanner;

import edu.cpp.cs.cs141.prog_assgmnt_2.GameEngine;

/**
 * UI of the game.
 * 
 * @author Anthony
 *
 */
public class UserInterface {

	private GameEngine game = null;
	private Scanner keyboard = null;

	public UserInterface(GameEngine game) {
		this.game = game;
		keyboard = new Scanner(System.in);
	}

	/**
	 * Prints a welcome message
	 */
	public void welcome() {
		System.out.println("Welcome to memory!");
		System.out.println("Match 8 sets of cards! \n");
	}

	/**
	 * @return Asks the user if the user wants to start a game or quit.
	 */
	public int menuSelection() {
		if (!game.isGameFinished()) {
			int option = 2;

			System.out.println("Select an option:\n" + "\t1. Start New Game.\n" + "\t2. Quit.");

			option = keyboard.nextInt();
			keyboard.nextLine();

			return option;
		}
		return 2;
	}

	/**
	 * Starts the game printing the welcome message with {@link #welcome()} and
	 * then enters the game loop with {@link #gameLoop()}
	 */
	public void startGame() {
		welcome();

		boolean quit = false;
		while (!quit) {

			switch (menuSelection()) {
			case 1:
				gameLoop();
				break;
			case 2:
				quit = true;
				System.out.println("GAME QUIT");
				break;
			default:
				System.out.println("Invalid option. Try again...");
				break;
			}
		}
		keyboard.close();
	}

	/**
	 * Handles the input of coordinates for the grid.
	 */
	public void chooseCoords() {
		System.out.println("Please enter first coordinates seperated by a space: ");
		int a = keyboard.nextInt();
		int b = keyboard.nextInt();
		game.flipCards(a, b, a, b);
		game.printBoard();
		System.out.println("Please enter second coordinates seperated by a space: ");
		int c = keyboard.nextInt();
		int d = keyboard.nextInt();
		game.flipCards(a, b, c, d);
		game.printBoard();
		game.testMatch(a, b, c, d);

	}

	/**
	 * Constantly asks for coordinates and prints the game board afterwards
	 */
	public void gameLoop() {
		if (!game.gameWon()) {
			game.fillBoard();
			game.printBoard();
		}
		while (!game.gameWon()) {
			chooseCoords();
			pause();
			game.printBoard();
			System.out.println("Score: " + game.getScore());
			System.out.println("Turns: " + game.getTurns() + "\n");
			if (game.getScore() == 8) {
				gameEnd();
			}

		}
	}

	/**
	 * Ends the game
	 */
	public void gameEnd() {
		if (game.getScore() == 8) {
			System.out.println("NICE, you finished the game in " + game.getTurns() + " turns!");
			game.setGameWon(true);
			game.setGameFinished(true);
		} else {
			System.out.println("GAME END");
		}
	}

	/**
	 * Shows the possible options after one round with hidden command 42 to
	 * instantly gain a score of 8.
	 */
	public void pause() {
		if (!game.isGameFinished()) {
			boolean end = false;
			System.out.println("Choose an option: 1 CONTINUE | 2 ENDGAME | 3 DEBUG");
			while (!end) {

				switch (keyboard.nextInt()) {
				case 1:
					end = true;
					break;
				case 2:
					game.setGameFinished(true);
					game.setGameWon(true);
					end = true;
					break;
				case 3:
					game.debug();
					System.out.println("DEBUG MODE HAS BEEN TOGGLED");
					end = true;
					break;
				case 42:
					game.setScore(8);
					end = true;
					break;
				default:
					end = true;
					break;
				}
			}
		} else if (game.isGameFinished()) {
			gameEnd();
		}
	}
}
