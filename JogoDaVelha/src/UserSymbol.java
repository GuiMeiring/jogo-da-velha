
public enum UserSymbol {
	X('X'),
	O('O');
	
	private char symbol;

	private UserSymbol(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

}
