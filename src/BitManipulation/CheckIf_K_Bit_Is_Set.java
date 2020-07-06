package BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckIf_K_Bit_Is_Set {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T , N , K;
		StringBuilder output = new StringBuilder();
		T = Integer.parseInt(obj.readLine());
//		System.out.println("T="+T);
		if(T<0 || T>200)System.exit(0);
		while(T>0) {
			
				N = Integer.parseInt(obj.readLine());
//				System.out.println("N="+N);
				K=Integer.parseInt(obj.readLine());	
//				System.out.println("K="+K);
			String binaryRepresentation = Integer.toBinaryString(N);
//			System.out.println("bin rep="+binaryRepresentation);
//			int floor =(int) ( ( Math.log(N) / Math.log(Math.E) ) + 1 );
			if(N<0 || N>1000000000 || K<0 || K>binaryRepresentation.length()) {
				T--;
//				System.out.println("continue");
				continue;
			}
			K = binaryRepresentation.length() - K - 1;
			if(binaryRepresentation.charAt(K)=='1') {
				output.append("Yes\n");
			} else {
				output.append("No\n");
			}
			T--;
		}
		System.out.println(output);
	}

}
