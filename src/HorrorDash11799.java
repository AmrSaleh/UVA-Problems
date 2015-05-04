import java.util.Scanner;


public class HorrorDash11799 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int x,n,n2;
		int max=0;
		
		n=input.nextInt();
		
		for (int i = 1; i <= n; i++) {
			max=0;
			n2=input.nextInt();
			
			for (int j = 0; j < n2; j++) {
				x= input.nextInt();
				if(x>max) max=x;
			}
			
			System.out.println("Case "+i+": "+max);
		}
		
		input.close();
	}
}
