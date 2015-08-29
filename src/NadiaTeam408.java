import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NadiaTeam408 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases;
		cases = Integer.parseInt(br.readLine());
		String line;
		String Nadia = "nadia";
		String Nadia2 = "NADIA";
		int position;
		boolean yes;
		for (int i = 0; i < cases; i++) {
			yes = false;
			position=0;
			line = br.readLine();
			
			for (int j = 0; j < line.length(); j++) {
				if(line.charAt(j) ==Nadia.charAt(position) ||  line.charAt(j) ==Nadia2.charAt(position)){
					position++;
					if(position>=5){
						yes = true;
						System.out.println("YES");
						break;
					}
				}
			}
			if(!yes)
			System.out.println("NO");
		}
	}
}
