import javax.swing.JOptionPane;

public class Arena {
	
	public void run () {
		String title = "Connect Four";
		
		String[] playerOptions;
		playerOptions = new String[3];
		playerOptions[0] = "User";
		playerOptions[1] = "Random";
		playerOptions[2] = "Smart";
		
		//Welcomes the player to the game.
		JOptionPane.showMessageDialog(null, "Welcome to Connect Four. \nMade by David Borland and Joshua Campbell.", title,
			JOptionPane.PLAIN_MESSAGE);
			
		do {
			//asks player for their input using a showOptionDialog
			int userInputPlayer1 = JOptionPane.showOptionDialog(null, "What kind of player should player one be?", title, 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, playerOptions, null);
			int userInputPlayer2 = JOptionPane.showOptionDialog(null, "What kind of player should player two be?", title, 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, playerOptions, null);
		
			boolean isUserPresent = false;
			int userInputComputerVersusComputerOutputType;
			String[] computerVersusOptions;
			computerVersusOptions = new String[3];
			computerVersusOptions[0] = "Turn by Turn";
			computerVersusOptions[1] = "Winner by Winner";
			computerVersusOptions[2] = "Just the end results.";
			int userInputComputerAmountOfGames = 1;
			String stringUserInputComputerAmountOfGames;
			
			PlayerType player1 = PlayerType.intToPlayerType(userInputPlayer1);
			PlayerType player2 = PlayerType.intToPlayerType(userInputPlayer2);
			
			if (player1 == PlayerType.USER || player2 == PlayerType.USER) {
				isUserPresent = true;
			} else {
				userInputComputerVersusComputerOutputType = JOptionPane.showOptionDialog(null, "How do you want your computers to fight?", 
					title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, computerVersusOptions, null);
			
			//Input and validation for userInputComputerAmountOfGames
				boolean isNumber = true;
				do {
					stringUserInputComputerAmountOfGames = (String) JOptionPane.showInputDialog(null,
							"How many games should the computers play?", title, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					
					isNumber = true;
					if (!stringUserInputComputerAmountOfGames.isEmpty()) {
						for (int i = 0; i < stringUserInputComputerAmountOfGames.length(); i++) {
							if (!Character.isDigit(stringUserInputComputerAmountOfGames.charAt(i))) {
								isNumber = false;
							}
						}
					}
				}while (!isNumber);
				userInputComputerAmountOfGames = Integer.parseInt(stringUserInputComputerAmountOfGames);
			}
			
			//TODO Figure out if we use constructor or parameters for Game class.
			//TODO Make correct code for constructors or parameters for Game class.
			for (int i = 0; i < userInputComputerAmountOfGames; i++) {
				Game play = new Game();
				
			}
			
			
		} while (JOptionPane.showConfirmDialog(null, "Would you like to play again?", title, JOptionPane.YES_NO_OPTION) == 0);
		
	}
	
	public static void main(String[] args) {
		Arena run = new Arena();
		run.run();
	}
}
