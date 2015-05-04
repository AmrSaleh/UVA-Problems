import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BlockVoting435 {

	static Integer[][] parties;
	static int[] partiesPowers;

	static int halfMajority;
	static int n;
	static int numberOfParties;

	public static void main(String[] args) throws  IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cases;
		int[] order;
		String[] ReadingArray;

		cases = Integer.parseInt(br.readLine());

		for (int i = 0; i < cases; i++) {

			ReadingArray = br.readLine().split(" ");
			numberOfParties = Integer.parseInt(ReadingArray[0]);

			parties = new Integer[numberOfParties][2];
			partiesPowers = new int[numberOfParties];
			order = new int[numberOfParties];

			halfMajority = 0;
			for (int j = 0; j < parties.length; j++) {
				parties[j][0] = j;
				parties[j][1] = Integer.parseInt(ReadingArray[j + 1]);
				halfMajority += parties[j][1];
			}

			Arrays.sort(parties, new Comparator<Integer[]>() {

				@Override
				public int compare(Integer[] entry1, Integer[] entry2) {
					Integer time1 = entry1[1];
					Integer time2 = entry2[1];
					return time2.compareTo(time1);
				}
			});

			for (int j = 0; j < parties.length; j++) {
				order[parties[j][0]] = j;
			}

			// reverse();

			halfMajority = halfMajority / 2;
			n = 0;

			getCombinations();

			for (int j = 0; j < order.length; j++) {
				System.out.println("party " + (parties[order[j]][0] + 1) + " has power index " + partiesPowers[order[j]]);
			}

			if (i != cases - 1) {
				System.out.println();
			}
		}

	}

	// private static void reverse() {
	// int temp;
	// int last = parties.length - 1;
	// for (int i = 0; i < parties.length / 2; i++) {
	// temp = parties[i];
	// parties[i] = parties[last];
	// parties[last] = temp;
	// last--;
	// }
	//
	// }

	// public static void getCombinations() {
	// int n = parties.length; // The size of the set
	// // int r = 2; // The size of the subsets (r!=0)
	//
	// for (int r = 2; r <= n; r++) {
	//
	// /*
	// * combinations[i] is the index of the i-th element in the
	// * combination
	// */
	// int[] combinations = new int[20];
	//
	// /* Setup combinations[] for the initial combination (0-based) */
	// for (int i = 0; i < r; ++i)
	// combinations[i] = i;
	//
	// /* Print the first combination */
	// printCombination(combinations, r);
	//
	// /* Generate and print all the other combinations */
	// while (nextCombination(combinations, r, n)) {
	// printCombination(combinations, r);
	// }
	//
	// }
	// }
	//
	// private static boolean nextCombination(int[] combinations, int r, int n)
	// {
	// int i = r - 1;
	// combinations[i]++;
	// while (i > 0 && combinations[i] >= n - r + 1 + i) {
	// i--;
	// combinations[i]++;
	// }
	//
	// /* Combination (n-k, n-k+1, ..., n) reached */
	// /* No more combinations can be generated */
	// if (combinations[0] > n - r)
	// return false;
	//
	// /*
	// * Combination now looks like (..., x, n, n, n, ..., n). Turn it into
	// * (..., x, x + 1, x + 2, ...)
	// */
	// for (i = i + 1; i < r; i++)
	// combinations[i] = combinations[i - 1] + 1;
	//
	// return true;
	// }
	//
	// private static void printCombination(int[] combinations, int r) {
	// String comb = "";
	// int sum = 0;
	//
	// for (int i = 0; i < r; i++) {
	// comb = comb + (combinations[i]) + "";
	// sum += parties[combinations[i]];
	// }
	//
	// System.out.println(sum);
	// if (sum > halfMajority) {
	// for (int i = 0; i < comb.length(); i++) {
	// if (sum - parties[Integer.parseInt(comb.charAt(i) + "")] <= halfMajority)
	// {
	// partiesPowers[Integer.parseInt(comb.charAt(i) + "")]++;
	// }
	// }
	//
	// }
	//
	// }

	static int r;
	static char[] output;
	static int sum;
	static boolean skip;
	static char skipIndex;
	static int testCount;

	public static void getCombinations() {
		testCount = 0;
		output = new char[numberOfParties+1];
		sum = 0;
		skip = false;
		skipIndex='X';
		for (int i = 2; i <= numberOfParties; i++) {
			skip = false;
			skipIndex='X';
			r = i;
			output = new char[numberOfParties];
			sum = 0;
			generateCombinations(0, 0);
		}

//		 System.out.println("count: "+testCount);
	}

	/*
	 * i is the first element which we didnt make decision for,j is the next
	 * place to fill in output
	 */

	public static void generateCombinations(int i, int j) {
		if (skip) {
			return;
		}
		testCount++;
		if (j == r) {
//			 System.out.println(new String(output));

			if (sum > halfMajority) {
				for (int i1 = 0; i1 < r; i1++) {
					if (sum - parties[Integer.parseInt(output[i1] + "")][1] <= halfMajority) {
						partiesPowers[Integer.parseInt(output[i1] + "")]++;
					}
				}
			} else {
//				skip = true;
				skipIndex = output[0];
			}

		} else if (numberOfParties - i < r - j) {
			/* prune this branch */
			return;
		} else {
			// output[j] = Integer.toString(parties[i]).charAt(0);
			output[j] = Integer.toString(i).charAt(0);
			sum += parties[i][1];
			generateCombinations(i + 1, j + 1);
			 output[j] = 'A';
			sum -= parties[i][1];
			
			if(output[0] == skipIndex && output[1] =='A'){
				skip=false;
				skipIndex = 'X';
			}

			if (skip == false) {
				generateCombinations(i + 1, j);
			}

		}
	}

}
