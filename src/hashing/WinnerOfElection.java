package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class WinnerOfElection {
	public static void main(String args[])throws IOException{
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(obj.readLine());
		HashMap<String, Integer> votingData = new HashMap<String, Integer>();
		int N;
		StringBuilder output = new StringBuilder();
		while(T-->0) {
			N=Integer.parseInt(obj.readLine());
			String votes[] = obj.readLine().split(" ");
			for(String candidate: votes) {
				if(votingData.containsKey(candidate)) {
					votingData.put(candidate, (votingData.get(candidate)+1));
				} else {
					votingData.put(candidate, 1);
				}
//				int firstVote=votingData.putIfAbsent(candidate, 1);
//				if(firstVote!=1) {
//					votingData.put(candidate, (votingData.get(candidate)+1));
//				}
			}
//			IntStream voteCollection = votingData
//					.values()
//					.stream()
//					.mapToInt( i -> i.intValue());
//			int abc[] = voteCollection.toArray();
//			for(int a: abc) {
//				System.out.print(a+" ");
//			}
//			Arrays.parallelSort(abc);
//			
			int max = -1;
			int maxForLexicographicallySmaller = -1;
			String winnerCandidate = null;
			String winnerLexicographical = null;
			String[] candidateSet;
			{
				Set<String> vSet=votingData.keySet();
				int size = vSet.size();
				int i=0;
				candidateSet = new String[size];
				for(String c:vSet) {
					candidateSet[i++] = c;
				}
				
			}
			if(candidateSet.length>=1) {
				winnerCandidate = candidateSet[0];
				max = votingData.get(candidateSet[0]);
				winnerLexicographical = winnerCandidate;
				maxForLexicographicallySmaller = max;
			}
			for(int i=1; i<candidateSet.length ; i++) {
				String currentCandidate = candidateSet[i];
				int currentVotes = votingData.get(currentCandidate);
				if(currentVotes>max) {
					winnerLexicographical = winnerCandidate;
					maxForLexicographicallySmaller = max;
					winnerCandidate = currentCandidate;
					max = currentVotes;
				}
				if(currentVotes==maxForLexicographicallySmaller && currentCandidate.compareTo(winnerLexicographical)<0) {
					winnerLexicographical = currentCandidate;
					maxForLexicographicallySmaller = currentVotes;
				}
//				if(max==maxForLexicographicallySmaller && winnerCandidate.compareTo(winnerLexicographical)<0) {
//					winnerLexicographical = currentCandidate;
//					maxForLexicographicallySmaller = currentVotes;
//				}
			}
			if(maxForLexicographicallySmaller==max) {
				output.append(winnerLexicographical).append(" ").append(maxForLexicographicallySmaller).append("\n");
			} else {
				output.append(winnerCandidate).append(" ").append(max).append("\n");
			}
			votingData.clear();
		}
		System.out.println(output);
	}
}
