import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Offices {
	static int num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases;
		
		cases = Integer.parseInt(br.readLine());
		for (int i = 0; i < cases; i++) {
			num = Integer.parseInt(br.readLine());
	            offices("", 0, 0, 0);
		}
	}
	
	
    private static void offices(String combinationString, int openBracket, int closeBracket,int check)
    {
        if((openBracket==num)&&(closeBracket==num))
        {
            System.out.println(combinationString);
        }
        else
        {
            if(openBracket<num){
            	
            	offices(combinationString + "(", openBracket+1, closeBracket,check+1);
            }
            if(closeBracket<openBracket && check >0){
            	offices(combinationString + ")", openBracket, closeBracket+1,check-1);
            }
        }
    }
}
