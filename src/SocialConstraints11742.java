import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SocialConstraints11742 {

	static int n;
	static boolean[] visited;
	static int[] output; 
	static int[] places;
	static int[][] conditions;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line=br.readLine().split(" ");
		
		n = Integer.parseInt(line[0]);
		
		int specialCases = Integer.parseInt(line[1]);
		
		
		
		while(n!=0 || specialCases !=0){
			result=0;
			visited=new boolean[n];
			output = new int[n];
			places = new int[n];
			conditions = new int[specialCases][3];
			//Read Special Cases
			for (int i = 0; i < specialCases; i++) {
				line = br.readLine().split(" ");
				
				conditions[i][0] = Integer.parseInt(line[0]);
				conditions[i][1] = Integer.parseInt(line[1]);
				conditions[i][2] = Integer.parseInt(line[2]);
			}
			
			
			permute(0);
			
			System.out.println(result);
			
			line = br.readLine().split(" ");
			 n = Integer.parseInt(line[0]);
			 specialCases = Integer.parseInt(line[1]);
		}
		

	}
	
	static boolean accept;
	 /* prints all permutations, i is the next place to fill in output */
    public static void permute(int i) {
            if (i == n) {
                 //   System.out.println(new String(output));
            	accept=true;
            	if(conditions.length>0){
            		for (int j = 0; j < output.length; j++) {
						places[output[j]]=j;
					}
            	}
            	
            	for (int j = 0; j <conditions.length; j++) {
					if (conditions[j][2]>0) {
						if (Math.abs(places[conditions[j][0]]-places[conditions[j][1]])>Math.abs(conditions[j][2])) {
							accept=false;
							break;
						}
					}else{
						if (Math.abs(places[conditions[j][0]]-places[conditions[j][1]])<Math.abs(conditions[j][2])) {
							accept=false;
							break;
						}
					}
				}
            	
            	if (accept) {
					result++;
				}
            	
            	
            } else {
                    int j;
                    for (j = 0; j < n; j++)
                            if (!visited[j]) {
                                    visited[j] = true;// mark j as visited(remove it from the
                                                                            // set)
                                    output[i] = j;// add it to the output
                                    permute(i + 1);// recurse on the left set
                                    output[i] = 0;// not needed
                                    visited[j] = false;// umark j(backtrack)
                            }
            }
    }

}
