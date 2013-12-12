
public enum PlayerType {
	USER, RANDOM, SMART;
	
	public static PlayerType intToPlayerType (int input) {
		switch (input) {
		
		case 0:
			return USER;
		case 1:
			return RANDOM;
		case 2:
			return SMART;
		}
		return null;
	}
}
