package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numberOfPaths {

	static int count;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(obj.readLine());
		while(T-->0) {
			int m=0,n=0;
			count = 0;
			{
				String input[] = obj.readLine().split(" ");
				m = Integer.parseInt(input[0]);
				n = Integer.parseInt(input[1]);				
			}
			findPaths(m,n);
			System.out.println(count);
		}
	}
	public static void findPaths(int m, int n) {
		if(m==1 && n==1) {
			count++;
			return;
		}
		if(m>1) {
			findPaths(m-1, n);
		} 
		if(n>1) {
			findPaths(m, n-1);
		} 
				
	}

}
