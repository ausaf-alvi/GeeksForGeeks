package hashing;

import java.util.*;
import java.io.*;
class LuckyNumber
 {
	public static void main (String[] args)throws IOException
	 {
	 //code
	 BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
	 int T = Integer.parseInt(obj.readLine());
	 boolean isLucky = true;
	 StringBuffer output = new StringBuffer();
	 HashMap<Long , Long> map = new HashMap<Long , Long>();
	 long number = 0l;
	 long productOfDigits=1l;
	 while(T-->0){
		 isLucky = true;
	     char[] input = obj.readLine().toCharArray();
	     for(int i=0 ; i<input.length && isLucky ; i++){
	         for(int j=i ; j<input.length ; j++){
	             number = 0l;
	             productOfDigits = 1l;
	             for(int k=i ; k<=j ; k++){
	                 long digit = Long.parseLong(String.valueOf(input[k]));
	                 number = (number*10)+(digit);
	                 productOfDigits = productOfDigits*digit;
	             }
	             if(map.containsKey(productOfDigits)){
//	            	 System.out.println("number check = "+number+"product check="+productOfDigits);
	                 isLucky = false;
	                 break;
	             } else {
	                 map.put(productOfDigits,number);
	             }
	         }
	     }
	     if(isLucky){
	         output.append("1\n");
	     } else {
	         output.append("0\n");
	     }
	     map.clear();
	 }
	 System.out.println(output);
	 }
}