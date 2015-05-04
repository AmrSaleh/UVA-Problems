import java.util.Scanner;

public class BridgeHandEvaluator462 {

	static String card;
	static int suit = -1;

	static String suitNames = "SHDC";
	static int[] suitsCards = new int[4]; // S H D C
	static boolean[] stoppedSuit = new boolean[4];
	static int[] acesInSuit = new int[4];
	static int[] kingsInSuit = new int[4];
	static int[] queensInSuit = new int[4];
	static int[] jacksInSuit = new int[4];

	static int totalScore = 0;

	static boolean done = false;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			initialize();
			for (int i = 0; i < 13; i++) {
				card = input.next();

				switch (card.charAt(1)) {
				case 'S':
					suit = 0;
					break;
				case 'H':
					suit = 1;
					break;
				case 'D':
					suit = 2;
					break;
				case 'C':
					suit = 3;
					break;

				default:
					suit = -1;
					break;
				}

				switch (card.charAt(0)) {
				case 'A':
					totalScore += 4;
					acesInSuit[suit]+=1;
					break;
				case 'K':
					totalScore += 3;
					kingsInSuit[suit]+=1;
					break;
				case 'Q':
					totalScore += 2;
					queensInSuit[suit]+=1;
					break;
				case 'J':
					totalScore += 1;
					jacksInSuit[suit]+=1;
					break;

				default:
					break;
				}
				
				suitsCards[suit]+=1;
			}

			checkStopSuitAndSubtract();

			if (totalScore >= 16 && allSuitsStopped()) {
				System.out.println("BID NO-TRUMP");
				done = true;
			}

			if (!done) {
				addPoints();

				if (totalScore < 14) {
					System.out.println("PASS");
				} else {

					suit = getMaxCardSuit();
					System.out.println("BID " + suitNames.charAt(suit));
				}

			}

		}
		input.close();
	}

	private static void initialize() {
		done = false;
		totalScore = 0;
		for (int suitNo = 0; suitNo < 4; suitNo++) {
			suitsCards[suitNo] = 0;
			stoppedSuit[suitNo] = false;
			acesInSuit[suitNo] = 0;
			kingsInSuit[suitNo] = 0;
			queensInSuit[suitNo] = 0;
			jacksInSuit[suitNo] = 0;
		}

	}

	private static int getMaxCardSuit() {
		int max = 0;
		int index = 0;
		for (int suitNo = 0; suitNo < 4; suitNo++) {
			if (suitsCards[suitNo] > max) {
				max = suitsCards[suitNo];
				index = suitNo;
			}
		}
		return index;
	}

	private static void checkStopSuitAndSubtract() {

		for (int suitNo = 0; suitNo < 4; suitNo++) {
			if (acesInSuit[suitNo] > 0) {
				stoppedSuit[suitNo] = true;
			} else if (kingsInSuit[suitNo] > 0 && suitsCards[suitNo] > 1) {
				stoppedSuit[suitNo] = true;
			} else if (queensInSuit[suitNo] > 0 && suitsCards[suitNo] > 2) {
				stoppedSuit[suitNo] = true;
			}

			if (suitsCards[suitNo] == 1 && kingsInSuit[suitNo] > 0) {
				totalScore -= 1;
			}

			for (int i = 0; (i < queensInSuit[suitNo] && suitsCards[suitNo] < 3); i++) {
				totalScore -= 1;
			}

			for (int i = 0; (i < jacksInSuit[suitNo] && suitsCards[suitNo] < 4); i++) {
				totalScore -= 1;
			}
		}
	}

	private static void addPoints() {
		for (int suitNo = 0; suitNo < 4; suitNo++) {
			if (suitsCards[suitNo] == 2) {
				totalScore += 1;
			} else if (suitsCards[suitNo] == 1) {
				totalScore += 2;
			} else if (suitsCards[suitNo] == 0) {
				totalScore += 2;
			}
		}
	}

	private static boolean allSuitsStopped() {
		for (int suitNo = 0; suitNo < 4; suitNo++) {
			if (!stoppedSuit[suitNo]) {
				return false;
			}
		}
		return true;
	}

}
