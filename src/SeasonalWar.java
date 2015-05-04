import java.util.Scanner;

public class SeasonalWar {

	static char[][] land;
	static boolean[][] visitd;

	public static void main(String[] args) {
		int m;
		int counter;
		int num = 0;
		Scanner input = new Scanner(System.in);
	
		while (input.hasNext()) {
			m = input.nextInt();

			num++;
			land = new char[m][m];
			visitd = new boolean[m][m];
			counter = 0;
			for (int x = 0; x < visitd.length; x++) {
				for (int y = 0; y < visitd[0].length; y++) {
					visitd[x][y] = false;
				}
			}

			String line;
			input.nextLine();
			for (int i = 0; i < m; i++) {
				line = input.nextLine();

				for (int j = 0; j < m; j++) {
					land[i][j] = line.charAt(j);
				}
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					if (land[i][j] == '1') {
						if (visitd[i][j] == false) {
							counter++;
							visitd[i][j] = true;
							surrounding(i, j, m, m);
						} else {

						}
					}
				}

			}

			System.out.println("Image number " + num + " contains " + counter
					+ " war eagles.");
			
		}
		input.close();
	}

	public static void surrounding(int m, int n, int rows, int cols) {
		int dx[] = { -1, 0, 1, -1, 1, -1, 0, 1 };// n
		int dy[] = { -1, -1, -1, 0, 0, 1, 1, 1 };// m

		for (int i = 0; i < dx.length; i++) {
			if (m + dy[i] == -1 || m + dy[i] == rows || n + dx[i] == -1
					|| n + dx[i] == cols) {
				continue;
			}

			if (land[m + dy[i]][n + dx[i]] == '1') {
				if (visitd[m + dy[i]][n + dx[i]] == true) {

				} else {
					visitd[m + dy[i]][n + dx[i]] = true;
					surrounding(m + dy[i], n + dx[i], rows, cols);
				}
			}
		}
	}

}
