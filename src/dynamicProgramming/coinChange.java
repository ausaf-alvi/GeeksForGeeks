/**
 * 

Given a value N, find the number of ways to make change for N cents, 
if we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins. 
The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3}, 
there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. 
For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, 
{2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

Input:
The first line contains an integer 'T' denoting the total number of test cases. 
In each test cases, the first line contains an integer 'M' denoting the size of array. 
The second line contains M space-separated integers A1, A2, ..., AN denoting the elements of the array. 
The third line contains an integer 'N' denoting the cents.

Output:
Print number of possible ways to make change for N cents.

Constraints:
1 ≤ T ≤ 50
1 ≤ N ≤ 300
1 ≤ A[i] ≤ 300

Example:
Input:
2
3
1 2 3
4
4
2 5 3 6
10

Output:
4
5

Explanation:
Testcase 1: The possiblities are as such: {1, 1, 1, 1}, {1, 1, 2}, {1, 3}, {2, 2}.
** For More Input/Output Examples Use 'Expected Output' option **

 */

package dynamicProgramming;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class coinChange {
	static int arr[];
	static int visited[][];
	static int dp[][];
	static long ways;
	public static void main(String[] args) throws IOException {
		coinChange cc = new coinChange();
		Scanner obj = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int T = obj.nextInt();
		while (T-- > 0) {
			// Code here. Append "\n" after every test case's output.
			ways = 0;
			int m = obj.nextInt();
			arr=new int[m];
			visited=new int[1000][1000];
			dp=new int[1000][1000];
			for(int i=0 ; i<m ; i++) {
				arr[i]=obj.nextInt();
			}
			int n = obj.nextInt();
			Arrays.parallelSort(arr);
			ways=cc.noOfWays(0,(long)n);
			if(ways!=0) {
				output.append(ways);
			} else {
				output.append("-1");
			}
			output.append("\n");
		}
		System.out.println(output);
	}
	
	private static int noOfWays(int remainingAmount) {
		if(remainingAmount == 0) {
			return 0;
		}
		int ans = 0;
		for(int i=arr.length-1 ; i>=0 ; i--) {
			int temp = 0;
			if(arr[i]<=remainingAmount) {
				temp = 1+noOfWays(remainingAmount-arr[i]);
			}
			if(temp>ans) {
				ans = temp;
			}
		}
		return ans;
	}
	private long noOfWays(int pos , long remainingAmount) {
		if(pos == arr.length) {
			if(remainingAmount==0)
				return 1;
			else 
				return 0;
			}
		long ans = (long)dp[pos][(int) remainingAmount];
		if(visited[pos][(int)remainingAmount]==1)
			return ans;
		visited[pos][(int)remainingAmount]=1;
		ans = 0;
		long times = 0l;
		while(times*arr[pos] <= remainingAmount) {
			ans = ans+(long)noOfWays(pos+1 , remainingAmount-times*arr[pos]);
			times++;
		}
		dp[pos][(int)remainingAmount] = (int)ans;
		return ans;
	}
}
