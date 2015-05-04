
public class permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(P(3));

	}
	
	
	/* Number of ways to order n objects */
	 public static int P(int n) {
         if (n == 1)
                 return 1;
         else
                 return n * P(n - 1);
 }
}
