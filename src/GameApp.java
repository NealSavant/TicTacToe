//
//
//
//


import java.util.Scanner;

public class GameApp {
	public static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameBoard ticTacToe = new GameBoard();
		boolean playerXTurn = true; // player X goes first
		boolean playingGame = true;

		
		while (playingGame) {

			if (playerXTurn) {
				System.out.println("X enter your move (column space row)");
				System.out.println("Enter 9 9 to leave game");
				int column = kb.nextInt();
				int row = kb.nextInt();

				if (column == 9)
					break;

				playerXTurn = !ticTacToe.scribbleX(column, row);

				if (!playerXTurn) {
					ticTacToe.printBoard();
				}
			} else {
				System.out.println("O enter your move (column space row)");
				System.out.println("Enter 9 9 to leave game");
				int column = kb.nextInt();
				int row = kb.nextInt();

				if (column == 9)
					break;
				playerXTurn = ticTacToe.scribbleO(column, row);

				if (playerXTurn) {
					ticTacToe.printBoard();
				}
			}

			ticTacToe.checkWin();
			if (ticTacToe.restart) {
				System.out.println("Would you like to play again?");
				if(kb.next().equalsIgnoreCase("no")){
					System.exit(0);
				}
				ticTacToe.init();
				playerXTurn = true;
			}
		}
		kb.close();
	}

}
