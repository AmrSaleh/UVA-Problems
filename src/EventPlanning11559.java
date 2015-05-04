import java.util.Scanner;

public class EventPlanning11559 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number, budget, hotels, week;
		int hotelPrice, beds;
		boolean stayHome;
		int minimumPrice;

		while (input.hasNext()) {
			minimumPrice = Integer.MAX_VALUE;
			stayHome = true;
			number = input.nextInt();
			budget = input.nextInt();
			hotels = input.nextInt();
			week = input.nextInt();

			for (int i = 0; i < hotels; i++) {
				stayHome = true;
				hotelPrice = input.nextInt();
				for (int j = 0; j < week; j++) {
					beds = input.nextInt();
					if (beds >= number) {
						stayHome = false;
						
					}
				}

				if (stayHome)
					continue;

				if ((hotelPrice * number) < minimumPrice) {
					minimumPrice = hotelPrice * number;
				}
			}

			if(number ==0 || hotels==0 || week==0) stayHome = true ;
			if (stayHome) {
				System.out.println("stay home");
			} else {
				// print minimum price
				if (minimumPrice <= budget) {
					System.out.println(minimumPrice);
				} else {
					System.out.println("stay home");
				}
			}
		}

		input.close();
	}
}
