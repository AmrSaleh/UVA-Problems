//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class Question272 {

	public static void main(String[] args){
		String phrase = "";
	
		boolean type = true;

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc =new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			
			phrase = phrase +sc.nextLine()+"\n";

			

		}
		sc.close();
		String[] strArr=new String[phrase.length()];
		char[] charArr=phrase.toCharArray();
		
		for(int z=0;z<phrase.length();z++){
			strArr[z]=charArr[z]+"";
		}
		
		for(int x=0;x<phrase.length();x++){
			if(strArr[x].equals("\"")&&type){
				strArr[x]="``";
				type=false;
			}else if(strArr[x].equals("\"")&&!type){
				strArr[x]="''";
				type=true;
			}
		}
		
		for(int x=0;x<phrase.length()-1;x++){
			System.out.print(strArr[x]);
		}
		
//		while (phrase.contains("\"")) {
//
//			if (type) {
//				phrase=phrase.replaceFirst("\"", "``");
//				type = false;
//			} else {
//				phrase=phrase.replaceFirst("\"", "\'\'");
//				type = true;
//			}
//		}
//
//		System.out.print(phrase);
		
		
		
		
		
		
	}
}
