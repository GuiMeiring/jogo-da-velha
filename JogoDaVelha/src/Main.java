import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	public static Locale locale = new Locale("pt", "BR");

	public static void main(String[] args) {
		
		System.out.println("Seja bem vindo ao JOGO DA VELHA");
		startGame();
       
	}
	
	public static void startGame() {
		int restartGame = 0;
			TicTacToe ticTacToe;
			ticTacToe = new TicTacToe(input());
		do {
			chooseSymbolUser(ticTacToe);
			playGame(ticTacToe);
			System.out.println("\nReiniciar jogo?"
					+"\n1 - Sim"
					+"\n2 - Não");
			restartGame = sc.nextInt();
			
		}while(restartGame == 1);
		closeResources();
	}
	
	public static List<User> input() {
		List<User> users = new ArrayList<>();
		for(int i = 1; i < 3;i++) {
			System.out.printf("\nUsuário %d digite seu apelido: ", i);
			users.add(new User(sc.next()));
		}
		return users;
	}
	
	public static void chooseSymbolUser(TicTacToe ticTacToe) {
		 Random random = new Random();
		 List<User> users = ticTacToe.getUsers();
		 int index = random.nextInt(users.size());
	     
         User userX = users.get(index);
         userX.setSymbol(UserSymbol.X);
         
         User userO = null;
         for(User user : users) {
        	 if (user != userX) {
        		 userO = user;
                 break;
             }
         }
         
         userO.setSymbol(UserSymbol.O);
	}
	
	
	public static boolean gameOver(TicTacToe ticTacToe) {
		if(ticTacToe.checkWinner() == true) {
			System.out.println("\n"+ ticTacToe.toString());
			System.out.printf("\n%s é o VENCEDOR!!!", ticTacToe.getCurrentUser().getNickName());
			return true;
		}
		if (ticTacToe.isBoardFull() == true) {
			System.out.println("\n"+ ticTacToe.toString());
			System.out.println("\nDEU VELHA!!!");
			return true;
		}
		ticTacToe.switchUser();
		return false;
	}
	
	
	public static void playGame(TicTacToe ticTacToe) {
		do {
		    System.out.println("\n"+ ticTacToe.toString());
		    System.out.printf("\n%s informe sua jogada", ticTacToe.getCurrentUser().getNickName());
		    char mark = sc.next().charAt(0);
		    ticTacToe.markMove(mark);
		} while (!gameOver(ticTacToe));

	}
	
	public static void closeResources() {
		sc.close();
	}

}
