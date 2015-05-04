
public class combinationsACM {

	   public static char[] output;
       public static char[] str;
       public static boolean[] visited;
       public static int length;
       public static int r;
	/*
     * i is the first element which we didnt make decision for,j is the next
     * place to fill in output
     */
    public static void generateCombinations(int i, int j) {
            if (j == r) {
                    System.out.println(new String(output));
            } else if (length - i < r - j) {
                    /* prune this branch */
                    return;
            } else {
                    output[j] = str[i];
                    generateCombinations(i + 1, j + 1);
//                    output[j] = 0;
                    generateCombinations(i + 1, j);
            }
    }

    /* prints all combinations of size r */
    public static void main(String[] args) {
    	 str = "ABCD".toCharArray();
         output = new char[str.length];
         visited = new boolean[str.length];
         length = 4;
            /* test combinations */
            r = 2;
            generateCombinations(0, 0);

    }

}
