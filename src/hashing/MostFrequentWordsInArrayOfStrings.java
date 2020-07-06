package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class MostFrequentWordsInArrayOfStrings {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(obj.readLine());
		if(T<0 || T>100) System.exit(0);
		StringBuilder output = new StringBuilder();
		while(T-->0) {
			int N = Integer.parseInt(obj.readLine());
			StringTokenizer tk = new StringTokenizer(obj.readLine());
			Map<String , Integer> map = new LinkedHashMap<String, Integer>();
			for(int i=0 ; i<N ; i++) {
				String word = tk.nextToken();
				if(map.containsKey(word)) {
					int c = map.get(word);
					map.put(word , c+1);
				} else {
					map.put(word , 1);
				}
			}
			int maxFrequency = -2;
			String mostFrequentWord = "";
			for(Entry<String, Integer> e : map.entrySet()) {
				if(e.getValue()>maxFrequency && e.getValue()!=-1) {
					mostFrequentWord = e.getKey();
					maxFrequency = e.getValue();
				} else if(e.getValue()==maxFrequency) {
					e.setValue(-1);
					map.put(e.getKey(), -1);
					mostFrequentWord = e.getKey();
				}
			}
			output.append(mostFrequentWord).append("\n");
		}
		System.out.println(output);
	}

}
