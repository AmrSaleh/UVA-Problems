import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheMRCTeam407 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases;
		cases = Integer.parseInt(br.readLine());
		int number,temp, count;
		for (int i = 0; i < cases; i++) {
			number = Integer.parseInt(br.readLine());
			count =0;
			
			temp = number;
			while(temp >0){
				temp = temp/10;
				count++;
			}
			
			System.out.println(count);

		}
	}

}
