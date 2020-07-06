package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModularExponentiationForLargeNumbers {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		StringBuilder output = new StringBuilder();
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(obj.readLine());
		while(t-->0) {
			long a=0;
			long b=0;
			long c=0;
			{
				String input[] = obj.readLine().split(" ");
				a = Long.parseLong(input[0]);
				b = Long.parseLong(input[1]);
				c = Long.parseLong(input[2]);
			}
			long answer = calculateModularExponentiation(a, b, c);
			output.append(answer).append("\n");
		}
		System.out.println(output);
	}
	public static long calculateModularExponentiation(long a , long b , long c) {
		/*This Method calculates pow(A, B) % C */
		if(c==1) return 0l;
		if(b==0) return 1l;
		if(b==1) return (long)(a);
		return ( ( a*calculateModularExponentiation(a, b-1, c) ) % c );
	}

}
