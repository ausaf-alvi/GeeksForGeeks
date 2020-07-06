package BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecToBinary {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T , N;
		StringBuilder output = new StringBuilder();
		T = Integer.parseInt(obj.readLine());
		if(T<0 || T>100)System.exit(0);
		while(T>0) {
			N = Integer.parseInt(obj.readLine());
			if(N<0 || N>5000) continue;
			
			StringBuilder bitRepresentation = new StringBuilder();
			for(int i=13 ; i>-1 ; i--) {
				bitRepresentation.append(((N>>i)&1));
			}
//			String bitRepresentation = Integer.toBinaryString(N);
//			int bitLength = bitRepresentation.length();
//			if(bitLength<14) {
//				int noOfZeroes = 14-bitLength;
//				while(noOfZeroes-->0) {
//					output.append("0");
//				}
//			}
			output.append(bitRepresentation);
			output.append("\n");
			T--;
		}
		System.out.println(output);
	}

}
