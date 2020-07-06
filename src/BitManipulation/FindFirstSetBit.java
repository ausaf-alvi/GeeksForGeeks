package BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindFirstSetBit {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T , N;
		StringBuilder output = new StringBuilder();
		T = Integer.parseInt(obj.readLine());
		if(T<0 || T>200)System.exit(0);
		while(T>0) {
			N = Integer.parseInt(obj.readLine());
			if(N<0 || N>1000000) continue;
			int count=0;
			while(N>0) {
				if(N%2==1) {
					count++;
					break;
				}
				count++;
				N=N/2;
			}
			output.append(count);
			output.append("\n");
//			--------------------
//			Correct Code: pos is position
//			int pos=(int)(Math.ceil(Math.log(N & -N))/Math.ceil(Math.log(Math.E)))+1;
//			System.out.println(pos);
//			Formula: log2(n & -n)+1 - > returns the position of the rightmost set bit...
//			--------------------
			T--;
			
		}
	}

}
