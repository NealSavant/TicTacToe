//AUTHOR: Neal Savant
//DATE: November 14, 2019


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
				System.out.print("X Player\n\tRow:");
				int row = kb.nextInt();
				System.out.print("\tColumn:");
				int column = kb.nextInt();
				System.out.println();
				playerXTurn = !ticTacToe.scribbleX(row, column);

				if (!playerXTurn) {
					ticTacToe.printBoard();
				}
			} else {
				System.out.print("O Player\n\tRow: ");
				int row = kb.nextInt();
				System.out.print("\tColumn: ");
				int column = kb.nextInt();
				System.out.println();
				playerXTurn = ticTacToe.scribbleO(row, column);

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
