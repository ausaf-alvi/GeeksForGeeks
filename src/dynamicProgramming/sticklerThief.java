package dynamicProgramming;

import java.util.*;
import java.io.*;

public class sticklerThief {

	// { Driver Code Starts


		public static void main (String[] args)
		 {
		   
		  Scanner sc = new Scanner(System.in);
		  int t = sc.nextInt();
		  while(t-- > 0){
		      int n = sc.nextInt();
		      int arr[] = new int[n];
		      
		      for(int i = 0; i<n; ++i)
		           arr[i] = sc.nextInt();
	  	      
	  	      System.out.println(new solve().FindMaxSum(arr, n));
		 }
	   }
	}// } Driver Code Ends


	class solve{
	    // Function to return maximum of sum without adjacent elements
		static int profits[] = new int[10000];
	    public int FindMaxSum(int arr[], int n){
	        // Your code here
	    	Arrays.fill(profits, -1);
	    	if(n==1)
	    	    return arr[0];
	    	if(n==2) {
	    		if(arr[0]>arr[1])
	    			return arr[0];
	    		else 
	    			return arr[1];
	    	}
	    	profits[0] = arr[0];
	    	profits[1] = arr[0]>=arr[1] ? arr[0] : arr[1];
	    	for(int p=2; p<n; p++) {
	    		profits[p] = Math.max(arr[p]+profits[p-2], profits[p-1]);
	    	}
	    	return profits[n-1];
	    }

	}

	
	/*
	Stickler Thief 
	Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and follows a certain rule when looting the houses. According to the rule, he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy. He asks for your help to find the maximum money he can get if he strictly follows the rule. Each house has a[i] amount of money present in it.

	Input:
	The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each test case contains an integer n which denotes the number of houses. Next line contains space separated numbers denoting the amount of money in each house.

	Output:
	For each testcase, in a newline, print an integer which denotes the maximum amount he can take home.

	Expected Time Complexity: O(N).
	Expected Space Complexity: O(N).

	Constraints:
	1 <= T <= 200
	1 <= n <= 104
	1 <= a[i] <= 104

	Example:
	Input:
	2
	6
	5 5 10 100 10 5
	3
	1 2 3
	Output:
	110
	4

	Explanation:
	Testcase1:
	5+100+5=110
	Testcase2:
	1+3=4
	
	*/