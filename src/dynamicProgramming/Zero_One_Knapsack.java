package dynamicProgramming;

import java.util.*;
import java.io.*;

public class Zero_One_Knapsack {

	public static void main(String[] args) throws IOException {
		Scanner obj = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int T = obj.nextInt();
		while (T-- > 0) {
			// Code here. Append "\n" after every test case's output.
			int n = obj.nextInt();
			int w = obj.nextInt();
			int price[] = new int[n];
			int weights[] = new int[n];
			double priceByWeights[] = new double[n];
			for(int i=0;i<n;i++)
				price[i]=obj.nextInt();
			for(int i=0;i<n;i++) {
				weights[i]=obj.nextInt();
				priceByWeights[i]=((double)weights[i])/price[i];
			}
			
		}
		System.out.println(output);
	}
}
