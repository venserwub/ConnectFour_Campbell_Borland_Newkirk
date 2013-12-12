import java.util.Scanner;

public class Game {

	private Player playerOne, playerTwo;
	private Board board;
	
	public Game(Player p1, Player p2, int rowLength, int columnLength){
		this.playerOne = p1;
		this.playerTwo = p2;
		this.board = new Board(rowLength, columnLength);
		
	}
	
	public winStatus whoWin(){
		winStatus winner = null;
		return winner;
	}
	
	public Player play(){
		boolean go = true;
		boolean legalMove;
		board.printBoard();
		System.out.println();
		
		while(go){
			do {
				legalMove = board.dropChip(playerOne.getColumn() - 1, playerOne.getColor());
			} while (!legalMove);
			
			board.printBoard();
			System.out.println();
			if(board.checkWin() != false) {
				return playerOne;
			}
			
			
			do {
				legalMove = board.dropChip(playerTwo.getColumn() -1, playerTwo.getColor());
			} while (!legalMove);
			
			board.printBoard();
			System.out.println();
			if(board.checkWin() != false) {
				return playerTwo;
			}
			/*
			Scanner input = new Scanner(System.in);
			String response = input.nextLine();
			if(response.equalsIgnoreCase("stop")){
				go = false;
			}
			*/
		}
		System.out.println("Good day.");
		return null;
	}
	
	public static void main(String args[]){

	}
}
