import java.util.ArrayList;
import java.util.Scanner;

public class WhatistheCard10646 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;
		String card;
		ArrayList<String> pile = new ArrayList<String>();
		int position, topValue;
		int y;
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			pile.clear();
			for (int j = 0; j < 52; j++) {
				card = sc.next();
				pile.add(card);
			}

			position = 26;
			y = 0;
			for (int j = 0; j < 3; j++) {
				// topValue=pile[position];
				topValue = getValue(pile.get(position));
				y = y + topValue;
				// pile[position]=-1;
				pile.remove(position);
				position--;
				for (int j2 = 0; j2 < (10 - topValue); j2++) {
					// pile[j2]=-1;
					pile.remove(j2);
					position--;
				}

			}

			System.out.println("Case "+(i+1)+": "+pile.get(y - 1));
		}
		sc.close();

	}

	private static int getValue(String card) {
		if (card.charAt(0) == 'T' || card.charAt(0) == 'J' || card.charAt(0) == 'Q' || card.charAt(0) == 'K' || card.charAt(0) == 'A') {
			// pile[j]=10;
			return 10;
		} else {
			// pile[j]=card.charAt(0)-48;
			return (card.charAt(0) - 48);
		}
	}
}
