import java.util.Scanner;

public class TheCocoColaStore {

	public static void main(String[] args) {
		int n;

		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		while (n != 0) {
			System.out.println(n / 2);
			n = input.nextInt();

		}
		input.close();
	}

}
