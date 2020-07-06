package BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestConsecutiveSetBits {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj  = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(obj.readLine());
		StringBuilder output = new StringBuilder();
		if(T<0 || T>100) System.exit(0);
		while( T > 0 ) {
			int N = Integer.parseInt(obj.readLine());
			int consecutiveSetBits = 0 ;
			while(N>0) {
				N =( N & (N<<1) );
				consecutiveSetBits++;
			}
//			-----------Naive Approach--------------
//			String binaryRepresentation = Integer.toBinaryString(N);
//			int count=0;
//			int checkPosition = binaryRepresentation.length() - 1;
//			while(checkPosition >= 0 ) {
//				if( binaryRepresentation.charAt(checkPosition) == '1' ) {
//					count++;
//				} else {
//					if( count > consecutiveSetBits ) {
//						consecutiveSetBits = count;
//					}
//					count=0;
//				}
//				checkPosition--;
//			}
//			if( count > consecutiveSetBits ) {
//				consecutiveSetBits = count;
//			}
//			-----------------------------------
			output.append(consecutiveSetBits);
			output.append("\n");
			T--;
		}
		System.out.println(output);
	}

}
