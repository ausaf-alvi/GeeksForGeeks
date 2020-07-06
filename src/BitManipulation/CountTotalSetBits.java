package BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountTotalSetBits {
	public static void main(String args[])throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(obj.readLine());
		StringBuilder output = new StringBuilder();
		if(T<0 || T>100) System.exit(0);
		while(T>0) {
			int N = Integer.parseInt(obj.readLine());
			if(N<0 || N>1000) continue;
			int totalCount=0;
//			System.out.println("N="+Integer.toBinaryString(N));
			while( N > 0){
//				totalCount += countSetBits_BrianKerninghansAlgo(N);
//				Or
				totalCount += countSetBits_LookupTables(N);
				N--;
			}
			output.append(totalCount);
			output.append("\n");
			T--;
		}
		System.out.println(output);
	}
	
	public static int countSetBits_LookupTables(int n) {
//		table of 0 to 15 with their no of set bits :-
//		0000=0	|	0100=1	|	1000=1	|	1100=2
//		0001=1	|	0101=2	|	1001=2	|	1101=3
//		0010=1	|	0110=2	|	1010=2	|	1110=3
//		0011=2	|	0111=3	|	1011=3	|	1111=4
		
//		Since	indexes[] = { 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10, 11, 12, 13, 14, 15 } 
		int[] table=new int[]{0 , 1 , 1 , 2 , 1 , 2 , 2 , 3 , 1 , 2 , 2 , 3 , 2 , 3 , 3 , 4 };  
//		System.out.println("N in Binary = "+Integer.toBinaryString(n));
		int count = 0;
		while(n>0) {
//			System.out.println("N in Binary = "+Integer.toBinaryString(n));
			count = count + table[ n & 0xF ];		//count += count + table[ n & 1111 ];
//			System.out.println("Table Position="+ (n & 0xF)+"\t value in table = "+ table[ n & 0xF ]);
			n = n>>4;
		}
		return count;
	}
	
	public static int countSetBits_BrianKerninghansAlgo(int n) {
		int count = 0;
		while( n > 0 ) {
			n = n & ( n - 1 );
			count++;
		}
		return count;
	}
	
}
