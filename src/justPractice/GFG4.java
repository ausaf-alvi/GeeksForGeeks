package justPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GFG4 {
	public static void main(String[] args) throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(obj.readLine());
		StringBuilder output = new StringBuilder();
		if(T<0 || T>100) System.exit(0);
		for(int t=0 ; t<T ; t++) {
			int count=0;
			int numberOfOnes=0;
			Integer S = Integer.parseInt(obj.readLine());
			if(S<0 || S>10000) continue;
			String input = obj.readLine();
			int length = input.length();
			if(S!=length) continue;
			for(int i=0; i<length; i++) {
				if(input.charAt(i)=='1') {
					numberOfOnes++;
					count=count+(numberOfOnes-1);
				}
			}
			if(numberOfOnes==1)
				output.append("0");
			else
				output.append(count);
			output.append("\n");
			
		}
		System.out.print(output);
		}

}

