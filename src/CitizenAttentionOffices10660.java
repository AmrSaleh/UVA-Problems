import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class CitizenAttentionOffices10660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cases = Integer.parseInt(br.readLine());

		int[][] city = new int[5][5];
		String[] line;
		int filledPlaces;
		boolean[][] visited = new boolean[5][5];
		Integer[][] CostsOfPlaces =new Integer[25][2];
		int index;
		int sum;

		int[] result=new int[5];
		for (int i = 0; i < cases; i++) {
			
			for (int j = 0; j < 5; j++) {
				Arrays.fill(city[j], 0);
				Arrays.fill(visited[j], false);
			}
		
			filledPlaces = Integer.parseInt(br.readLine());

			for (int j = 0; j < filledPlaces; j++) {
				line = br.readLine().split(" ");

				city[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Integer.parseInt(line[2]);

			}
//			System.out.println("-------");
			index=0;
			for (int x = 0; x < 5; x++) {

				for (int y = 0; y < 5; y++) {

					sum=0;
					for (int x2 = 0; x2 < 5; x2++) {

						for (int y2 = 0; y2 < 5; y2++) {
						
								sum+= ((Math.abs(x-x2)+Math.abs(y-y2))*city[x2][y2]);
							
						}
					}
					
					CostsOfPlaces[index][0]=sum;
					CostsOfPlaces[index][1]=(x*5)+y;
					index++;					
//					System.out.print(sum+" ");
				}
//				System.out.println();
			}
			
			
//			Arrays.sort(CostsOfPlaces);
//			System.out.println(CostsOfPlaces[0]+" "+CostsOfPlaces[1]+" "+CostsOfPlaces[2]+" "+CostsOfPlaces[3]+" "+CostsOfPlaces[4]);
			
			
			Arrays.sort(CostsOfPlaces, new Comparator<Integer[]>() {

				@Override
				public int compare(Integer[] entry1, Integer[] entry2) {
					Integer time1 = entry1[0];
					Integer time2 = entry2[0];
					return time1.compareTo(time2);
				}
			});
			
			for (int j = 0; j <5; j++) {
				result[j]=CostsOfPlaces[j][1];
			}
			
			Arrays.sort(result);
			
			System.out.println(result[0]+" "+result[1]+" "+result[2]+" "+result[3]+" "+result[4]);

		}
	}

}
