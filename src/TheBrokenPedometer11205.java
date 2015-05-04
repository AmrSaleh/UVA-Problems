import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class TheBrokenPedometer11205 {

	static int numOfLeds,numOfDigits;
	static String[] digits;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(br.readLine());
		
		
		
		for (int i = 0; i < cases; i++) {
			
			numOfLeds = Integer.parseInt(br.readLine());
			numOfDigits = Integer.parseInt(br.readLine());
			
			digits = new String[numOfDigits];
			
			for (int j = 0; j <numOfDigits; j++) {
				digits[j] = br.readLine().replaceAll(" ","");
				
			}
			
			System.out.println(getMinNumberOfNeededLeds());
			
		}

	}

	  public static int r;
	  public static int length;
	  public static int[] output;
	  static boolean accepted;
	private static int getMinNumberOfNeededLeds() {
		
		int num = numOfLeds;
		length = numOfLeds;
		output = new int[numOfLeds];
		 accepted=false;
		for (int i = 1; i < numOfLeds; i++) {
			if (accepted) {
				break;
			}
			r=i;
			
			generateCombinations(0, 0);
		}
		
		if (accepted) {
			return r;
		}
		return num;
	}

	
	
   
  static HashMap<String, Integer> foundSequenses=new HashMap<String, Integer>();
    static String subString;
	public static void generateCombinations(int i, int j) {
		if (accepted) {
			return;
		}
        if (j == r) {
//        	System.out.println(Arrays.toString(output));
                //go through r places of the output
        	foundSequenses.clear();
        	
        	for (int j2 = 0; j2 < numOfDigits; j2++) {
        		subString="";
        		for (int k = 0; k < r; k++) {
        			subString+=digits[j2].charAt(output[k]);
//        			System.out.print(output[k]);
				}
//        		System.out.println();
        		if (foundSequenses.containsKey(subString)) {
					//failed
        			return;
				}
        		
        		foundSequenses.put(subString, 0);
			}
        	
        	accepted =true;
                
        } else if (length - i < r - j) {
                /* prune this branch */
                return;
        } else {
                output[j] =i;
                generateCombinations(i + 1, j + 1);
                output[j] = -1;
                generateCombinations(i + 1, j);
        }
}
}

