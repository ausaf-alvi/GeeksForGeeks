package hashing;

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)throws IOException
	 {
	 //code
	 BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
	 int T = Integer.parseInt(obj.readLine());
	 StringBuffer output= new StringBuffer();
	 while(T-->0){
	     String input = obj.readLine();
	     char letter[] = input.toCharArray();
	     boolean isIsomorphic = true;
	     HashMap<Character , Integer> map = new HashMap<Character , Integer>();
	     for(int i=0 ; i<letter.length && isIsomorphic ; i++){
	         if(map.containsKey(letter[i])){
	             int c = map.get(letter[i]);
	             map.put(letter[i],c+1);
	         } else {
	             map.put(letter[i],1);
	         }
	         if(map.get(letter[i])>1){
	             isIsomorphic = false;
	             break;
	            
	         }
	 }
	 if(isIsomorphic){
	     output.append("1\n");
	 }else {
	     output.append("0\n");
	 }
	 }
	 System.out.println(output);
	 }}
