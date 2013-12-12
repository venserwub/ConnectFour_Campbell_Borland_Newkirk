public class Arena2 {
	
	public static void main(String[] args) {
		int rows = 6, columns = 7;
		
		Player playerOne = new Player(PlayerType.USER, Chips.RED, rows, columns);
		Player playerTwo = new Player(PlayerType.USER, Chips.BLACK, rows, columns);
		Game test = new Game(playerOne, playerTwo, rows, columns);
		String winner = String.valueOf(test.play());
		System.out.println(winner);
	}
}