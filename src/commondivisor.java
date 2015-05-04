import java.util.Scanner;

public class commondivisor {

	public static void main(String[] args) {
		int n, x, y, z,gcd,xx,yy;
		int count;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();

		for (int i = 1; i <= n; i++) {
			count = 1;
			x = input.nextInt();
			y = input.nextInt();

			z = Math.min(x, y);
			while (x>1 && y>1) {
				xx=x;yy=y;
				while (xx != yy) {
					if (xx > yy){
					xx = xx - yy;
					}else{
					yy =yy - xx;
					
					}
				}
				gcd= xx;
				x=x-gcd;
				y=y-gcd;
				
				count++;
			}

			System.out.println(count);
		}
		input.close();
	}

}
