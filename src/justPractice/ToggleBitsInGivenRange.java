package justPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToggleBitsInGivenRange {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(obj.readLine());
		StringBuilder output = new StringBuilder();
		if(T<0 || T>100) System.exit(0);
		while(T>0) {
			int N=0, L=0, R=0;
			{
				String input[] = obj.readLine().split(" ");
				N = Integer.parseInt(input[0]);
				L = Integer.parseInt(input[1]);
				R = Integer.parseInt(input[2]);
			}
			if(N<0 || N>1000 || L<0 || L>R || R>Integer.toBinaryString(N).length())	continue;
			int xorOperand = 1;
			for(int i=0 ; i<R-L ; i++) {
				int k = 0x1;;
				xorOperand = k | (xorOperand<<1);
//				System.out.println("\nAfter Loop: "+i+"\tXOR Operand= "+Integer.toBinaryString(xorOperand));
			}
			xorOperand = xorOperand<<(L-1);
//			System.out.println("\nXOR Operand= "+Integer.toBinaryString(xorOperand));
			int result = N ^ xorOperand;
			output.append(result);
			output.append("\n");
			T--;
		}
		System.out.println(output);
	}

}
