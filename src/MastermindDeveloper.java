import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MastermindDeveloper {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases;
		cases = Integer.parseInt(br.readLine());
		int num;
		int sum;
		boolean[] uncommentedLines;
		
		for (int i = 0; i < cases; i++) {
			num = Integer.parseInt(br.readLine());
			uncommentedLines = new boolean[num];
			for (int j = 2; j <= uncommentedLines.length; j++) {
				for (int j2 = j-1; j2 < uncommentedLines.length; j2+=j) {
					uncommentedLines[j2] = !uncommentedLines[j2];
				}
			}
			
			sum =0;
			for (int j = 0; j < uncommentedLines.length; j++) {
				if(!uncommentedLines[j]){
					sum++;
				}
			}
			
			System.out.println(sum);
		}
	}
}
