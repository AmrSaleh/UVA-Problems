public class NextCombination
{
        private static int index = 0;
        public static void main(String[] args)
        {
            int n = 5; // The size of the set
            int r = 2; // The size of the subsets (r!=0)
            /* combinations[i] is the index of the i-th element in the combination */
            int[] combinations = new int[16];
 
            /* Setup combinations[] for the initial combination (0-based)*/
            for (int i = 0; i < r; ++i) 
            	combinations[i] = i;
           
            /* Print the first combination */
            printCombination(combinations, r);
           
 
            /* Generate and print all the other combinations */
            while (nextCombination(combinations, r, n)){
            	printCombination(combinations, r);
            }
        }
 
        private static boolean nextCombination(int[] combinations, int r, int n)
        {
                int i = r-1;
                combinations[i]++;
                while (i>0 && combinations[i]>= n-r+1+i)
                {
                        i--;
                        combinations[i]++;
                }
               
                /* Combination (n-k, n-k+1, ..., n) reached */
                /* No more combinations can be generated */
                if(combinations[0]>n-r) return false;

                 /* Combination now looks like (..., x, n, n, n, ..., n). Turn it into (..., x, x + 1, x + 2, ...) */
                for (i=i+1; i < r  ; i++)       
                	combinations[i]=combinations[i-1]+1;
               
                return true;
        }
 
        private static void printCombination(int[] combinations, int r)
        {
                System.out.print(++index+" - ");
                for (int i = 0; i < r; i++)     
                	System.out.print(combinations[i]+1);
                System.out.println();
        }
 
}