import java.util.Scanner;

public class PlaceTheGuards {

	static int[] cols;
	static int y, x, n;
	static int z = 1;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			z = 1;
			n = input.nextInt();
			if (n < 4) {
				System.out.println("Impossible");
				continue;
			}

			cols = new int[n];

			queen(0);

		}
		input.close();
	}

	public static boolean check(int x, int j) {
		if (j == 0)
			return true;

		int temp = j - 1;
		while (temp >= 0) {
			if (Math.abs(x - cols[temp]) == j - temp)
				return false;
			temp--;
		}
		for (int i = 0; i < j; i++) {
			if (cols[i] == x) {
				return false;
			}
		}

		return true;
	}

	public static void queen(int pos) {
		if (z == 0) {
			return;
		}

		if (pos == n) {

			for (int j = 0; j < n; j++) {
				System.out.print(cols[j]);
				if (j < n - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			z = 0;
			return;
		}
		if (z == 1) {
			for (int i = 1; i <= n; i++) {
				if (z==0){
					return;
				}
				if (check(i, pos)) {
					
					cols[pos] = i;
					queen(pos + 1);
					
				}
			}
		}
		return;

	}
}
