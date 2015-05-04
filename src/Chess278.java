import java.util.Scanner;

public class Chess278 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, row, col;
		int answer=0;
		String type;

		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			type = sc.next();

			row = sc.nextInt();

			col = sc.nextInt();

			switch (type.charAt(0)) {
			case 'r':
				answer = Math.min(row, col);
				break;
			case 'k':
				
				answer = (((row+1)/2) * ((col+1)/2))+((row/2) * (col/2));
				break;
			case 'Q':
				answer = Math.min(row, col);
				break;
			case 'K':
				answer = (((row+1)/2) * ((col+1)/2));
				break;

			default:
				break;
			}
			
			System.out.println(answer);
		}
		sc.close();
	}
}

