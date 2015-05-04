import java.util.Scanner;
// not completed yet

public class nQueens {
	static char[][] land;
	
	public static void main(String[] args) {
		int n, m;

		long counter = 1;

		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		while (n != 0) {

			System.out.println("Case "+counter+": "+result);
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

}
