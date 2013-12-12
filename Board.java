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
	
	public boolean checkWin() {
		//Fix this to detect row, vertical and diagonal wins.
		return false;
	}
//	
//	private Chips checkWinRow() {
//		Chips previousColor = Chips.EMPTY;
//		int consecutiveCount = 0;
//		for(int i = 0; i < rowLength; i++) {
//			for(int j = 0; j < colLength; j++) {
//				if(board[i][j] == previousColor && previousColor != Chips.EMPTY) {
//					consecutiveCount++;
//					if(consecutiveCount >= chipsToWin) {
//						return previousColor;
//					}
//				}
//				previousColor = board[i][j];
//			}
//		}
//		return Chips.EMPTY;
//	}
//	
//	private boolean winCheckForColumn() {
//		int inARow;
//		boolean isWin = false;
//		for (int i = 0; i < colLength; i++) {
//			inARow = 0;
//			for (int j = rowLength; i >= 0; i--) {
//				if (board[j][i] != board[j - 1][i - 1]) {
//					inARow++;
//				} 
//			}
//			isWin = (inARow == ((colLength / 2) + 1)) ? true : false;
//		}
//		return isWin;
//	}
}
