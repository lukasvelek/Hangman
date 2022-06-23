package cz.lukasvelek.hangman;

import java.util.Scanner;

/**
 * The class Hangman contains all console rendering functions as well as the gameplay order
 * 
 * @author Lukas Velek
 * @version 1.0 (6/23/2022)
 * 
*/
public class Hangman {

	/**
	 * Instance of Scanner class that is used to handle the input from the user
	 */
	private static Scanner sc;
	
	/**
	 * Instance of Game class that is used to play the game
	 */
	private static Game game;
	
	/**
	 * Hangman progress
	 */
	private static int hangmanProgress;
	
	/**
	 * Project main function that creates instances of all necessary classes and also calls functions in gameplay order
	 * 
	 * @param args Does nothing
	 */
	public static void main(String[] args) {
		hangmanProgress = 0;
		
		sc = new Scanner(System.in);
		
		System.out.println("Enter word: ");
		game = new Game(getWord(sc));
		
		playGame(false);
	}
	
	/**
	 * The playgame function that contains order of functions
	 * The main component is the for infinite loop that is being called until the word is guessed
	 * or until the hangman is finished (hanging). First of all the word completion progress is being drawn,
	 * then the user enters the letter and it is checked afterwards. Then the game win/loss is being checked -
	 * if it has been finished or not - and finally the hangman is drawn.
	 * 
	 * Also in the beginning the first if statement contains functions for the user to enter the word that will be guessed.
	 * 
	 * @param newGame If the game that is going to be played is first or not (true if not first; false if first)
	 * @return Returns false no matter what (probably wouldn't even have to be of type boolean)
	 */
	private static boolean playGame(boolean newGame) {
		boolean win = false;
		
		if(newGame) {
			System.out.println("Enter word: ");
			
			game.setWord(getWord(sc));
		}
		
		for(;;) {
			printProgress(game.getWordCompletion());
			
			if(!game.checkLetter(getLetter(sc))) {
				if(hangmanProgress == 3) {
					break;
				} else {
					hangmanProgress++;					
				}
			}
			
			if(game.checkWord()) {
				win = true;
				break;
			}
			
			drawHangman();
			
			System.out.println();
		}
		
		System.out.println();
		
		if(win) {
			System.out.println("Game won!");
		} else {
			System.out.println("Game lost!");
		}
		
		System.out.println("Again? y/n");
		String result = sc.nextLine();
		
		if(result.charAt(0) == 'y') {
			playGame(true);
		} else {
			return false;
		}
		
		return false;
	}
	
	/**
	 * Draws hangman (as of now it is nothing like hangman but it will do)
	 */
	private static void drawHangman() {
		System.out.println();
		
		String hangman = "";
		
		switch(hangmanProgress) {
		case 1:
			hangman = "_____";
			break;
		case 2:
			hangman = "  |\r\n"
					+ "_____";
			break;
		case 3:
			hangman = "  |\r\n"
					+ "  |\r\n"
					+ "_____";
			break;
		default:
			hangman = "";
			break;
		}
	}
	
	/**
	 * Prints progress of guessing the current word
	 * 
	 * @param currentGuessedWord Progress of guessing the current word
	 */
	private static void printProgress(String currentGuessedWord) {
		for(int i = 0; i < currentGuessedWord.length(); i++) {
			System.out.print(currentGuessedWord.charAt(i) + " ");
		}
		
		System.out.println();
	}
	
	/**
	 * Gets the word to be guessed from the user
	 * 
	 * @param sc Instance of Scanner class
	 * @return Word to be guessed
	 */
	private static String getWord(Scanner sc) {
		String word = sc.nextLine();
		
		word.toLowerCase();
		
		return word;
	}
	
	/**
	 * Gets the current letter to be checked if being contained within the word
	 * 
	 * @param sc Instance of Scanner class
	 * @return Letter to be checked
	 */
	private static char getLetter(Scanner sc) {
		String subletter = sc.nextLine();
		
		subletter.toLowerCase();
		
		return subletter.charAt(0);
	}
	
}
