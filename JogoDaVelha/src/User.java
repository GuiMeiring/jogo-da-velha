
public class User {
	
	private String nickName;
	private UserSymbol symbol;
	
	public User(String nickName) {
		super();
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public UserSymbol getSymbol() {
		return symbol;
	}

	public void setSymbol(UserSymbol symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "User [nickName=" + nickName + ", symbol=" + symbol + "]";
	}

}
