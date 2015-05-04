import java.util.Scanner;
// not submitted  maybe wrong // don't understand problem correctly
public class Bacteria {

	public static void main(String[] args) {
		long n,k,b,t;
		long x=1;
		
		Scanner input = new Scanner(System.in);
		k = input.nextInt();
		b = input.nextInt();
		n = input.nextInt();
		t = input.nextInt();
		while (x<t) {
			x=(k*x)+b;
			n--;
		}
		
		if(n<0){
			System.out.println("0");
			
		}else{
			System.out.println(n+1);
		}
		
		input.close();
	}

}


	