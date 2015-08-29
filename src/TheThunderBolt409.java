import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class TheThunderBolt409 {

	// global array just to keep track of it in this example,
	// but you can easily do this within another function.

	// will contain true or false values for the first 10,000 integers
	static boolean[] primes = new boolean[10001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		fillSieve();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases;
		cases = Integer.parseInt(br.readLine());
		int[] numbers=new int[2];
		String[] line=new String[2];
		int count;
		int temp, sum;
		for (int i = 0; i < cases; i++) {
			count=0;
			line[0] = br.readLine();
			line = line[0].split("\\s+");
			numbers[0]=Integer.parseInt(line[0]);
			numbers[1]=Integer.parseInt(line[1]);
			
			for(int j=numbers[0];j<=numbers[1];j++){
				if(isPrime(j)){
					sum =0;
					temp = j;
					while(temp >0){
						sum = sum + temp %10;
						temp = temp/10;
					}
					
					if(isPrime(sum))
					count++;
				}
				
			}
			
			
			
			//print count
			System.out.println(count);
		}
	}

	// set up the primesieve
	public static void fillSieve() {
		Arrays.fill(primes, true); // assume all integers are prime.
		primes[0] = primes[1] = false; // we know 0 and 1 are not prime.
		for (int i = 2; i < primes.length; i++) {
			// if the number is prime,
			// then go through all its multiples and make their values false.
			if (primes[i]) {
				for (int j = 2; i * j < primes.length; j++) {
					primes[i * j] = false;
				}
			}
		}
	}

	public static boolean isPrime(int n) {
		return primes[n]; // simple, huh?
	}
}
