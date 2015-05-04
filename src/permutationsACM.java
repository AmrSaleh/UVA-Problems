
public class permutationsACM {

	  /* generating permutations and combinations code */
    public static char[] output;
    public static char[] str;
    public static boolean[] visited;
    public static int length;
   

    /* prints all permutations, i is the next place to fill in output */
    public static void permute(int i) {
            if (i == length) {
                    System.out.println(new String(output));
            } else {
                    int j;
                    for (j = 0; j < length; j++)
                            if (!visited[j]) {
                                    visited[j] = true;// mark j as visited(remove it from the
                                                                            // set)
                                    output[i] = str[j];// add it to the output
                                    permute(i + 1);// recurse on the left set
                                    output[i] = 0;// not needed
                                    visited[j] = false;// umark j(backtrack)
                            }
            }
    }
    
    
    public static void main(String[] args) {
        /* test permutations */
        str = "ABCD".toCharArray();
        output = new char[str.length];
        visited = new boolean[str.length];
        length = 4;
        permute(0);
        System.out.println();
    
       
      
}

}
