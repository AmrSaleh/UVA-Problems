import java.util.Scanner;

public class Minesweeper {

	static char[][] land;

	public static void main(String[] args) {
		int n, m;

		long counter = 1;

		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		while (n != 0) {

			System.out.println("Field #" + counter + ":");
			counter++;
			land = new char[n][m];

			String line;
			input.nextLine();
			for (int i = 0; i < n; i++) {
				line = input.nextLine();

				for (int j = 0; j < m; j++) {
					land[i][j] = line.charAt(j);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (land[i][j] == '*') {
						System.out.print("*");
					} else {
						System.out.print(checkSurr(i, j, n, m));

					}
				}
				//if (i != n - 1)
					System.out.println();
			}

			n = input.nextInt();
			m = input.nextInt();

			if (n != 0) {
				
				System.out.println();
			}

		}
		input.close();

	}

	public static int checkSurr(int x, int y, int n, int m) {
		int numOfMines = 0;

		boolean[] positions = new boolean[8];
		for (int u = 0; u < positions.length; u++) {
			positions[u] = true;
		}

		if (x == 0) {
			positions[0] = false;
			positions[1] = false;
			positions[2] = false;
		}

		if (y == 0) {
			positions[0] = false;
			positions[3] = false;
			positions[5] = false;
		}

		if (x == n - 1) {
			positions[5] = false;
			positions[6] = false;
			positions[7] = false;
		}

		if (y == m - 1) {
			positions[2] = false;
			positions[4] = false;
			positions[7] = false;
		}

		if (positions[0] == true && land[x - 1][y - 1] == '*') {
			numOfMines++;
		}
		if (positions[1] == true && land[x - 1][y] == '*') {
			numOfMines++;
		}
		if (positions[2] == true && land[x - 1][y + 1] == '*') {
			numOfMines++;
		}
		if (positions[3] == true && land[x][y - 1] == '*') {
			numOfMines++;
		}
		if (positions[4] == true && land[x][y + 1] == '*') {
			numOfMines++;
		}
		if (positions[5] == true && land[x + 1][y - 1] == '*') {
			numOfMines++;
		}
		if (positions[6] == true && land[x + 1][y] == '*') {
			numOfMines++;
		}
		if (positions[7] == true && land[x + 1][y + 1] == '*') {
			numOfMines++;
		}

		return numOfMines;
	}

}
