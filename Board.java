
public class Board {

	private final int ROW = 7, COL = 6;
	
	private Chips[][] board = new Chips[ROW][COL];
	
	public Board(){
		for(int i = 0; i < ROW; i++){
			for(int j = 0; j < COL; j++){
				board[i][j] = Chips.EMPTY;
			}
		}
	}
	
	public void printBoard(){
		for(int rows = 0; rows < ROW; rows++){
			for(int col = 0; col < COL; col++){
				switch(board[rows][col]){
				case EMPTY:
					System.out.print("O");
					break;
				case RED:
					System.out.print("R");
					break;
				case BLACK:
					System.out.print("B");
					break;
				default:
					System.out.print("Error");
					break;
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public void dropChip(int column){
		for(int row = ROW - 1; row >= 0 ; row--){
			if(board[row][column] == Chips.EMPTY){
				board[row][column] = Chips.RED;
				break;
			}
		}
	}
	
}
