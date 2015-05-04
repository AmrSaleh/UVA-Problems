import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Password4845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] cols1 = new char[5][6];
		char[][] cols2 = new char[5][6];

		char[][] similar = new char[5][6];
		int[] ColSimilaritiesNo = new int[5];

		String[] answer;

		int cases;
		int k;

		String line;
		int product;
		int counter;

		boolean flag;

		cases = Integer.parseInt(br.readLine());

		for (int i = 0; i < cases; i++) {

			
			Arrays.fill(ColSimilaritiesNo, 0);

			k = Integer.parseInt(br.readLine());

			for (int j = 0; j < 6; j++) {
				line = br.readLine();

				for (int j2 = 0; j2 < cols1.length; j2++) {
					cols1[j2][j] = line.charAt(j2);
				}
			}

			for (int j = 0; j < 6; j++) {
				line = br.readLine();
				for (int j2 = 0; j2 < cols2.length; j2++) {
					cols2[j2][j] = line.charAt(j2);
				}
			}

			for (int j = 0; j < cols2.length; j++) {

				Arrays.sort(cols1[j]);
				Arrays.sort(cols2[j]);
			}

			for (int j = 0; j < cols2.length; j++) {
				for (int j2 = 0; j2 < cols2[j].length; j2++) {
					if (Arrays.binarySearch(cols2[j], cols1[j][j2]) >= 0) {
						similar[j][ColSimilaritiesNo[j]] = cols1[j][j2];
						ColSimilaritiesNo[j]++;
					}
				}

			}

//			product = 1;
//			for (int j = 0; j < ColSimilaritiesNo.length; j++) {
//				product *= ColSimilaritiesNo[j];
//			}
//
//			if (product < k) {
//				System.out.println("NO");
//				continue;
//			}

			counter = 0;
			answer = new String[k];
			flag = false;

			for (int j0 = 0; j0 < ColSimilaritiesNo[0]; j0++) {
				for (int j1 = 0; j1 < ColSimilaritiesNo[1]; j1++) {
					for (int j2 = 0; j2 < ColSimilaritiesNo[2]; j2++) {
						for (int j3 = 0; j3 < ColSimilaritiesNo[3]; j3++) {
							for (int j4 = 0; j4 < ColSimilaritiesNo[4]; j4++) {

								answer[counter] = (similar[0][j0]+"") + (similar[1][j1]+"") + (similar[2][j2]+"") + (similar[3][j3]+"") + (similar[4][j4] + "")+"";
								counter++;

								if (counter >= k) {
									flag = true;
									break;
								}
							}

							if (flag) {
								break;
							}
						}
						if (flag) {
							break;
						}
					}
					if (flag) {
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			
//			Arrays.sort(answer);
			
			if (counter>=k) {
				System.out.println(answer[k-1]+"");
			}else{
				System.out.println("NO");
			}

		}

	}
}

