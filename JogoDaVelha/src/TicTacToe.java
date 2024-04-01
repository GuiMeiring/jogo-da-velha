import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe {

	private List<User> users = new ArrayList<>();
	private UserSymbol currentUser;

	private char[][] board = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };

	public TicTacToe(List<User> users) {
		super();
		this.users = users;
		this.currentUser = UserSymbol.X;
	}

	public User getCurrentUser() {
		for (User user : users) {
			if (user.getSymbol() == currentUser) {
				return user;
			}
		}
		return null;
	}

	public void markMove(char mark) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == mark) {
					board[i][j] = currentUser.getSymbol();
				}
			}
		}

	}

	public User getUser(UserSymbol symbol) {
		for (User user : users) {
			if (user.getSymbol() == symbol) {
				return user;
			}
		}
		return null;

	}

	public boolean checkWinner() {
		for (int i = 0; i < board.length; i++) {
			// Verifica linha
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
			// Verifica coluna
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}

		}
		// verifica diagonais
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;

		}
		if (board[2][2] == board[1][1] && board[1][1] == board[0][0]) {
			return true;

		}
		return false;

	}

	public boolean isBoardFull() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] != 'X' && board[i][j] != 'O') {
					return false;
				}
			}
		}
		return true;
	}
	
	public void switchUser() {
		currentUser = (currentUser == UserSymbol.X) ? UserSymbol.O : UserSymbol.X;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	@Override
	public String toString() {
	    StringBuilder stringBuilder = new StringBuilder();
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[i].length; j++) {
	            stringBuilder.append(board[i][j]);
	            if (j < board[i].length - 1) {
	                stringBuilder.append(" | ");
	            }
	        }
	        if (i < board.length - 1) {
	            stringBuilder.append("\n----------------\n");
	        }
	    }
	    return stringBuilder.toString();
	}

}
