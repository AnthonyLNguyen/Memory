package edu.cpp.cs.cs141.prog_assgmnt_2;

/*
 * 
 * 
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #N
 *
 * A memory game with grid of size 4 by 4.
 *
 * NAME: Anthony Nguyen
 *
 * 
 * 
 * 
 * Main class for memory. Instantiates UI
 * and engine and starts the game.
 * @author Anthony
 * 
 */
public class Main {

	public static void main(String[] args) {
		UserInterface userInterface = new UserInterface(new GameEngine());
		userInterface.startGame();
	}

}
