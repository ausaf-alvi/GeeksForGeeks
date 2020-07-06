package justPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.TreeSet;


public class PermutationsOfString {
	static int length;
	static TreeSet<String> permutations; 
	public static void main(String[] args) throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(obj.readLine());
		if(T<0 || T>10) System.exit(0);
		for(int t=0 ; t<T ; t++) {
			String input = obj.readLine();
			int length = input.length();
			if(length>5 || length==0) continue;
			permutations = new TreeSet<String>();
			permutation(input);
			StringBuilder outputBuilder = new StringBuilder();
			for(String st:permutations) {
				outputBuilder.append(st+" ");
			}
			System.out.println(outputBuilder);
			}
		}
	public static void permutation(String str) {
		permutation("",str);
	}
	public static void permutation(String prefix , String remaining) {
		int n = remaining.length();
		if(n==0) permutations.add(prefix);
		else {
			for(int i=0 ; i<n ; i++) {
				permutation( prefix+remaining.charAt(i) , remaining.substring(0, i)+remaining.substring(i+1 , n) );
			}
		}
	}
}
