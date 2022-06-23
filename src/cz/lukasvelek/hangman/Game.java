package cz.lukasvelek.hangman;

/**
 * The class Game contains the word that is being guessed and all necessary stuff that is needed to be able to finish the game
 * 
 * @author Lukas Velek
 * @version 1.1 (6/23/2022)
 *
 */
public class Game {
	/**
	 * The word that is being guessed
	 */
	private static String word;
	
	/**
	 * The progress of guessing the current word
	 * Will contain letters that have been guessed and an underscore where they have not
	 */
	private static char[] wordCompletion;
	
	/**
	 * Used letters
	 */
	private static String lettersUsed;

	/**
	 * Contains all letters that can be used in the game
	 */
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * The constructor that sets the first word of the game
	 * 
	 * @param newWord First word of the game
	 */
	public Game(String newWord) {
		setWord(newWord);
	}
	
	/**
	 * Sets the word of the game
	 * 
	 * @param newWord New word of the game
	 */
	public void setWord(String newWord) {
		word = newWord;
		wordCompletion = new char[word.length()];
		lettersUsed = "";
		
		for(int i = 0; i < wordCompletion.length; i++) {
			wordCompletion[i] = '_';
		}
	}
	
	/**
	 * Gets the current word of the game
	 * 
	 * @return Current word of the game
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Checks if letter is contained within the word and the alphabet and if has not been used already
	 * 
	 * @param letter User-entered letter to be checked
	 * @return True if letter is contained; false if not
	 */
	public boolean checkLetter(char letter) {
		boolean success = false;
		
		for(int i = 0; i < ALPHABET.length(); i++) {
			if(letter == ALPHABET.charAt(i)) {
				for(int j = 0; j < word.length(); j++) {
					if(word.charAt(j) == letter) {
						wordCompletion[j] = letter;
						success = true;
					}
				}

				lettersUsed += letter;
			}
		}
		
		return success;
	}

	
	/**
	 * Checks whether the user has completed the word
	 * 
	 * @return True if the game is finished; false if not
	 */
	public boolean checkWord() {
		int g = 0;
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == wordCompletion[i]) {
				g++;
			}
		}
		
		if(g == word.length()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the yet guessed letters in the word (word completion)
	 * 
	 * @return Word completion
	 */
	public String getWordCompletion() {
		String wordReturn = "";
		
		for(int i = 0; i < wordCompletion.length; i++) {
			wordReturn += wordCompletion[i];
		}
		
		return wordReturn;
	}
	
	/**
	 * Checks if letter has been used already or not
	 * 
	 * @param letter Letter to be checked
	 * @return True if letter has been used; false if not
	 */
	public boolean checkLetterUsedAgain(char letter) {
		boolean used = false;
		
		for(int i = 0; i < lettersUsed.length(); i++) {
			if(lettersUsed.charAt(i) == letter) {
				used = true;
			}
		}
		
		return used;
	}
}
