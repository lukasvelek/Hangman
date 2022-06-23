package cz.lukasvelek.hangman;

/**
 * Class HangmanDrawing contains stages of hangman drawings
 * 
 * @author Lukas Velek
 * @version 1.1 (6/23/2022)
 *
 */
public class HangmanDrawing {

	/**
	 * Useless constructor
	 */
	public HangmanDrawing() {}
	
	/* 
	 *  012345
	 *   ----- 0
	 *   |   | 1
	 *   O   | 2
	 *  /|\  | 3
	 *   |   | 4
	 *  / \  | 5
	 *  ------ 6
	 */
	
	/**
	 * First stage of the hangman
	 * @return First stage of the hangman
	 */
	public String[] firstStage() {
		String[] hangman = new String[7];
		
		hangman[0] = "";
		hangman[1] = "";
		hangman[2] = "";
		hangman[3] = "";
		hangman[4] = "";
		hangman[5] = "";
		hangman[6] = "------";
		
		return hangman;
	}
	
	/**
	 * Second stage of the hangman
	 * @return Second stage of the hangman
	 */
	public String[] secondStage() {
		String[] hangman = new String[7];
		
		hangman[0] = "";
		hangman[1] = "     |";
		hangman[2] = "     |";
		hangman[3] = "     |";
		hangman[4] = "     |";
		hangman[5] = "     |";
		hangman[6] = "------";
		
		return hangman;
	}
	
	/**
	 * Third stage of the hangman
	 * @return Third stage of the hangman
	 */
	public String[] thirdStage() {
		String[] hangman = new String[7];
		
		hangman[0] = "";
		hangman[1] = "     |";
		hangman[2] = " O   |";
		hangman[3] = "/|\\ |";
		hangman[4] = " |   |";
		hangman[5] = "/ \\ |";
		hangman[6] = "------";
		
		return hangman;
	}
	
	/**
	 * Fourth stage of the hangman
	 * @return Fourth stage of the hangman
	 */
	public String[] fourthStage() {
		String[] hangman = new String[7];
		
		hangman[0] = "------";
		hangman[1] = " |   |";
		hangman[2] = " O   |";
		hangman[3] = "/|\\  |";
		hangman[4] = " |   |";
		hangman[5] = "/ \\  |";
		hangman[6] = "------";
		
		return hangman;
	}
	
}
