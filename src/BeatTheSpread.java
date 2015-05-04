import java.util.Scanner;
public class BeatTheSpread {


	public static void main(String[] args) {
		int n,sum,dif;
		int x,y;

		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		for(int i=1;i<=n;i++){
			sum=input.nextInt();
			dif=input.nextInt();
			
			if((sum+dif)%2!=0){
				System.out.println("impossible");
			}else{
				x=(sum+dif)/2;
				y=sum-x;
				
				if(y<0){
					System.out.println("impossible");
				}else{
					System.out.println(x+" "+y);
				}
				
			}
			
			

		}
		input.close();
	

	}

}
