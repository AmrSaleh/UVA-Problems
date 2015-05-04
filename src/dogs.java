import java.util.Scanner;

public class Main {
	
	
public static int m;
public static long counter;
public static int[] dogsRange=new int[50];
public static boolean[] visited= new boolean[1100];//initially false
	public static void main(String[] args) {
		int n;
		
		
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		for(int i = 0 ; i < n ; i++)
		{
			counter=0;
			m = input.nextInt();
			
			for(int k=0;k<m;k++){
				dogsRange[k]=input.nextInt();
			}
			
			rec(0);
			System.out.println(counter);

		}
		input.close();
	}
	
	public static void rec(int index){
		
		if(index>=m){
			counter++;
			return;
		}
		
		for(int i=1;i<=dogsRange[index];i++)
		{
			if(visited[i]==false)
			{
				visited[i]=true;
				rec(index+1);
				visited[i] = false;
			}
		}
	}

}
