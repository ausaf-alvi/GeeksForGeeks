package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class RemoveRepeatedDigitsInGivenNumber {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder output = new StringBuilder();
		 int T = Integer.parseInt(obj.readLine()); //T is test cases
		 while(T-->0){
		 //Code here
		 //keep on appending solutions to output. 
		 //Also append "\n" after every test case's output.
			 String N = obj.readLine();
			 int len = N.length();
			 Stack<Character> st = new Stack<Character>();
			 for(int i=0  ;i<len ; i++) {
				 char c=N.charAt(i);
				 if(st.empty()) {
					st.push(c); 
				 } else {
					 if(c==st.peek()) {
						 //Do nothing
					 } else 
						 st.push(c);
				 }
			 }
			 StringBuilder o = new StringBuilder();
			 while(!st.empty()) {
				 o.append(st.pop());
			 }
			 o.reverse();
			 output.append(o).append("\n");
		 }
		 System.out.println(output);
	}

}
