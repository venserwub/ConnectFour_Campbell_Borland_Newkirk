import java.util.Scanner;
import java.util.Random;

public class Player {

	private PlayerType type = PlayerType.USER;
	private Chips playerColor = Chips.EMPTY;
	private int rowLength, columnLength;
	static Random gen = new Random();
	
	public Player(PlayerType playerType, Chips playerColor, int rowLength, int columnLength) {
		this.type = playerType;
		this.playerColor = playerColor;
		this.rowLength = rowLength;
		this.columnLength = columnLength;
	}
	
	public Chips getColor() {
		return this.playerColor;
	}

	public int getColumn(){
		int colNumber = 0;
		
		switch(type){
		case RANDOM: {
			colNumber = gen.nextInt(columnLength) + 1;
			break;
		}
		case SMART:
			break;
		case USER:
			System.out.println("Which column do you want to drop your chip?");
			colNumber = getInt();
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
				if(number >= 1 && number <= columnLength){
					goodResponse = true;
				}
				else{
					System.out.println("Please enter a number between 1 and " + columnLength);
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
