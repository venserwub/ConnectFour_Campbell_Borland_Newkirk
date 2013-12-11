import java.util.Scanner;

import javax.swing.JOptionPane;

public class SwingGUI {

	String title = "Connect Four";
	
	public void welcomeMessage() {

		//Welcomes the player to the game.
		JOptionPane.showMessageDialog(null, "Welcome to Connect Four. \nMade by David Borland and Joshua Campbell and Alex Newkirk.", title,
			JOptionPane.PLAIN_MESSAGE);
	}
	public PlayerType askForPlayer(String question) {

		String[] playerOptions;
		playerOptions = new String[3];
		playerOptions[0] = "User";
		playerOptions[1] = "Random";
		playerOptions[2] = "Smart";
		
		int userInputPlayerTypeInt = JOptionPane.showOptionDialog(null, question, title, 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, playerOptions, null);
		
		return PlayerType.intToPlayerType(userInputPlayerTypeInt);
	}
	
	public CVCDisplayType askForCVCDisplayType () {

		String[] computerVersusOptions;
		computerVersusOptions = new String[3];
		computerVersusOptions[0] = "Turn by Turn";
		computerVersusOptions[1] = "Winner by Winner";
		computerVersusOptions[2] = "Just the end results.";

		int userInputCVCOutputType = JOptionPane.showOptionDialog(null, "How do you want your computers to fight?", 
			title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, computerVersusOptions, null);
		
		return CVCDisplayType.intToCVCDisplayType(userInputCVCOutputType);
	}
	
	public int askForInt (String question, int defaultOption) {

		//Input and validation for userInputComputerAmountOfGames
		boolean isNumber = true;
		String stringUserInputComputerAmountOfGames;
		do {
			 stringUserInputComputerAmountOfGames = (String) JOptionPane.showInputDialog(null,
					question, title, JOptionPane.INFORMATION_MESSAGE, null, null, defaultOption);

			Scanner validate = new Scanner(stringUserInputComputerAmountOfGames);
			isNumber = (validate.hasNextInt()) ? true : false;
			
		}while (!isNumber);
		return Integer.parseInt(stringUserInputComputerAmountOfGames);
	}
	
	public boolean playAgain() {
		int yesNo = JOptionPane.showConfirmDialog(null, "Would you like to play again?", title,
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		return (yesNo == 0) ? true : false;
	}
}
