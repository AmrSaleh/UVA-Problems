import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GridGame11553 {

	static int[][] grid;
	static int dimensions;
	static boolean[] rowVisited;
	static boolean[] colVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cases = Integer.parseInt(br.readLine());

		String[] line;

		for (int i = 0; i < cases; i++) {
			dimensions = Integer.parseInt(br.readLine());
			grid = new int[dimensions][dimensions];
			rowVisited = new boolean[dimensions];
			colVisited = new boolean[dimensions];
			output = new int[dimensions];
			totalMin = Integer.MAX_VALUE;
			for (int j = 0; j < dimensions; j++) {
				line = br.readLine().split(" ");
				for (int j2 = 0; j2 < line.length; j2++) {
					grid[j][j2] = Integer.parseInt(line[j2]);
					// System.out.print(grid[j][j2] + " ");
				}
				// System.out.println();
			}

//			System.out.println(generateSolution());
			permute(0);
			System.out.println(totalMin);
		}

	}
	
	
	
	
	  public static int[] output;
	static int tempMin,minX,sum,totalMin;
	 /* prints all permutations, i is the next place to fill in output */
    public static void permute(int i) {
            if (i == dimensions) {
//                    System.out.println(Arrays.toString(output));
            	sum=0;minX=-1;
            	Arrays.fill(rowVisited, false);
            	for (int j = 0; j < output.length; j++) {
					tempMin=Integer.MAX_VALUE;
            		for (int j2 = 0; j2 < rowVisited.length; j2++) {
						if (grid[j2][output[j]] < tempMin && rowVisited[j2]==false) {
							tempMin =grid[j2][output[j]];
							minX = j2; 
						}
					}
            		
            		rowVisited[minX]=true;
            		sum+=grid[minX][output[j]];
				}
//            	System.out.println(sum);
            	if (sum < totalMin) {
					totalMin=sum;
				}
            } else {
                    int j;
                    for (j = 0; j < dimensions; j++)
                            if (!colVisited[j]) {
                            	colVisited[j] = true;// mark j as visited(remove it from the
                                                                            // set)
                                    output[i] = j;// add it to the output
                                    permute(i + 1);// recurse on the left set
                                    output[i] = 0;// not needed
                                    colVisited[j] = false;// umark j(backtrack)
                            }
            }
    }
	
	
	
	
	
	
	
//	
//	
//
//	private static int generateSolution() {
//		
//		int min = Integer.MAX_VALUE;
//		int temp=0;
//		int max=Integer.MIN_VALUE;
//		int y=-1;
//		int x=-1;
////		int tempY=-1;
//		for (int i = 0; i < rowVisited.length; i++) {
//			if (rowVisited[i] == false) {
//				rowVisited[i] = true;
//				 min = Integer.MAX_VALUE;
//				for (int j = 0; j < colVisited.length; j++) {
//					if (colVisited[j] == false) {
//						
//						x=i;
//						y=j;
//						colVisited[y] = true;
//						temp=generateSolution();
//						colVisited[y] = false;
//						if (temp<min) {
//							min=temp;
////							x=i;
////							y=tempY;
//						}
//						
//						
////						if (grid[i][j]<min) {
////							min=grid[i][j];
////							tempY=j;
////						}
//					}
//				}
//				
//				
//				
//				rowVisited[i] = false;
//			}
//		}
//		
//		if (x==-1 || y==-1) {
//			return 0;
//		}
//		return grid[x][y]+min;
//	}
}
