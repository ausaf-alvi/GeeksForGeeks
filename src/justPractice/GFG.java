package justPractice;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//
//
//
//
//public class GFG {
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		long startTime = System.nanoTime();
//		//code
//		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
//		short T = Short.parseShort(obj.readLine());
////  		1 <= T >= 200
//		if(T<0 || T>100) System.exit(0);
//		while(T>0){
////		    String input[] = obj.readLine().split(" ");
//		    int N = Integer.parseInt(obj.readLine());
//		    
////		    String input[] = obj.readLine().split(" ");
//		    int input[] = Arrays.stream(obj.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//		    
//		  //  1<=N<=10^7 && 1<=d<=N
////		    boolean b[] = new boolean[N];
//	
//		    
//		    if(N<1 || N>10000000 ) System.exit(0);
////		    Stack<Integer> stackResult = new Stack<>();
//		    
//		    int largestNumber = input[--N];// Integer.parseInt(input[N-1]);
//		    if(largestNumber>10000000) System.exit(0);
//		    int currentElement;
//		    StringBuffer output = new StringBuffer();
//		    while(N>-1) {
//		    	currentElement = input[N];//Integer.parseInt(input[i]);
//		    	if(currentElement >= largestNumber) {
////		    		b[i]=true;
////		    		stackResult.push(currentElement);
//		    		output.insert(0, " ");
//		    		output.insert(0, currentElement);
//		    		largestNumber = currentElement;
//		    		if(largestNumber>10000000) System.exit(0);
//		    	}
//		    	N--;
//		    	
//		    }
////		    stackResult.stream().forEach(i -> System.out.print(i));
////		    while(!stackResult.isEmpty()) {
////		    	System.out.print(stackResult.pop()+" ");
////		    }
//		    
//		    System.out.println(output);
//		    T--;
//
//		}
//		 
//		 long endTime = System.nanoTime();
//		 System.out.println("Took "+(((double)(endTime - startTime))/1000000000) + " s");   
//		 System.out.println("12345".compareTo("9999"));
//	}
//}



//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Stack;




public class GFG {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		//code
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		short T = Short.parseShort(obj.readLine());
//  		1 <= T >= 200
		if(T<0 || T>100) System.exit(0);
		while(T>0){
//		    String input[] = obj.readLine().split(" ");
		    int N = Integer.parseInt(obj.readLine());
		    String input[] = obj.readLine().split(" ");
		  //  1<=N<=10^7 && 1<=d<=N
//		    boolean b[] = new boolean[N];
	
		    
		    if(N<1 || N>10000000 ) System.exit(0);
//		    Stack<String> stackResult = new Stack<>();
		    StringBuffer output = new StringBuffer();
		    String largestNumber = input[--N];
		    int largestNumberLength = largestNumber.length();
		    //if(largestNumber>10000000) System.exit(0);
		    int currentElementLength;
		   // StringBuffer output = new StringBuffer();
		    while(N>-1) {
		    	currentElementLength = input[N].length();
		    	if( (input[N].compareTo(largestNumber)>=0  && currentElementLength==largestNumberLength) || (currentElementLength>largestNumberLength) ) {
//		    		b[i]=true;
//		    		stackResult.push(input[i]);
		    		largestNumber = input[N];
		    		largestNumberLength = currentElementLength;
//		    		output.insert(0, input[N]);
		    		output.append(new StringBuffer(input[N]).append(" ").reverse());
		    		//if(largestNumber>10000000) System.exit(0);
		    	}
		    	N--;
		    }
//		    while(!stackResult.isEmpty()) {
//		    	System.out.print(stackResult.pop()+" ");
//		    }
		    System.out.println(output.reverse());
		    T--;
		}
		 
		 long endTime = System.nanoTime();
		 System.out.println("Took "+(((double)(endTime - startTime))/1000000000) + " s");   
		 System.out.println("12345".compareTo("19999"));
	}
}
