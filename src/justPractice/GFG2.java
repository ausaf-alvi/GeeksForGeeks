package justPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GFG2 {
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(obj.readLine());
		StringBuilder output = new StringBuilder();
		if(T<0 || T>100) System.exit(0);
		for(int t=0 ; t<T ; t++) {
			count=0;
			Integer S = Integer.parseInt(obj.readLine());
			String input = obj.readLine();
			startAndEndWithOne(input);
			output.append(count);
			output.append("\n");
			
		}
		System.out.print(output);
		}
	 public static void startAndEndWithOne(String st) {
		 if(st.isBlank()) return;
		 int firstOne = st.indexOf('1');
		 if(firstOne==-1)return;
		 int lastOne = st.lastIndexOf('1');
		 String subSt;
		 if(firstOne!=lastOne)
			 subSt = st.substring(firstOne+1, lastOne);
		 else
			 {count++;return;}
		 System.out.println(subSt);
		 if(subSt.indexOf('1')!=-1) {
			 count = count+2;
			 startAndEndWithOne(st.substring(firstOne+1 , lastOne));
		 } else {
			 count++;
		 }	 
	 }
}
