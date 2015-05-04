import java.util.Scanner;

public class Jollo {


	public static void main(String[] args) {
		int[] princess = new int[3];
		int[] prince = new int[2];
		int[] allNums = new int[5];
		int result;
	
		int[] nextPrincess = new int[2];

		Scanner input = new Scanner(System.in);
		for (int i = 0; i < princess.length; i++) {
			princess[i] = input.nextInt();

		}
		for (int i = 0; i < prince.length; i++) {
			prince[i] = input.nextInt();

		}

		while (princess[0] != 0) {
			shellSort(prince);
			shellSort(princess);

			for (int l = 0; l < princess.length; l++) {
				allNums[l] = princess[l];
			}
			allNums[3] = prince[0];
			allNums[4] = prince[1];

			if (prince[1] > princess[2]) {
			
				//kasab awel marra
				if (prince[0] > princess[2]) {
					//kasab mareten
				
					result = 1;
					boolean found=true;
					while (result <= 52 && found==true) {
						found=false;
						for (int i = 0; i < allNums.length; i++) {
							if (allNums[i] == result) {
								result++;
								found=true;
							}
						}
					}
					
					if(result<53){
						System.out.println(result);
					}else{
						System.out.println("-1");
					}
				}else{
					//kasab mara we 5asar mara
					if (princess[0] > prince[0]) {
						nextPrincess[0] = princess[1];
						nextPrincess[1] = princess[2];
					} else if (princess[1] > prince[0]) {
						nextPrincess[0] = princess[0];
						nextPrincess[1] = princess[2];
					} else {
						nextPrincess[0] = princess[0];
						nextPrincess[1] = princess[1];
					}
					result = getMax(nextPrincess)+1;
					boolean found=true;
					while (result <= 52 && found==true) {
						found=false;
						for (int i = 0; i < allNums.length; i++) {
							if (allNums[i] == result) {
								result++;
								found=true;
							}
						}
					}
					
					if(result<53){
						System.out.println(result);
					}else{
						System.out.println("-1");
					}
				
				}

			} else {
//5asar awel mara
				if (princess[0] > prince[1]) {
					nextPrincess[0] = princess[1];
					nextPrincess[1] = princess[2];
				} else if (princess[1] > prince[1]) {
					nextPrincess[0] = princess[0];
					nextPrincess[1] = princess[2];
				} else {
					nextPrincess[0] = princess[0];
					nextPrincess[1] = princess[1];
				}

				
				if (prince[0] > nextPrincess[1]) {
					//5asar mara we kasab mara 
					
					result = getMax(nextPrincess)+1;
					boolean found=true;
					while (result <= 52 && found==true) {
						found=false;
						for (int i = 0; i < allNums.length; i++) {
							if (allNums[i] == result) {
								result++;
								found=true;
							}
						}
					}
					
					if(result<53){
						System.out.println(result);
					}else{
						System.out.println("-1");
					}
				}else{
					System.out.println("-1");
				}
					

				
			}

			
			

			princess[0] = input.nextInt();
			princess[1] = input.nextInt();
			princess[2] = input.nextInt();
			prince[0] = input.nextInt();
			prince[1] = input.nextInt();

		}
		input.close();

	}

	public static int getMax(int[] x) {
		int max = -2;
		for (int counter = 1; counter < x.length; counter++) {
			if (x[counter] > max) {
				max = x[counter];
			}
		}

		return max;

	}

	

	private static void insertionSort(int[] array, int h) {
		for (int p = h; p < array.length; p += h) {

			int tmp = array[p];
			int j;
			for (j = p; j >= h && tmp < array[j - h]; j -= h) {

				array[j] = array[j - h];

			}
			array[j] = tmp;

		}
	}

	public static void shellSort(int[] array) {

		int gap = 1;
		while (gap * 3 + 1 < array.length - 1) {
			gap = gap * 3 + 1;
		}

		while (gap > 0) {
			insertionSort(array, gap);

			gap = (gap - 1) / 3;
		}

	}

}
