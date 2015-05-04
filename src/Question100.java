import java.util.Scanner;

public class Question100 {

	public static void main(String[] args) {
		int n;
		int y;
		int i = 1;
		int counter;

		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			n = input.nextInt();
			y = input.nextInt();
			int maxCycle = 1;

			System.out.print(n + " " + y + " ");
			if (y < n) {
				int temp = n;
				n = y;
				y = temp;
			}
			counter = n;

			while (counter >= n && counter <= y) {

				i = cycleLenght(counter);
				if (i >= maxCycle) {
					maxCycle = i;
				}

				counter++;
			}
			System.out.println(maxCycle);
		}
		input.close();
	}

	public static int cycleLenght(int x) {
		int n = x;

		int i = 1;

		while (n != 1) {

			if (n % 2 != 0) {
				n = 3 * n + 1;
			} else {
				n = n / 2;
			}

			i++;
		}
		return i;
	}
}
