import java.util.Scanner;

public class RankLanguages {

	static char[][] land;
	static boolean[][] visitd;
	static char[] langs=new char[26];
	static int[] times=new int[26];
	static int num=0;

	public static void main(String[] args) {

		int za3bola, m, n;
		int counter=1;

		Scanner input = new Scanner(System.in);
		za3bola = input.nextInt();

		while (za3bola != 0) {
			num=0;
			m = input.nextInt();
			n = input.nextInt();

			
			land = new char[m][n];
			visitd = new boolean[m][n];
			
			System.out.println("World #"+counter);
			counter++;
			for (int x = 0; x < visitd.length; x++) {
				for (int y = 0; y < visitd[0].length; y++) {
					visitd[x][y] = false;
				}
			}

			String line;
			input.nextLine();
			for (int i = 0; i < m; i++) {
				line = input.nextLine();

				for (int j = 0; j < n; j++) {
					land[i][j] = line.charAt(j);
					if(isFound(land[i][j])==-1){
						langs[num]=land[i][j];
						num++;
					}else{
						
					}
				}
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					
						if (visitd[i][j] == false) {
							times[isFound(land[i][j])]++;
							visitd[i][j] = true;
							surrounding(i, j, m, n,land[i][j]);
						} else {

						}
					
				}

			}
			orderTimes();
			orderLangs();
			for(int k=0;k<num;k++){
				System.out.println(langs[k]+": "+times[k]);
			}
			
			za3bola--;
			
			
			for(int t=0;t<num;t++){
				langs[t]='+';
				times[t]=0;
			}
		}
		input.close();
	}

	public static void surrounding(int m, int n, int rows, int cols,char toCount) {
		int dx[] = { 0, -1, 1, 0 };// n
		int dy[] = { -1, 0, 0, 1 };// m

		for (int i = 0; i < dx.length; i++) {
			if (m + dy[i] == -1 || m + dy[i] == rows || n + dx[i] == -1
					|| n + dx[i] == cols) {
				continue;
			}

			if (land[m + dy[i]][n + dx[i]] == toCount) {
				if (visitd[m + dy[i]][n + dx[i]] == true) {

				} else {
					visitd[m + dy[i]][n + dx[i]] = true;
					surrounding(m + dy[i], n + dx[i], rows, cols,toCount);
				}
			}
		}
	}
	
	public static int isFound(char myChar){
		if(num==0){
			return -1;
		}
		
		for(int i=0;i<num;i++ ){
			if(langs[i]==myChar){
				return i;
			}
		}
		
		return -1;
	}
	
	public static void orderTimes(){
		boolean swapFlag = false;
		int loopNo = 0;
		do {
			swapFlag = false; // this variable keeps track of whether to
								// continue sorting or exit
			for (int i = 0; i < num - 1 - loopNo; i++) {
			
				if (times[i] < times[i + 1]) // if current element is greater than the next
				{
					
					swap( i, i + 1); // swap the two elements
					swapFlag = true; // don't end the loop yet, we're not done
					
				}
			}
			loopNo++;
			
			
		} while (swapFlag);
	}
	
	public static void orderLangs(){
		boolean swapFlag = false;
		int loopNo = 0;
		do {
			swapFlag = false; // this variable keeps track of whether to
								// continue sorting or exit
			for (int i = 0; i < num - 1 - loopNo; i++) {
			
				if (langs[i] > langs[i + 1] && times[i]==times[i+1]) // if current element is greater than the next
				{
					
					swap( i, i + 1); // swap the two elements
					swapFlag = true; // don't end the loop yet, we're not done
					
				}
			}
			loopNo++;
			
			
		} while (swapFlag);
	}
	
	public static void swap( int a, int b) {
		int temp = times[a];	
		char temp2 = langs[a];
		times[a] = times[b];
		langs[a] = langs[b];
		times[b] = temp;
		langs[b] = temp2;
		
		
	}
}
