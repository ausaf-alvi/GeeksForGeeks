package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class printPattern {
//	static StringBuilder sb = new StringBuilder();;
	static int N=0;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(obj.readLine());
		while(T-->0) {
			N=Integer.parseInt(obj.readLine());
//			sb = new StringBuilder();
//			System.out.println();
			System.out.print(N);
			patternGenerator(N , true);
			
		}
	}
	public static void patternGenerator(int original , boolean haveNotRechedZeroOnce) {
		
		if(N>0 && haveNotRechedZeroOnce) {
			N=N-5;
			
		} else {
			haveNotRechedZeroOnce = false;
			N=N+5;
		}
		System.out.print(" "+N);
		if(original==N) 
			return;
		else 
			patternGenerator(original , haveNotRechedZeroOnce);
	}

}
