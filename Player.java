import java.util.Scanner;

public class Player {

	private PlayerType type = PlayerType.USER;
	private Chips playerColor = Chips.EMPTY;
	
	public Player(PlayerType playerType, Chips playerColor, int rowLength, int columnLength) {
		this.type = playerType;
		this.playerColor = playerColor;
	}
	
	public Chips getColor() {
		return this.playerColor;
	}

	public int getColumn(){
		int colNumber = 0;
		SwingGUI gui = new SwingGUI(1);
		
		switch(type){
		case RANDOM:
			break;
		case SMART:
			break;
		case USER:
			colNumber = gui.askForInt("Which Column do you want to drop your chip in?", 1);
			break;
		default:
			break;
		
		}
		
		return colNumber;
	}
	
	public String toString() {
		return(String.valueOf(playerColor));
	}

	public int getInt(){
		int number = 0;
		boolean goodResponse = false;

		
		do{
			Scanner input = new Scanner(System.in);

			if(input.hasNextInt()){
				number = input.nextInt();
				if(number >= 1 && number <= 7){
					goodResponse = true;
				}
				else{
					System.out.println("Please enter a number between 1 and 7");
					goodResponse = false;
				}
			}
			else{
				System.out.println("Incorrect input. Please enter an integer value.");
				goodResponse = false;
			}
		} while (goodResponse == false);
		
		return number;
	}
}
