public class Arena {
	int gameCount = 0;
	int player1WinCount = 0;
	int player2WinCount = 0;
	
	public void run () {
		SwingGUI gui = new SwingGUI(0);
		
		//Welcomes the player to the game.
		gui.welcomeMessage();
			
		do {
			//asks player for their input using a showOptionDialog
			PlayerType player1 = gui.askForPlayer("What kind of player should player one be?");
			PlayerType player2 = gui.askForPlayer("What kind of player should player two be?");
			
			//check for userPresent
			boolean isUserPresent = false;
			CVCDisplayType displayType;
			int amountOfGames;
			if (player1 == PlayerType.USER || player2 == PlayerType.USER) {
				isUserPresent = true;
				
			} else {
				displayType = gui.askForCVCDisplayType();
				amountOfGames = gui.askForInt("How many games do you want the computers to run?", 1);
			}
			
			int userInputBoardSizeRows = gui.askForInt("How many rows should the board have?", 6);
			int userInputBoardSizeColumns = gui.askForInt("How many columns should the board have?", 7);
			
			Player playerOne = new Player(PlayerType.USER, Chips.RED, userInputBoardSizeRows, userInputBoardSizeColumns);
			Player playerTwo = new Player(PlayerType.USER, Chips.BLACK, userInputBoardSizeRows, userInputBoardSizeColumns);
			Game play = new Game(playerOne, playerTwo, userInputBoardSizeRows, userInputBoardSizeColumns);
			String winner = String.valueOf(play.play());
			
			gui.printWinner(winner);
			
		} while (gui.playAgain());
		
	}
	
	public static void main(String[] args) {
		Arena run = new Arena();
		run.run();
	}
}
