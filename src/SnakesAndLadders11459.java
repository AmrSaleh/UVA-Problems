import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SnakesAndLadders11459 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] board;
		String[] tokens;
		int players, shortCuts, rolls;
		int[] playersPos;
		int cases = Integer.parseInt(br.readLine());
		int j2;
		boolean IgnoreRoll = false;

		for (int i = 0; i < cases; i++) {
			board = new int[101];
			tokens = br.readLine().split(" ");

			players = Integer.parseInt(tokens[0]);
			shortCuts = Integer.parseInt(tokens[1]);
			rolls = Integer.parseInt(tokens[2]);

			playersPos = new int[players];
			Arrays.fill(playersPos, 1);

			for (int j = 0; j < shortCuts; j++) {
				tokens = br.readLine().split(" ");
				board[Integer.parseInt(tokens[0])] = Integer.parseInt(tokens[1]);
			}

			IgnoreRoll = false;
			j2 = 0;
			for (int j = 0; j < (rolls); j++) {

				if (IgnoreRoll) {
					br.readLine();
					continue;
				}

				playersPos[j2] += Integer.parseInt(br.readLine());

				// set ignoreRoll
				if (playersPos[j2] >= 100) {
					playersPos[j2] = 100;
					IgnoreRoll = true;
					continue;
				}

				// check shortCuts
				if (board[playersPos[j2]] != 0) {
					playersPos[j2] = board[playersPos[j2]];
				}

				// set ignoreRoll
				if (playersPos[j2] >= 100) {
					playersPos[j2] = 100;
					IgnoreRoll = true;
					continue;
				}

				j2++;
				if(j2>=players){
					j2=0;
				}
			}

			for (int j = 0; j < players; j++) {
				System.out.println("Position of player " + (j + 1) + " is " + playersPos[j] + ".");
			}
		}

	}

}
