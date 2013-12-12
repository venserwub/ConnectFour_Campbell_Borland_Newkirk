import java.util.Scanner;

import javax.swing.JOptionPane;

public class SwingGUI {

	String title = "Connect Four";
	
	private int consoleOrSwing = 0;
	
	public SwingGUI (int consoleOrSwing) {
		this.consoleOrSwing = consoleOrSwing;
		
	}
	
	public void welcomeMessage() {

		//Welcomes the player to the game.
		switch (consoleOrSwing) {
		case 0:
			System.out.println("Welcome to Connect Four. \nMade by David Borland and Joshua Campbell and Alex Newkirk.");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Welcome to Connect Four. \nMade by David Borland and Joshua Campbell and Alex Newkirk.", 
					title, JOptionPane.PLAIN_MESSAGE);
			break;
		}
	}
	
	public PlayerType askForPlayer(String question) {
		switch (consoleOrSwing) {
		case 0:
			Scanner input = new Scanner(System.in);
			System.out.println(question + " (1.User 2.Random 3.Smart");
			return PlayerType.intToPlayerType(input.nextInt() - 1);
		case 1:
			String[] playerOptions;
			playerOptions = new String[3];
			playerOptions[0] = "User";
			playerOptions[1] = "Random";
			playerOptions[2] = "Smart";
		
			int userInputPlayerTypeInt = JOptionPane.showOptionDialog(null, question, title, 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, playerOptions, null);
		
			return PlayerType.intToPlayerType(userInputPlayerTypeInt);
		}
		return null;
	}
	
	public CVCDisplayType askForCVCDisplayType () {
		
		switch (consoleOrSwing) {
		case 0:
			Scanner input = new Scanner(System.in);
			System.out.println("How do you want your computers to fight? (1.Turn by Turn 2.Winner by Winner 3.Just the End Results)");
			return CVCDisplayType.intToCVCDisplayType(input.nextInt() - 1);
		case 1:
			String[] computerVersusOptions;
			computerVersusOptions = new String[3];
			computerVersusOptions[0] = "Turn by Turn";
			computerVersusOptions[1] = "Winner by Winner";
			computerVersusOptions[2] = "Just the end results.";

			int userInputCVCOutputType = JOptionPane.showOptionDialog(null, "How do you want your computers to fight?", 
					title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, computerVersusOptions, null);
		
			return CVCDisplayType.intToCVCDisplayType(userInputCVCOutputType);
		}
		return null;
	}
	
	public int askForInt (String question, int defaultOption) {
		switch (consoleOrSwing) {
		case 0:
			Scanner input = new Scanner(System.in);
			System.out.println(question);
			return input.nextInt();
		case 1:
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
		return 0;
	}
	
	public void printWinner(String winner) {
		switch (consoleOrSwing) {
		case 0:
			System.out.println(winner + " won!");
			break;
		case 1:		
			JOptionPane.showMessageDialog(null, title, winner + " won!", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}
	public boolean playAgain() {
		switch (consoleOrSwing) {
		case 0:
			Scanner input = new Scanner(System.in);
			System.out.println("Would you like to play again? (True/ False)");
			return input.nextBoolean();
		case 1:
			int yesNo = JOptionPane.showConfirmDialog(null, "Would you like to play again?", title,
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			return (yesNo == 0) ? true : false;
		}
		return false;
	}
}
