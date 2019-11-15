//
//
//
public class GameBoard {

	// F I E L D S
	public char[][] board;
	public static int[] winConditions = {
			// horizontal
			2 * 3 * 5, 7 * 11 * 13, 17 * 19 * 23,
			// vertical
			2 * 7 * 17, 3 * 11 * 19, 5 * 13 * 23,
			// diagonal
			2 * 11 * 23, 5 * 11 * 17 };

	public int scoreX = 1;
	public int scoreO = 1;
	public boolean restart;
	public int turnsPlayed;

	public int[][] boardPoints = { { 2, 3, 5 }, { 7, 11, 13 }, { 17, 19, 23 } };

	// M E T H O D S
	public GameBoard() {
		board = new char[3][3];
		init();
	}

	public void init() {
		scoreX = 1;
		scoreO = 1;
		turnsPlayed = 0;
		restart = false;
		for (char[] row : board) {
			for (int i = 0; i < row.length; i++) {
				row[i] = '_';
			}
		}
		printBoard();
	}

	public void checkWin() {
		if(turnsPlayed >= 9) {
			catWins();
		}
		for (int i = 0; i < winConditions.length; i++) {
			if (scoreX % winConditions[i] == 0) {
				xWins();
			}
			if (scoreO % winConditions[i] == 0) {
				oWins();
			}
		}
	}
	public void catWins() {
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.println("~   CATS GAME :(  ~");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		restart = true;
	}
	public void xWins() {
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.println("~   X WINS ! ! !  ~");
		System.out.println("~~~~~~~~~~~~~~~~~~~");

		restart = true;
	}

	public void oWins() {
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.println("~   O WINS ! ! !  ~");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		restart = true;
	}

	public boolean scribbleX(int column, int row) {
		// check for index out of bounds
		if (column >= 0 && column <= 2 && row >= 0 && row <= 2) {

			if (board[column][row] == '_') {
				scoreX *= boardPoints[column][row];
				board[column][row] = 'X';
				turnsPlayed++;
				return true;
			} else {
				System.out.println("\nError: Spot taken !\n");
				printBoard();
				return false;
			}
		} else {
			System.out.println("Error: out of bounds");
			return false;
		}
	}

	public boolean scribbleO(int column, int row) {
		// check for out of bounds
		if (column >= 0 && column <= 2 && row >= 0 && row <= 2) {
			if (board[column][row] == '_') {
				scoreO *= boardPoints[column][row];
				board[column][row] = 'O';
				turnsPlayed++;
				return true;
			} else {
				System.out.println("\nError: Spot taken !\n");
				printBoard();
				return false;
			}
		} else {
			System.out.println("Error: out of bounds");
			return false;
		}
	}

	public void printBoard() {
		for (char[] cs : board) {
			for (char c : cs) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}
