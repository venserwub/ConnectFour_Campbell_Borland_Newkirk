import java.util.Scanner;


public class Player {

	private PlayerType type = PlayerType.USER;
	

	public int getColumn(){
		int colNumber = 0;
		
		switch(type){
		case RANDOM:
			break;
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

	public int getInt(){
		int number = 0;
		boolean goodResponse = false;

		
		do{
			Scanner input = new Scanner(System.in);

			if(input.hasNextInt()){
				number = input.nextInt();
				if(number >= 1 && number <= 6){
					goodResponse = true;
				}
				else{
					System.out.println("Please enter a number between 1 and 6");
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
