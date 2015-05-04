import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int m;

	public static void main(String[] args) {
		int n,max,value;
		long count;
		
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		
		
		
		for (int i = 1; i <= n; i++) {
			max=-1;
			m = input.nextInt();
			
			count=0;
			for(int k=0;k<m;k++){
				value=input.nextInt();
				count+=value;
				
				if(value>max){
					max=value;
				}
			}
			
			count-=max;
			
			System.out.println(count);
			

		}
		input.close();
	}
	
	
	
	
	

}
