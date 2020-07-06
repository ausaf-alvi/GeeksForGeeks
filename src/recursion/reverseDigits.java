package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reverseDigits {
	static int reverse = 0;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(obj.readLine());
		while(T-->0) {
			reverse = 0;
			int N = Integer.parseInt(obj.readLine().trim());	
			System.out.println(reverseFunction(N));
			
		}
	}
	public static int reverseFunction(int n) {
		if(n>0) {
			int remainingNumber = n/10;
			int digit = n%10;
			reverse = (reverse*10) + (digit);
			reverseFunction(remainingNumber);
		}
		else {
			return 0;
		}
		return reverse;
	}

}
