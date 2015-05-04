import java.util.Scanner;

public class EightQueensChessProblem {

	static int[] cols = new int[8];
	static int y,x;
	static int count;

	public static void main(String[] args) {
		int n;
	

		Scanner input = new Scanner(System.in);
		n = input.nextInt();
	
		for (int i = 1; i <= n; i++) {
			count = 1;
			System.out.println("SOLN       COLUMN");
			System.out.println(" #      1 2 3 4 5 6 7 8");
			System.out.println();
			x = input.nextInt();
			y = input.nextInt() - 1;

			cols[y] = x;

			queen(0);
			if(i<n){
				System.out.println();
			}
		}
		input.close();
	}

	public static boolean check(int x, int j) {
		if (j == 0)
			return true;
		
		int temp=j-1;
		while(temp>=0){
		if (Math.abs(x - cols[temp]) == j-temp)
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
		if (pos == y) {
			if (check(cols[y], y)) {
				queen(pos + 1);
				return;
			} else {
				return;
			}
		}

		if (pos == 8) {
			if(count<=9){
			System.out.print(" " + count + "     ");
		}else{
			System.out.print("" + count + "     ");
		}
			for (int j = 0; j < 8; j++) {
				System.out.print(" " + cols[j]);
			}
			System.out.println();
			count++;
			return;
		}

		for (int i = 1; i <= 8; i++) {
			if (check(i, pos)) {
				cols[pos] = i;
				queen(pos + 1);
			}
		}

	}
}
