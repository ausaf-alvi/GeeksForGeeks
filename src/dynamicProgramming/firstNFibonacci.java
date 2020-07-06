package dynamicProgramming;
import java.io.*;
import java.util.*;
import java.util.Arrays;
public class firstNFibonacci {
	// { Driver Code Starts
	//Initial Template for Java


	/*package whatever //do not write package name here */


		public static void main (String[] args) {
			Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();
			
			while(t-->0)
			{
			    int n=sc.nextInt();
			    long[] res = printFibb(n);
			    for (int i = 0; i < res.length; i++)
			        System.out.print (res[i]+" ");
			    System.out.println();
			}
		}
		

	 // } Driver Code Ends


	//User function Template for Java
	static long[] fn = new long[85];
	
	
	public static long[] printFibb(int n) 
	{
		Arrays.fill(fn, -1);
		fn[0]=0;
		fn[1]=1;
		fn[2]=1;
		if(n>3)
			fibHelper(n);
		return Arrays.copyOfRange(fn, 1, n);
	    //Your code here
	    
	}
	public static long fibHelper(int n) {
		if(fn[n]==-1) {
			fn[n] = fibHelper(n-1) + fibHelper(n-2);
		}
		return fn[n];
	}
	// { Driver Code Starts.

	}  // } Driver Code Ends

