package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThePainterPartitionProblem_Solution2 {

	static int blocks[];
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(obj.readLine());
		StringBuffer output = new StringBuffer();
		while(t-->0) {
			int k=0 , n=0;
			{
				String input[] = obj.readLine().split(" ");
				k = Integer.parseInt(input[0]);
				n = Integer.parseInt(input[1]);
			}
			blocks = new int[n];
			{
				String input[] = obj.readLine().split(" ");
				for(int i=0 ; i<n ; i++) {
					blocks[i] = Integer.parseInt(input[i]);
				}
			}
//			blocks=new int[]{ 274 , 465 , 130 , 135 , 254 , 45 , 70 , 122 , 149 , 95 , 453 , 65 , 392 , 331 , 316 , 484 , 372 , 339 , 45 , 46 , 31 , 167 , 351 , 415 , 387 , 275 , 355 , 440 , 290 , 462 , 436 , 416 , 279 , 66 , 403 , 33 , 464 , 473 , 8 , 113 , 420 , 461 , 30 , 312 };
//			System.out.println();
//			for(int a:blocks)System.out.print(a+" ");
//			System.out.println();
//			see geeksforgeeks code: https://ide.geeksforgeeks.org/8trrjnpdwe
			
//			Arrays.parallelSort(blocks);
//			System.out.println();
//			for(int a:blocks)System.out.print(a+" ");
//			System.out.println();
			
			int blockSum = 0;
			int max=-1;
			for(int a: blocks) {
				blockSum+=a;
				if(a>max) max=a;
			}
			int noOfPaintersWeHave = k;
			int lowestPossibleTime = max;
			int highestPossibleTime = blockSum;
			int j =lowestPossibleTime + (highestPossibleTime-lowestPossibleTime)/2;
//			System.out.println("High:"+highestPossibleTime+"\tLow:"+lowestPossibleTime+"\tmid="+j);
// 			int answer = -1;
			while(lowestPossibleTime<highestPossibleTime) {
				int mid = lowestPossibleTime + (highestPossibleTime-lowestPossibleTime)/2;
//				System.out.println("High:"+highestPossibleTime+"\tLow:"+lowestPossibleTime+"\tmid="+mid);
				if(numberOfPaintersRequiredForGivenTime(mid)<=noOfPaintersWeHave) {
				// 	answer = mid;
					highestPossibleTime = mid;
//					System.out.println("\nSolution:"+mid+"\tnew lowest:"+lowestPossibleTime+"\tnew highest:"+highestPossibleTime);
				} else {
					lowestPossibleTime = mid+1;
				}
			}
//			System.out.println("High:"+highestPossibleTime+"\tLow:"+lowestPossibleTime);
			output.append(lowestPossibleTime).append("\n");
		}
		System.out.println(output);
	}
	
	static int numberOfPaintersRequiredForGivenTime(int givenTimeUnits) {
		int requiredPainters = 1;//For starting we will require 1 painter.....well keep on increasing it as per needs
		//time to paint 1 block = 1 unit
		//therefore, max blocks a painter can paint = givenTimeUnits
		int currentPaintersBlockQuota = 0;
		for(int i=0 ; i<blocks.length ; i++) {
			currentPaintersBlockQuota += blocks[i];
			if(currentPaintersBlockQuota>givenTimeUnits){
			    requiredPainters++;
			    currentPaintersBlockQuota = blocks[i];
			}
		}
		return requiredPainters;
	}
}
