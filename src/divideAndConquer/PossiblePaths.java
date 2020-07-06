package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PossiblePaths {

	static int n;
	static int[][] graph;
	public static void main(String[] args) throws IOException{
	 //code
	 BufferedReader
	 obj = new BufferedReader(new InputStreamReader(System.in));
	 StringBuilder output = new StringBuilder();
	 int t = Integer.parseInt(obj.readLine()); //T is test cases
	 while(t-->0){
	 //Code here
	 n = Integer.parseInt(obj.readLine());
	 int u=0,v=0,k=0;
	 graph = new int[n][n];
	 {
		 String input[] = obj.readLine().trim().split(" ");
		 for(int i=0 ; i<n ; i++) {
			 for(int j=0 ; j<n ; j++) {
				 graph[j][i] = Integer.parseInt(input[(j*n)+i]);
			 }
		 }
//		 obj.readLine();
		 input = obj.readLine().trim().split(" ");
		 u = Integer.parseInt(input[0]);
		 v = Integer.parseInt(input[1]);
		 k = Integer.parseInt(input[2]);
	 }
//	 System.out.print(String.format("\nu=%d\tv=%d\tk=%d\t\ngraph:-\n",u,v,k));
//	 for(int i=0 ; i<n ; i++){
//		 System.out.print("\n[");
//		 for(int j=0 ; j<n ; j++) {
//			 System.out.print(" "+graph[i][j]+" ");
//		 }
//		 System.out.print("]");
//	 }
//	 System.out.println("\n");
	 int answer = 0;
	 if(k==0 && u==v)
		 answer = 1;
	 else if(k==0)
		 answer = 0;
	 else
		 {
//		 int totalPaths = countNumberOfPaths(u , v , k);
//		 int incompletePaths = totalPaths/k;
//		 int completePaths = totalPaths - incompletePaths;
//		 answer = completePaths;
		 answer = countNumberOfPaths(u, v, k);
//		 double j = (double)countNumberOfPaths(u, v, k)/2;
//		 double k2 = (double)k;
//		 answer = (int)Math.ceil(j/k2);
//		 answer = countNumberOfPaths(u, v, k);
		 }
	 output.append(answer).append("\n");
	 //keep on appending solutions to output. 
	 //Also append "\n" after every test case's output.
	 }
	 System.out.println(output);
	 }

	static int countNumberOfPaths(int u , int v , int k) {
		if (k == 0 && u == v)      
			return 1;
		if(k==1 && graph[u][v]==0)
			return 0;
		if(k==1 && graph[u][v]==1) 
			return 1;
		if(k<=0)
			return 1;
		int total=0;
		int v2=Integer.MIN_VALUE;
		for(int i=0 ; i<n ; i++) {
			if(graph[i][v]==1) {
				v2 = i;
				int paths = countNumberOfPaths(u, v2, k-1);
				total = total + paths;
			}
		}
		return total;
	}
}
