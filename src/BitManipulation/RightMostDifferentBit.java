package BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RightMostDifferentBit {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T , N , M;
		StringBuilder output = new StringBuilder();
		T = Integer.parseInt(obj.readLine());
		if(T<0 || T>100)System.exit(0);
		while(T>0) {
			{
				String input[] = obj.readLine().split(" ");
				N = Integer.parseInt(input[0]);
				M=Integer.parseInt(input[1]);			
			}
			if(N<0 || N>1000000 || M<0 || M>1000000) continue;
			if(M==N) {
				output.append("-1\n");
				continue;
			}
			int x = M ^ N; //XOR to find difference of bits		
			int count=0;
			while(x>0) {
				if(x%2==1) {
					count++;
					break;
				}
				count++;
				x=x/2;
			}
			output.append(count);
			output.append("\n");
			
//			int rightMostSetBit = (int) (Math.floor (Math.log(x) ) / Math.floor( Math.log(Math.E) )) +1;
//			//Formula log2(n & -n)+1 - > returns the position of the rightmost set bit....
//			output.append(rightMostSetBit);
//			output.append("\n");
			
			T--;
		}
		System.out.println(output);
	}

}
