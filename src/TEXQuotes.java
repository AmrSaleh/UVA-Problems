import java.util.Scanner;

public class TEXQuotes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		while (in.hasNext()) {
			String s = in.nextLine();
			String result = "";

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '\"') {
					if (flag) {
						result += "``";
						flag = false;
					} else {
						result += "\'\'";
						flag = true;
					}
				} else {
					result += s.charAt(i);
				}
			}
			System.out.println(result);
		}
	}
}