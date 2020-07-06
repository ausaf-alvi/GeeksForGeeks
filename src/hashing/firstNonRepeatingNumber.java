package hashing;

import java.util.*;
import java.io.*;
class firstNonRepeatingNumber
 {
	public static void main (String[] args)throws IOException
	 {
	 //code
	 BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
	 int T = Integer.parseInt(obj.readLine());
	 StringBuilder output = new StringBuilder();
	 testCase: while(T-->0){
	     int N = Integer.parseInt(obj.readLine());
	     LinkedHashMap<Long , Integer> map = new LinkedHashMap<Long, Integer>();//pairs of number and count of occurences
	     long A[] = new long[N];
	     {
	         String input[] = obj.readLine().split(" ");
	         for(int i=0 ;i<N;i++){
	             long current = Long.parseLong(input[i]);
	             if(current==0) continue testCase;
	             if(map.containsKey(current)){
	                 int occurance = map.get(current) + 1;
	                 map.put(current , occurance);
	             } else {
	                 map.put(current , 1);
	             }
	         }
	         long nonRepeatingElement = 0;
	         Set<Long> keySet = map.keySet();
	        loop2: for(Object k: keySet){
	             if(map.get((long)k)==1){
	                 nonRepeatingElement = (long)k;
	                 break loop2;
	             }
	         }
	         output.append(nonRepeatingElement).append("\n");
	     }
	 }
	 System.out.println(output);
	 }
}
