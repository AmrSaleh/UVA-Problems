import java.util.Scanner;

public class sg {

	public static void orderTimes(){
		boolean swapFlag = false;
		int loopNo = 0;
		do {
			swapFlag = false; // this variable keeps track of whether to
								// continue sorting or exit
			for (int i = 0; i < times.length - 1 - loopNo; i++) {
			
				if (times[i] > times[i + 1]) // if current element is greater than the next
				{
					
					swap( i, i + 1); // swap the two elements
					swapFlag = true; // don't end the loop yet, we're not done
					
				}
			}
			loopNo++;
			
			
		} while (swapFlag);
	}
	
	public static void orderLangs(){
		boolean swapFlag = false;
		int loopNo = 0;
		do {
			swapFlag = false; // this variable keeps track of whether to
								// continue sorting or exit
			for (int i = 0; i < langs.length - 1 - loopNo; i++) {
			
				if (langs[i] > langs[i + 1] && times[i]==times[i+1]) // if current element is greater than the next
				{
					
					swap( i, i + 1); // swap the two elements
					swapFlag = true; // don't end the loop yet, we're not done
					
				}
			}
			loopNo++;
			
			
		} while (swapFlag);
	}
	
	public static void swap( int a, int b) {
		int temp = times[a];	
		char temp2 = langs[a];
		times[a] = times[b];
		langs[a] = langs[b];
		times[b] = temp;
		langs[b] = temp2;
		
		
	}
	public static void main(String[] args) {
		orderTimes();
		orderLangs();
	}

}
