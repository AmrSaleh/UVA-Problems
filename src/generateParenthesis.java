
public class generateParenthesis {

	public static char[] output;
	public static int count=0;
	public static int i=0;
	
	
	public static void main(String[] args) {
		output=new char[4];
		printPermutations(i, count, 2);
		
	}
	
	public static void printPermutations(int i,int count,int n){
		int l=n*2;
		
		if(i==l && count==0){
			print(output);
		}
		else if(count<0||l-i+1<count){
			
			return;
		}
		else{
			output[i]='(';
			printPermutations(i+1, count+1,n);
			output[i]=')';
			printPermutations(i+1, count-1,n);
			
		}
	}
	
	public static void print(char[] resultArr){
		System.out.print("\"");
		for(int i=0;i<resultArr.length;i++){
			System.out.print(resultArr[i]);
		}
		System.out.print("\", ");
	}

}
