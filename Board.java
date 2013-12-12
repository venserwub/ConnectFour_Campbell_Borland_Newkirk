
public class Board {

	private int rowLength, colLength;
	private int chipsToWin = 4;
	private Chips[][] board;
		
	public Board(int rowLength, int colLength) {
		this.rowLength = rowLength;
		this.colLength = colLength;
		board = new Chips[rowLength][colLength];
		
		for(int i = 0; i < rowLength; i++){
			for(int j = 0; j < colLength; j++){
				board[i][j] = Chips.EMPTY;
			}
		}
	}
	
	public void printBoard(){
		for(int rows = 0; rows < rowLength; rows++){
			for(int col = 0; col < colLength; col++){
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
	
	public void dropChip(int column, Chips color){
		for(int row = rowLength - 1; row >= 0 ; row--){
			if(board[row][column] == Chips.EMPTY){
				board[row][column] = color;
				break;
			}
		}
	}
	
	public int getColumnLength(){
		return colLength;
	}
	
	public int getRowLenth() {
		return rowLength;
	}
	
	public Chips checkWin() {
		//Fix this to detect row, vertical and diagonal wins.
		return Chips.EMPTY;
	}
	
	private Chips checkWinRow() {
		Chips previousColor = Chips.EMPTY;
		int consecutiveCount = 0;
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < colLength; j++) {
				if(board[i][j] == previousColor && previousColor != Chips.EMPTY) {
					consecutiveCount++;
					if(consecutiveCount >= chipsToWin) {
						return previousColor;
					}
				}
				previousColor = board[i][j];
			}
		}
		return Chips.EMPTY;
	}
	
	public boolean diagonalDown(){
		int [] [] board = { {1, 1, 1, 1, 2, 1, 2},
							{2, 2, 2, 1, 1, 2, 1},
							{1, 2, 1, 2, 2, 2, 1},
							{1, 1, 1, 1, 1, 1, 1},
							{2, 2, 2, 2, 2, 2, 2} };
		boolean win = false;
		int col = 0;
		int chipCount = 1;
		int lastColor = 0;
		for(int rowStart = 0; rowStart < board.length; rowStart++){
			for(int row = rowStart; row < board.length; row++){
				lastColor = board[row][col];
				if (row < board.length - 1 && col < board[row].length -1){
					if(board[row + 1][col + 1] == lastColor){
						chipCount++;
						if(chipCount >= chipsToWin){
							win = true;
							break;
						}
					}
				}
				else{
					chipCount = 1;
				}
				if(col < board[row].length){
					col++;
				}		
			}
			chipCount = 1;
			col = 0;
		}
		if(win == false){
			int row = 0;
			for(int colStart = 0; colStart < board[row].length; colStart++){
				for(int column = colStart; column < board[row].length; column++){
					
					lastColor = board[row][column];
					if (row < board.length - 1 && column < board[row].length - 1){
						int c = board[row + 1][column + 1];
						if(board[row + 1][column + 1] == lastColor){
							chipCount++;
							if(chipCount >= chipsToWin){
								win = true;
								break;
							}
						}
						else{
							chipCount = 1;
						}
						if(row < board.length){
							row++;
						}
					}
				}
				chipCount = 1;
				row = 0;

			}
		}
		return win;
	}
	
	public boolean diagonalUp(){
		int [] [] board = { {1, 1, 1, 2, 2, 1, 2},
							{2, 2, 2, 1, 1, 2, 2},
							{1, 2, 1, 2, 2, 2, 1},
							{1, 1, 1, 1, 2, 1, 1},
							{2, 2, 2, 2, 2, 2, 2} };
		int col = 0;
		int chipCount = 1;
		int lastColor = 0;
		for(int rowStart = board.length - 1; rowStart >= 0; rowStart--){
			for(int row = rowStart; row >= 0; row--){
				lastColor = board[row][col];
				if (row > 0 && col < board[row].length -1){
					if(board[row - 1][col + 1] == lastColor){
						chipCount++;
						if(chipCount >= chipsToWin){
							return true;
						}
					}
				}
				else{
					chipCount = 1;
				}
				if(col < board[row].length){
					col++;
				}		
			}
			chipCount = 1;
			col = 0;
		}
			int row = board.length - 1;
			for(int colStart = 0; colStart < board[row].length; colStart++){
				for(int column = colStart; column < board[row].length; column++){
					
					lastColor = board[row][column];
					if (row > 0 && column < board[row].length - 1){
						int c = board[row - 1][column + 1];
						if(board[row - 1][column + 1] == lastColor){
							chipCount++;
							if(chipCount >= chipsToWin){
								return true;
							}
						}
						else{
							chipCount = 1;
						}
						if(row > 0){
							row--;
						}
					}
				}
				chipCount = 1;
				row = board.length - 1;

			}
		
		return false;
	}
	
}
