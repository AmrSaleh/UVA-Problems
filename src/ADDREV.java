import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


 public class ADDREV {

	public static void main(String[] args) throws IOException {
		int n=0, x=0, y=0,result=0;
		String temp="",num="";
		 StringTokenizer stok;
		 String value="";
		//Scanner input = new Scanner(System.in);
	
		        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		       value = bufferedReader.readLine();
		       
		        stok = new StringTokenizer(value);
	            while (stok.hasMoreTokens())
	            {
	                n = Integer.parseInt(stok.nextToken());
	               
	            }
		//n = input.nextInt();
		for (int i = 1; i <= n; i++) {

			value=bufferedReader.readLine();
			stok = new StringTokenizer(value);
            while (stok.hasMoreTokens())
            {
                x = Integer.parseInt(stok.nextToken());
                y= Integer.parseInt(stok.nextToken());
               
            }
			
			num=Integer.toString(x);
			for(int j=num.length()-1;j>=0;j--){
				temp=temp+num.charAt(j);
			}
			x=Integer.parseInt(temp);
			temp="";
			
			num=Integer.toString(y);
			for(int j=num.length()-1;j>=0;j--){
				temp=temp+num.charAt(j);
			}
			y=Integer.parseInt(temp);
			temp="";
			
			result=x+y;
			num=Integer.toString(result);
			for(int j=num.length()-1;j>=0;j--){
				temp=temp+num.charAt(j);
			}
			result=Integer.parseInt(temp);
			temp="";
			
			System.out.println(result);

		}
		//input.close();

	}

}
