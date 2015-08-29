import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Bowling584 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] scores;
		int[] bonus = new int[22];
		String line;
		int totalScore = 0;
		line = br.readLine();
		int temp, temp2;
		int incrementFrameFlag;
		int frames;
		int[] IntScores;
		// int upcomingCalculated;
		while (!line.equals("Game Over")) {
			totalScore = 0;

			scores = line.split(" ");
			IntScores = new int[scores.length];
			Arrays.fill(IntScores, -1);
			frames = 0;
			incrementFrameFlag = 0;
			// upcomingCalculated = 0;
			
			for (int i = 0; i < scores.length; i++) {

				if (frames < 10) {
					if (scores[i].charAt(0) == 'X') {
						frames++;
						incrementFrameFlag = 0;

						bonus[i] = 2;
						IntScores[i] = (10);
					} else if (scores[i].charAt(0) == '/') {
						totalScore -= IntScores[i - 1];
						frames++;
						incrementFrameFlag = 0;

						bonus[i] = 1;
						IntScores[i] = (10);

					} else {
						incrementFrameFlag++;
						if (incrementFrameFlag >= 2) {
							frames++;
							incrementFrameFlag = 0;
						}
					}
					if (IntScores[i] != -1) {
						totalScore += IntScores[i];
					} else {
						bonus[i] = 0;

						IntScores[i] = Integer.parseInt(scores[i]);

						totalScore += IntScores[i];
					}
					temp = i + 1;
					temp2 = bonus[i];
					for (int j = 0; j < temp2; j++) {
						// upcomingCalculated++;

						if (IntScores[temp] != -1) {
							totalScore += IntScores[temp];
						} else {
							if (scores[temp].charAt(0) == 'X') {

								bonus[temp] = 2;
								IntScores[temp] = (10);
							} else if (scores[temp].charAt(0) == '/') {

								bonus[temp] = 1;
								IntScores[temp] = (10);

							} else {

								bonus[temp] = 0;
								IntScores[temp] = Integer.parseInt(scores[temp]);
							}

							totalScore += IntScores[temp];
						}

						if (bonus[temp] == 1) {
							totalScore -= IntScores[temp - 1];
						}
						temp++;
					}
				} else {
					break;
				}

			}

			
			System.out.println(totalScore);
			line = br.readLine();
		}



	}

}
