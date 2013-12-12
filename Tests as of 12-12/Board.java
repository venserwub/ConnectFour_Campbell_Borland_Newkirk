public class Board {

	private int rowLength, colLength;
	private int chipsToWin = 4;
	private Chips[][] board;

	public Board(int rowLength, int colLength) {
		this.rowLength = rowLength;
		this.colLength = colLength;
		board = new Chips[rowLength][colLength];

		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				board[i][j] = Chips.EMPTY;
			}
		}
	}

	public void printBoard() {
		for (int rows = 0; rows < rowLength; rows++) {
			for (int col = 0; col < colLength; col++) {
				switch (board[rows][col]) {
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

	/*
	 * 
	 */
	public boolean dropChip(int column, Chips color) {
		for (int row = rowLength - 1; row >= 0; row--) {
			if (board[row][column] == Chips.EMPTY) {
				board[row][column] = color;
				return true;
			}
		}
		return false;
	}

	public int getColumnLength() {
		return colLength;
	}

	public int getRowLenth() {
		return rowLength;
	}

	public boolean checkWin() {
		return (checkWinColumn()); //|| checkWinRow());//|| diagonalUp() || diagonalDown() );
	}

	private boolean checkWinRow() {
		Chips previousColor = Chips.EMPTY;
		int consecutiveCount = 1;
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				if (board[i][j] == previousColor
						&& previousColor != Chips.EMPTY) {
					consecutiveCount++;
					if (consecutiveCount >= chipsToWin) {
						return true;
					}
				} else if (board[i][j] == Chips.EMPTY) {
					consecutiveCount = 1;
					previousColor = Chips.EMPTY;
				}
				previousColor = board[i][j];
			}
			previousColor = Chips.EMPTY;
			consecutiveCount = 1;
		}
		return false;
	}

	private boolean checkWinColumn() {
		int rowLength = 5, colLength = 5;
		Chips[][] board = {{Chips.RED, Chips.BLACK, Chips.BLACK, Chips.RED, Chips.RED},
							{Chips.BLACK, Chips.BLACK, Chips.RED, Chips.BLACK, Chips.RED},
							{Chips.BLACK, Chips.RED, Chips.BLACK, Chips.RED, Chips.BLACK},
							{Chips.BLACK, Chips.RED, Chips.RED, Chips.BLACK, Chips.RED},
							{Chips.RED, Chips.RED, Chips.BLACK, Chips.BLACK, Chips.BLACK} };
		
		Chips previousColor = Chips.EMPTY;
		int consecutiveCount = 1;
		for (int i = 0; i < colLength; i++) {
			for (int j = 0; j < rowLength; j++) {
				if (board[j][i] == previousColor
						&& previousColor != Chips.EMPTY) {
					consecutiveCount++;
					if (consecutiveCount >= chipsToWin) {
						return true;
					}
				} else if (board[j][i] == Chips.EMPTY) {
					consecutiveCount = 1;
				}
				previousColor = board[j][i];
			}
			//previousColor = Chips.EMPTY;
			consecutiveCount = 1;
		}
		return false;

	}

	public boolean diagonalDown() {
		boolean win = false;
		int col = 0;
		int chipCount = 1;
		Chips lastColor = null;
		for (int rowStart = 0; rowStart < board.length; rowStart++) {
			for (int row = rowStart; row < board.length; row++) {
				lastColor = board[row][col];
				if (row < board.length - 1 && col < board[row].length - 1) {
					if (board[row + 1][col + 1] == lastColor
							&& (lastColor == Chips.RED || lastColor == Chips.BLACK)) {
						chipCount++;
						if (chipCount >= chipsToWin) {
							win = true;
							break;
						}
					}
				} else {
					chipCount = 1;
				}
				if (col < board[row].length) {
					col++;
				}
			}
			chipCount = 1;
			col = 0;
		}
		if (win == false) {
			int row = 0;
			for (int colStart = 0; colStart < board[row].length; colStart++) {
				for (int column = colStart; column < board[row].length; column++) {

					lastColor = board[row][column];
					if (row < board.length - 1
							&& column < board[row].length - 1) {
						if (board[row + 1][column + 1] == lastColor && (lastColor == Chips.RED || lastColor == Chips.BLACK)) {
							chipCount++;
							if (chipCount >= chipsToWin) {
								win = true;
								break;
							}
						} else {
							chipCount = 1;
						}
						if (row < board.length) {
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

	private boolean diagonalUp() {

		int col = 0;
		int chipCount = 1;
		Chips lastColor = null;
		for (int rowStart = board.length - 1; rowStart >= 0; rowStart--) {
			for (int row = rowStart; row >= 0; row--) {
				lastColor = board[row][col];
				if (row > 0 && col < board[row].length - 1) {
					if (board[row - 1][col + 1] == lastColor
							&& (lastColor == Chips.RED || lastColor == Chips.BLACK)) {
						chipCount++;
						if (chipCount >= chipsToWin) {
							return true;
						}
					}
				} else {
					chipCount = 1;
				}
				if (col < board[row].length) {
					col++;
				}
			}
			chipCount = 1;
			col = 0;
		}
		int row = board.length - 1;
		for (int colStart = 0; colStart < board[row].length; colStart++) {
			for (int column = colStart; column < board[row].length; column++) {

				lastColor = board[row][column];
				if (row > 0 && column < board[row].length - 1) {
					if (board[row - 1][column + 1] == lastColor && (lastColor == Chips.RED || lastColor == Chips.BLACK)) {
						chipCount++;
						if (chipCount >= chipsToWin) {
							return true;
						}
					} else {
						chipCount = 1;
					}
					if (row > 0) {
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
