import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MagicNumbers471 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long numerator = 0;
		long denominator;
		long number;
		long max = 9876543211L;
		int cases;

		cases = Integer.parseInt(br.readLine());

		for (int i = 0; i < cases; i++) {
			br.readLine();
			number = Long.parseLong(br.readLine()); // number must be not equal
													// to zero

			for (denominator = 1, numerator = 0; numerator < max; denominator++) {

				if (!validate(denominator)) {
					continue;
				}

				numerator = denominator * number;

				if (!validate(numerator)) {
					continue;
				}
				
				System.out.println(numerator+" / "+denominator+" = "+number);

			}
			
			if (i != cases-1) {
				System.out.println();
			}

		}

	}

	static String container;
	static boolean[]  visited= new boolean[10];
	static int position;
	private static boolean validate(long num) {
		Arrays.fill(visited, false);
		container=num+"";
		
		for (int i = 0; i < container.length(); i++) {
			position = Integer.parseInt(container.charAt(i)+"");
			if (visited[position]) {
				return false;
			}
			visited[position] = true;
		}
		

		return true;
	}

}
