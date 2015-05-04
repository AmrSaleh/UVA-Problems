import java.util.Scanner;

public class stones {
	static int piles[];
	static int m;
	public static boolean visited[];
	public static void main(String[] args) {
		int n;
		
		
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		
		
		
		for (int i = 1; i <= n; i++) {
			m = input.nextInt();
			piles=new int[m];
			visited = new boolean[m]; // initialy false
			for(int k=0;k<m;k++){
				piles[k]=input.nextInt();
				
			}

		}
		input.close();
	}
	
	
	
	public void rec(int first, int second, int counter)
	{
		for(int i = 0 ; i < m ; i++)
		{
			if()
			{
				
			}
						
		}
	}
	
	

}
