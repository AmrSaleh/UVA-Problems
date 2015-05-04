
import java.util.Arrays;
import java.util.Scanner;

public class ListofConquests {

	
	public static void main(String[] args) {

		int n;
		String x;
		String[] countries = new String[2000];
		int[] beauties = new int[2000];
		int count = 0;

		Scanner input = new Scanner(System.in);
		n = input.nextInt();

		for (int i = 1; i <= n; i++) {

			if (i == 1) {
				x = input.next();
				countries[0] = x;
//				countries[0][1] = "1";
				beauties[0]=1;
				count++;
				input.nextLine();
			} else {
				boolean found=false;
				x = input.next();

				for (int k = 0; k < count; k++) {
					
					if (countries[k].equals(x)) {
						beauties[k]++;
//						countries[k][1] = beauties[k] + "";
						found =true;
						break;
					} 
				}
				if(found==false){
					countries[count] = x;
//					countries[count][1] = "1";
					beauties[count]=1;
					count++;
				}
				input.nextLine();
			}

		}
		input.close();
		String[] result=new String[count];
		for (int i = 0; i < count; i++) {
			result[i]=countries[i]+" "+beauties[i];
		}
		 Arrays.sort(result);
		

		for (int i = 0; i < count; i++) {
			System.out.println(result[i]);
		}
	}

}
