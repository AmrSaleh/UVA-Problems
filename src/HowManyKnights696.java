import java.util.Scanner;

public class HowManyKnights696 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row, col;
		int answer = 0;

		while (sc.hasNext()) {

			row = sc.nextInt();

			col = sc.nextInt();

			if (row == 0 && col == 0) {
				break;
			}
			if (row == 0 || col == 0) {
				answer = 0;
			} else if (row == 2 && col == 2) {
				answer = 4;
			} else if (row == 1 || col == 1) {
				answer = Math.max(row, col);
			} else if (Math.max(row, col) == 3 && Math.min(row, col) == 2) {
				answer = 4;
			} else if (row == 2) {
				answer = getKnightsof2(col);
			} else if (col == 2) {
				answer = getKnightsof2(row);
			} else {
				answer = (((row + 1) / 2) * ((col + 1) / 2)) + ((row / 2) * (col / 2));
			}

			System.out.println(answer + " knights may be placed on a " + row + " row " + col + " column board.");
		}
		sc.close();
	}

	private static int getKnightsof2(int n) {
		int sum = 0;
		int k = 0;
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (k == 0) {

				flag = true;
			}
			if (k == 2) {
				k = -2;
				flag = false;
			}
			if (flag) {
				
				sum +=  2;
			}
			k++;
			
		}
		return sum;
	}
}
