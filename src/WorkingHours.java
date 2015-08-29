import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class WorkingHours {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases;
		int emps;
		int min;
		int max;
		int subtract,sum;
		cases = Integer.parseInt(br.readLine());
		
		int[] numbers=new int[2];
		String[] line=new String[2];
		int[][] inputPairs;
		
		for(int i=0;i<cases;i++){
			emps = Integer.parseInt(br.readLine());
			min=Integer.MAX_VALUE;
			max=0;
			
			inputPairs= new int[emps][2];
			for (int j = 0; j < emps; j++) {
				line[0] = br.readLine();
				line = line[0].split("\\s+");
				numbers[0]=Integer.parseInt(line[0]);
				numbers[1]=Integer.parseInt(line[1]);
				
				inputPairs[j][0]=numbers[0];
				inputPairs[j][1]=numbers[1];
				
//				if(numbers[0]<min || j==0){
//					min = numbers[0];
//				}
//				if(numbers[1]>max){
//					max = numbers[1];
//				}
				
			}
			
//			sum = max -min;
			// read all input
			
			Arrays.sort(inputPairs, new Comparator<int[]>() {
	            @Override
	            public int compare(final int[] entry1, final int[] entry2) {
	                final int time1 = entry1[0];
	                final int time2 = entry2[0];
	                return time1-time2;
	            }
	        });
			
			subtract =0;
			max=0;
			sum=inputPairs[0][1]-inputPairs[0][0];
			for (int j = 1; j < inputPairs.length; j++) {
				
				sum += inputPairs[j][1]-inputPairs[j][0];
				if(inputPairs[j][0]>inputPairs[j-1][1]){
					subtract = subtract + (inputPairs[j][0]-inputPairs[j-1][1]);
				}
			}
			sum -= subtract;
			System.out.println(sum);
		}

	}
	
	

	
}
