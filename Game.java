import java.util.Scanner;

public class Game {

	private Player playerOne = new Player();
	private Board board = new Board();
	
	public Game(){

	}
	
	public winStatus whoWin(){
		winStatus winner = null;
		
		
		
		return winner;
	}
	
	public void play(){
		boolean go = true;
		
		while(go){
			board.printBoard();
			board.dropChip(playerOne.getColumn() - 1);
			
			/*
			Scanner input = new Scanner(System.in);
			String response = input.nextLine();
			if(response.equalsIgnoreCase("stop")){
				go = false;
			}
			*/
		}
		System.out.println("Good day.");
	}
	
	public static void main(String args[]){
		Game game = new Game();
		game.play();
	}
}
