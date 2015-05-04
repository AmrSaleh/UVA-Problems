import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ChessboardInFEN10284 {
	static int[][] board = new int[8][8];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String line;
		int slotsTojump;
		int x = 0;
		int y = 0;
		boolean black = true;
		String[] rows = new String[8];

		int emptyNotAttacked = 0;

		while (sc.hasNext()) {
			line = sc.nextLine();

			// Arrays.fill(board, 0);
			for (int[] row : board)
				Arrays.fill(row, 0);

			rows = line.split("/");
			x = 0;
			y = 0;
			for (int i = 0; i < rows.length; i++) {
				y = 0;
				for (int j = 0; j < rows[i].length(); j++) {
					try {
						slotsTojump = Integer.parseInt(rows[i].charAt(j) + "");
						y = y + slotsTojump - 1;
					} catch (Exception e) {
						board[x][y] = 1;
					}

					y++;
				}
				x++;
			}
			
			x = 0;
			y = 0;
			for (int i = 0; i < rows.length; i++) {
				y = 0;
				for (int j = 0; j < rows[i].length(); j++) {
					black = true;
					if (rows[i].charAt(j) == 'P') {
						// rows[i].replaceFirst("P", "p");
						black = false;
					}

					if (rows[i].charAt(j) == 'p' || rows[i].charAt(j) == 'P') {
						fillPawnAttack(x, y, black);
					} else if (rows[i].charAt(j) == 'r' || rows[i].charAt(j) == 'R') {
						fillRookAttack(x, y);
					} else if (rows[i].charAt(j) == 'n' || rows[i].charAt(j) == 'N') {
						fillNightAttack(x, y);
					} else if (rows[i].charAt(j) == 'b' || rows[i].charAt(j) == 'B') {
						fillBishopAttack(x, y);
					} else if (rows[i].charAt(j) == 'q' || rows[i].charAt(j) == 'Q') {
						fillQueenAttack(x, y);
					} else if (rows[i].charAt(j) == 'k' || rows[i].charAt(j) == 'K') {
						fillKingAttack(x, y);
					} else {
						slotsTojump = Integer.parseInt(rows[i].charAt(j) + "");
						y = y + slotsTojump - 1;
					}
					y++;
				}
				x++;
			}

			emptyNotAttacked = 0;
			for (int i = 0; i < rows.length; i++) {
				for (int j = 0; j < rows.length; j++) {
					if (board[i][j] == 0) {
						emptyNotAttacked++;
					}
				}
			}

			System.out.println(emptyNotAttacked);
//			System.out.println(printboard());

		}
		sc.close();
	}

	private static boolean fillSlot(int i, int j) {
		try {
			if (board[i][j] == 1) {
				return false;
			}
			board[i][j] = 2;
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	private static void fillKingAttack(int x, int y) {
//		board[x][y] = 1;
		fillSlot(x - 1, y - 1);
		fillSlot(x, y - 1);
		fillSlot(x + 1, y - 1);
		fillSlot(x - 1, y);
		fillSlot(x + 1, y);
		fillSlot(x - 1, y + 1);
		fillSlot(x, y + 1);
		fillSlot(x + 1, y + 1);
	}

	private static void fillQueenAttack(int x, int y) {
//		board[x][y] = 1;
		fillRookAttack(x, y);
		fillBishopAttack(x, y);
	}

	private static void fillBishopAttack(int x, int y) {
//		board[x][y] = 1;
		int i = x + 1;
		int j = y + 1;
		while (fillSlot(i, j)) {
			i++;
			j++;
		}
		i = x + 1;
		j = y - 1;
		while (fillSlot(i, j)) {
			i++;
			j--;
		}
		i = x - 1;
		j = y - 1;
		while (fillSlot(i, j)) {
			i--;
			j--;
		}
		i = x - 1;
		j = y + 1;
		while (fillSlot(i, j)) {
			i--;
			j++;
		}
	}

	private static void fillNightAttack(int x, int y) {
//		board[x][y] = 1;
		fillSlot(x - 1, y - 2);
		fillSlot(x + 1, y - 2);
		fillSlot(x - 2, y - 1);
		fillSlot(x + 2, y - 1);
		fillSlot(x - 2, y + 1);
		fillSlot(x + 2, y + 1);
		fillSlot(x - 1, y + 2);
		fillSlot(x + 1, y + 2);
	}

	private static void fillRookAttack(int x, int y) {
//		board[x][y] = 1;
		int i = x + 1;
		int j = y;
		while (fillSlot(i, j)) {
			i++;
		}
		i = x - 1;
		while (fillSlot(i, j)) {
			i--;
		}
		i = x;
		j = y + 1;
		while (fillSlot(i, j)) {
			j++;
		}
		j = y - 1;
		while (fillSlot(i, j)) {
			j--;
		}

	}

	private static void fillPawnAttack(int x, int y, boolean black) {
//		board[x][y] = 1;
		if (black) {
			fillSlot(x + 1, y + 1);
			fillSlot(x + 1, y - 1);
		} else {
			fillSlot(x - 1, y + 1);
			fillSlot(x - 1, y - 1);
		}
	}

	private static String printboard() {
		String myBoard = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				myBoard = myBoard + board[i][j] + " ";
			}
			myBoard = myBoard + "\n";
		}
		return myBoard;
	}
}
