package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class WinnerOfAnElection {
	public static void main(String args[])throws IOException{
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(obj.readLine());
		HashMap<String, Integer> votingData = new HashMap();
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
			}
			int max = -1;
			int maxForLexicographicallySmaller=-1;
			String winner="";
			Set<String> candidates = votingData.keySet();
			String lexicographicallySmaller=candidates.toArray()[0].toString();
			boolean firstTest = true;
//			System.out.println(lexicographicallySmaller);
			for(String candidate: candidates) {
				if(votingData.get(candidate)>max) {
					max=votingData.get(candidate);
					winner=candidate;
					if(firstTest) {
						lexicographicallySmaller = winner;
						maxForLexicographicallySmaller = max;
						firstTest = false;
					}
				} else if(votingData.get(candidate)==max && candidate.compareTo(lexicographicallySmaller)<0) {
					maxForLexicographicallySmaller=votingData.get(candidate);
					lexicographicallySmaller=candidate;
				}
			}
			if(max!=maxForLexicographicallySmaller)	output.append(winner).append(" ").append(max).append("\n");
			else output.append(lexicographicallySmaller).append(" ").append(maxForLexicographicallySmaller).append("\n");
			votingData.clear();
		}
		System.out.println(output);
	}
}
