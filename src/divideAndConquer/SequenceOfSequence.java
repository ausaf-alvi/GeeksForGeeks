package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;

public class SequenceOfSequence {

//	static ArrayList<int[]> listOfArrays = new ArrayList<int[]>();
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(obj.readLine());
		StringBuffer output = new StringBuffer();
		if(T<0 || T>100)	System.exit(0);
		while(T-->0) {
			int m=0;
			int n=0;
			{
				String input[] = obj.readLine().split(" ");
				m = Integer.parseInt(input[0]);
				n = Integer.parseInt(input[1]);
			}
			if(m<1 || n<1 || m>100 || n>100)	continue;	
//			int sequence[][] = sequenceGenerator(m, n);
			int x = sequenceGenerator(m, n);
			output.append(x).append("\n");
		}
		System.out.println(output);
	}
	public static int sequenceGenerator(int m , int n) {
		/* i corresponds to various values of m. j corresponds to various values of m*/
		if(m<n) {
			return 0;
		} 
		if(n==0) {
			return 1;
		}
		return sequenceGenerator(m/2, n-1)+sequenceGenerator(m-1, n);
	}

}
