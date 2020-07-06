package justPractice;
	//Initial Template for Java
	//Initial Template for Java
	import java.util.*;
	import java.io.*;
	public class validip {
		public static void main(String[] args){
			Scanner sc= new Scanner (System.in);
			int t = sc.nextInt();
			while(t-->0){
				String s = sc.next();
				Solution obj = new Solution();
				
				if(obj.isValidIP(s))
					System.out.println(1);
				else
					System.out.println(0);
			}
		}
	}
	
	/*This is a function problem.You only need to complete the function given below*/
	//User function Template for Java
	class Solution {
		public boolean isValidIP(String s){
		   //Write your code here
		   boolean isValid = true;
		   if(s.length()>50 || s.length()==0) return false;
		   String partsOfIP[] = s.trim().split("\\.");
		   if(partsOfIP.length==4){
		       partCheck: for(String eachPart: partsOfIP){
		           if(eachPart.length()>4 || eachPart.length()==0) return false;
		           int intEachPart;
		           try {
		        	   intEachPart = Integer.parseInt(eachPart);
		           } catch (NumberFormatException e) {
					// TODO: handle exception
		        	   return false;
				}
//		           System.out.println(eachPart+"\t"+intEachPart);
		           if( ((!eachPart.equals(String.valueOf(intEachPart))) || intEachPart>255 || intEachPart<0) && !eachPart.equalsIgnoreCase("0")){
		               isValid = false;
		               //System.out.println("Error1");
		               break partCheck;
		           }
		       }
		   String dotsOfIP[] = s.trim().split("\\s*+[0-9]+\\s*+\\s*");
		   if(dotsOfIP.length!=3) isValid=false;
//		   System.out.println(Arrays.));
		   System.out.println("Length=="+dotsOfIP.length+"\n");
		   for(String sa:dotsOfIP)System.out.print(sa+"-");
		   } else {
		       isValid = false;
		       //System.out.println("Error2");
		   }
		   return isValid;
		}
	}