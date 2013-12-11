
public enum CVCDisplayType {
	TURNBYTURN, WINNERBYWINNER, ENDRESULTSONLY;
	
	public static CVCDisplayType intToCVCDisplayType (int input) {
		switch (input) {
		
		case 0:
			return TURNBYTURN;
		case 1:
			return WINNERBYWINNER;
		case 2: 
			return ENDRESULTSONLY;
		default:
			return null;
		}
	}
}
