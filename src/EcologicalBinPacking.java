import java.util.Scanner;

public class EcologicalBinPacking {

	public static void main(String[] args) {
		long min, temp;
		String result, order;

		long[] bottles = new long[9];
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			for (int i = 0; i < bottles.length; i++) {
				bottles[i] = input.nextInt();
			}

			order = "BGC";
			min = bottles[3] + bottles[6] + bottles[1] + bottles[7]
					+ bottles[2] + bottles[5];
			result = order;

			order = "BCG";
			temp = bottles[3] + bottles[6] + bottles[2] + bottles[8]
					+ bottles[1] + bottles[4];
			if (temp < min) {
				result = order;
				min = temp;
			} else if (temp == min) {
				if(order.compareTo(result)<0){
					result=order;
				}
			}
			
			order = "GBC";
			temp = bottles[4] + bottles[7] + bottles[0] + bottles[6]
					+ bottles[2] + bottles[5];
			if (temp < min) {
				result = order;
				min = temp;
			} else if (temp == min) {
				if(order.compareTo(result)<0){
					result=order;
				}
			}
			
			order = "GCB";
			temp = bottles[4] + bottles[7] + bottles[2] + bottles[8]
					+ bottles[0] + bottles[3];
			if (temp < min) {
				result = order;
				min = temp;
			} else if (temp == min) {
				if(order.compareTo(result)<0){
					result=order;
				}
			}
			
			order = "CBG";
			temp = bottles[5] + bottles[8] + bottles[0] + bottles[6]
					+ bottles[1] + bottles[4];
			if (temp < min) {
				result = order;
				min = temp;
			} else if (temp == min) {
				if(order.compareTo(result)<0){
					result=order;
				}
			}
			
			order = "CGB";
			temp = bottles[5] + bottles[8] + bottles[1] + bottles[7]
					+ bottles[0] + bottles[3];
			if (temp < min) {
				result = order;
				min = temp;
			} else if (temp == min) {
				if(order.compareTo(result)<0){
					result=order;
				}
			}
			
			
			System.out.println(result+" "+min);

		}
		input.close();
	}

}
