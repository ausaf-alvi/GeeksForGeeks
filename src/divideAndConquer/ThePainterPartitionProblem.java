package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThePainterPartitionProblem {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(obj.readLine());
		StringBuilder output = new StringBuilder();
		while(t-->0) {
			int k=0 , n=0;
			{
				String input[] = obj.readLine().split(" ");
				k = Integer.parseInt(input[0]);
				n = Integer.parseInt(input[1]);
			}
			int blocks[] = new int[n];
			{
				String input[] = obj.readLine().split(" ");
				for(int i=0 ; i<n ; i++) {
					blocks[i] = Integer.parseInt(input[i]);
				}
			}
			Arrays.parallelSort(blocks);
			int blockSum[] = new int[n];
			for(int i=0 , sum=0 ; i<n ; i++) {
				sum = sum + blocks[i];
				blockSum[i] = sum;
			}
			int result = binarySearch_BlocksPerPainter(blockSum, 0, n, blocks, k);
			if(result!=-1)
				output.append(blockSum[result]).append("\n");
		}
		System.out.println(output);
	}
	
	static int binarySearch_BlocksPerPainter(int sumOfBlocks[], int low, int high, int blockSizes[], int noOfPainters) {
		int mid=1;
		int answer2=0;
		if(low<high) {
			if(high!=1) mid = (low+high-1)/2;
			if(isPaintingPossible(sumOfBlocks[mid], blockSizes, noOfPainters)) {
				answer2 = binarySearch_BlocksPerPainter(sumOfBlocks, low, mid-1, blockSizes, noOfPainters);
			} else {
				return binarySearch_BlocksPerPainter(sumOfBlocks, mid, high, blockSizes, noOfPainters);
			}
		} else return 0;
		return Math.min(mid, answer2);
	}
	
//	static boolean isPaintingPossible(int possibleBlocksPerPainter, int blockSizes[], int noOfPainters) {
//		boolean possibility = false;
//		int blocksPerPainter[] = new int[noOfPainters];
//		for(int  i=0 , j=0 ; i<noOfPainters ; i++) {
//			while(j<blockSizes.length) {
//				if(blocksPerPainter[i]<possibleBlocksPerPainter) {
//					blocksPerPainter[i] = blocksPerPainter[i] + blockSizes[j++];
//				} else {
//					if(blocksPerPainter[i]>0)
//						blocksPerPainter[i] = blocksPerPainter[i] - blockSizes[j];
//					break;
//				}
//			}
//		}
//		return possibility;
//	}
	static boolean isPaintingPossible(int possibleBlocksPerPainter, int blockSizes[], int noOfPainters) {
		int noOfBlocks = blockSizes.length;
		boolean possibility = false;
		int minimumPaintersRequired = 0;
		int currentPaintersQuota = 0;
		int carryOver = 0;
		
		while(noOfBlocks>0) {
			currentPaintersQuota += carryOver;
			if(blockSizes[noOfBlocks-1]>=possibleBlocksPerPainter) {
				currentPaintersQuota += possibleBlocksPerPainter;
				blockSizes[noOfBlocks-1] -= possibleBlocksPerPainter;
			} else {
				currentPaintersQuota += blockSizes[noOfBlocks-1];
				blockSizes[noOfBlocks-1] = 0;
			}
			if(currentPaintersQuota>=minimumPaintersRequired) {
				carryOver = currentPaintersQuota - possibleBlocksPerPainter;
				minimumPaintersRequired++;
				currentPaintersQuota = 0;
			}
			if(blockSizes[noOfBlocks-1]==0) {
				noOfBlocks--;
			}
		}
		
		if(minimumPaintersRequired<=noOfPainters)
			possibility = true;
		else
			possibility = false;
		
		return possibility;
	}

}
