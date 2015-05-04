import java.util.Arrays;
import java.util.Scanner;

public class WordTransformation429 {

	static String[] dictionary = new String[200];
	static boolean[] visited = new boolean[200];
	static int NumOfWords = 0;
	static int firstElementPlace;

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);

		String line;
		int n;

		String[] tempTestCase = new String[2];

		line = sc.nextLine();
		n = Integer.parseInt(line);
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			NumOfWords = 0;
			Arrays.fill(dictionary, "");
			line = sc.nextLine();

			while (!line.equals("*")) {
				NumOfWords++;
				dictionary[NumOfWords - 1] = line;

				line = sc.nextLine();
			}

			Arrays.sort(dictionary);
			firstElementPlace = 200 - NumOfWords;
			line = sc.nextLine();
			while (!line.equals("")) {
				tempTestCase = line.split(" ");

				System.out.println(line + " " + getNumOfSteps(tempTestCase[0], tempTestCase[1]));

				if (sc.hasNext()) {
					line = sc.nextLine();
				} else {
					line = "";
				}
			}

			if (i != n - 1) {
				System.out.println();
			}
		}
		sc.close();

	}

	static int tempLengthOfSiblings;

	private static int getNumOfSteps(String first, String second) {

		int[] siblings = new int[200];
		int indexOfFirst, minNumber, temp;
		int lengthOfSiblings;

		if (first.equals(second)) {

			return 0;
		}

		indexOfFirst = Arrays.binarySearch(dictionary, first);
		visited[indexOfFirst] = true;

		siblings = getSiblings(first).clone();
		lengthOfSiblings = tempLengthOfSiblings;
		minNumber = 201;

		for (int i = 0; i < lengthOfSiblings; i++) {
			temp = getNumOfSteps(dictionary[siblings[i]], second);

			if (temp < minNumber) {
				minNumber = temp;
			}

		}

		visited[indexOfFirst] = false;
		return minNumber + 1;
	}

	private static int[] getSiblings(String first) {

		int[] siblings = new int[200];
		tempLengthOfSiblings = 0;
		int index = firstElementPlace;
		for (int i = 0; i < NumOfWords; i++) {
			if (visited[index] == true) {
				index++;
				continue;
			}

			if (checkSibling(first, dictionary[index])) {
				siblings[tempLengthOfSiblings] = index;
				tempLengthOfSiblings++;

			}
			index++;
		}
		return siblings;
	}

	static int Difference;

	private static boolean checkSibling(String first, String second) {

		if (first.length() != second.length()) {
			return false;
		}

		Difference = 0;

		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)) {
				Difference++;
			}
		}

		if (Difference == 1) {
			return true;
		}

		return false;
	}

}
