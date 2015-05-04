import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TourDeFrance11242 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int front, rear;
		String[] splittedLine = br.readLine().split(" ");

		front = Integer.parseInt(splittedLine[0]);

		int[] sprigotsFront;
		int[] sprigotsRear;
		double[] results;
		int n;
		String output;
		double ratio, temp;

		while (front != 0) {

			rear = Integer.parseInt(splittedLine[1]);

			sprigotsFront = new int[front];
			sprigotsRear = new int[rear];
			results = new double[front*rear];

			splittedLine = br.readLine().split(" ");
			for (int i = 0; i < splittedLine.length; i++) {
				sprigotsFront[i] = Integer.parseInt(splittedLine[i]);
			}

			splittedLine = br.readLine().split(" ");
			for (int i = 0; i < splittedLine.length; i++) {
				sprigotsRear[i] = Integer.parseInt(splittedLine[i]);
			}

			n = 0;
			for (int i = 0; i < sprigotsFront.length; i++) {
				
				for (int j = 0; j < sprigotsRear.length; j++) {
					results[n] =(double)sprigotsRear[j]/ (double)sprigotsFront[i] ;
					n++;
				}
			}

			
				Arrays.sort(results);
			
			

			ratio = -1.0;
			for (int i = 0; i < results.length-1; i++) {
				
				
					temp = (double) results[i+1] / (double) results[i];
					if (temp > ratio) {
						ratio = temp;
					}
				
				
			}

//			System.out.println(Arrays.toString(results));
//			System.out.printf("%.2f\n", ratio);
			
			ratio = Math.round(ratio * 100.0) / 100.0;
			output = ratio + "";
			if (output.length() - 1 - output.indexOf('.') == 1) {
				output += "0";
			}

			System.out.println(output);
			
//			System.out.println("---");

			splittedLine = br.readLine().split(" ");
			front = Integer.parseInt(splittedLine[0]);
		}
	}
}
