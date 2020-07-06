package justPractice; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GFG3 {
//	static Pair<Integer,Integer> currentPalindrome;

	static StringBuilder palindromicStrings = new StringBuilder();
//	static boolean isOddPalindrome = false;
	static String input;
	static int length=0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));	
		byte T=Byte.parseByte(obj.readLine());	
		if(T>100) System.exit(0);
		for(; T>0; T--) {
			String palindrome = null;
			input = obj.readLine();
			length = input.length();
			System.out.println("\nLength of Input: "+length);
			if(length>10000) {
				continue;
			} else if(length<=1) {
				palindromicStrings.append(input);
				palindromicStrings.append("\n");
				continue;
			} else if(length==2) {
				if(input.charAt(0)==input.charAt(1))
					palindromicStrings.append(input);
				else
					palindromicStrings.append(input.charAt(0));
				palindromicStrings.append("\n");
				continue;
			} else {
				int p1=0,p2=1,p3=2;
				int maxLengthPalindrome = 1;
				int currentLength = 0;
//				char ch1,ch2,ch3;
				for(; p3<length ; ) {
//					ch1=input.charAt(p1);
//					ch
					if(input.charAt(p1)==input.charAt(p2)) {
						System.out.println("Matching even characters: "+input.charAt(p1)+" & "+input.charAt(p2));
						currentLength = checkForEvenPalindrome(p1);
						if(currentLength>maxLengthPalindrome) {
//							isOddPalindrome = false;
							maxLengthPalindrome = currentLength;
							int startPosition = p2-((int)currentLength/2);
							palindrome = input.substring(startPosition,startPosition+currentLength);
							System.out.println("(ODD) Check1: "+palindrome+"  p1= "+p1);
						}						
					} 
					if(input.charAt(p1)==input.charAt(p3)) {
						System.out.println("Matching odd characters: "+input.charAt(p1)+" & "+input.charAt(p3));
						currentLength = checkForOddPalindrome(p1);
						if(currentLength>maxLengthPalindrome) {
							maxLengthPalindrome = currentLength;
//							isOddPalindrome = true;
							int startPosition = p2-((int)(currentLength-1)/2);
							System.out.println("Start Position: "+startPosition);
							palindrome = input.substring(startPosition,startPosition+currentLength);
							System.out.println("(Even) Check1: "+palindrome+"  p1= "+p1);
						}
					}
					System.out.println("---------------Iteration No:"+(p1+1)+" Values: p1=%d,p2=%d,p3=%d...--------"+p1+p2+p3);
					p1++;
					p2++;
					p3++;
				}
				palindromicStrings.append(palindrome);
				palindromicStrings.append("\tlength:"+maxLengthPalindrome);
				palindromicStrings.append("\n");
			}
			
		}
		System.out.println(palindromicStrings);
	}
	
	static int checkForEvenPalindrome(int startPosition) {
//		return length of palindrome
		int p1=startPosition;
		int p2=p1+1;
		while(p1>=0 && p2<length) {
			if(input.charAt(p1)!=input.charAt(p2)) {
				break;
			}
			p1--;
			p2++;
		}
		int l = p2-p1-1;
		if(l>0) return l;
		else return 0;
	}
	static int checkForOddPalindrome(int startPosition) {
//		returns length of palindrome
		int p1=startPosition;
		int p2=p1+2;
		while(p1>=0 && p2<length) {
			if(input.charAt(p1)!=input.charAt(p2)) {
				break;
			}
			p1--;
			p2++;
		}
		int l = p2-p1+1;
		if(l>0) return l;
		else return 0;
	}

}
