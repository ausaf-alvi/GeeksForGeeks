package dynamicProgramming;
import java.util.*;

import java.io.*;

public class MaxSumIncreasingSubsequence {

		public static void main (String[] args)throws IOException
		 {
		 Scanner obj = new Scanner(System.in);
		 StringBuilder output = new StringBuilder();
		 int T = obj.nextInt();
		 while(T-->0){
		 //Code here. Append "\n" after every test case's output.
			 int n=obj.nextInt();
			 int a[]=new int[n];
			 for(int i=0;i<n;i++) {
				 a[i]=obj.nextInt();
//				 System.out.println("input="+a[i]);
			 }
//			 Arrays.stream(a).forEach(System.out::println);
			 int lis[]=new int[n];
			 Arrays.fill(a, 1);
//			 Arrays.stream(a).forEach(System.out::print);
//			 int i=1;
//			 int j=0;
			 for(int i=1;i<n;i++) {
				 for(int j=0;j<i;j++) {
					 if(a[i]>a[j]) {
						 lis[i]=lis[j]+1;
					 } else {
						 j++;
						 if(j==i)
							 i++;
					 }
				 }
			 }
			 int max=Arrays.stream(a).max().orElse(1);
			 output.append(max);
			 output.append("\n");
		 
		 }
		 System.out.println(output);
		 }
	}
