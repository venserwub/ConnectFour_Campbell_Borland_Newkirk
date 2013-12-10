import java.util.Scanner;


public enum PlayerType {
	USER, RANDOM, SMART;
	
	public PlayerType getPlayerType(){
		boolean goodAnswer = false;
		PlayerType selection = null;
		Scanner input = new Scanner(System.in);
		String response = "";
		
		while(goodAnswer == false){
			response = input.nextLine();
			if(response.equalsIgnoreCase("user") || response.equalsIgnoreCase("u")){
				selection = PlayerType.USER;
				goodAnswer = true;
			}
			else if(response.equalsIgnoreCase("random") || response.equalsIgnoreCase("r")){
				selection = PlayerType.RANDOM;
				goodAnswer = true;
			}
			else if(response.equalsIgnoreCase("smart") || response.equalsIgnoreCase("s")){
				selection = PlayerType.SMART;
				goodAnswer = true;
			}
			else{
				System.out.println("Incorrect input. Please enter user, random, or smart.");
				goodAnswer = false;
			}
		}
		
		return selection;
	}
}
