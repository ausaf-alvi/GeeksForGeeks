package hashing;

import java.util.*;
import java.io.*;

class WinnerOfElectionFinal {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String name="";
		    int max=-1;
		    int n = Integer.parseInt(br.readLine());
		    String[] names = br.readLine().split("\\s+");
		    HashMap<String,Integer> map = new HashMap();
		    for(int i=0;i<n;i++){
		        if(map.containsKey(names[i])){
		            int c = map.get(names[i]);
		            map.put(names[i],c+1);
		        }
		        else
		        map.put(names[i],1);
		        
		        int value = map.get(names[i]);
		        if(value>max){
		            name = names[i];
		            max = value;
		        }
		        if(value==max){
		            name = name.compareTo(names[i])<0?name:names[i];
		        }
		    }
		    System.out.println(name+" "+max);
		}
	}
}