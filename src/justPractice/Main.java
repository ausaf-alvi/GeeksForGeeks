package justPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	static final BigInteger MOD_NUMBER=new BigInteger("1000000007");
	static BigInteger arrayOfFactorials[]=new BigInteger[100005];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        for(int i=0;i<100005;i++)   arrayOfFactorials[i]=BigInteger.ZERO;
        arrayOfFactorials[0]=arrayOfFactorials[1]=BigInteger.ONE;
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(obj.readLine());
        if(T<1 || T>100000)System.exit(0);
        for(int t=0;t<T;t++){
            int N=Integer.parseInt(obj.readLine());
            if(N<0 || N>100000)System.exit(0);
            System.out.println(computeFunc(N));
        }
    }
    public static BigInteger computeFunc(int n){
        if(arrayOfFactorials[n].compareTo(BigInteger.ZERO)!=0) return arrayOfFactorials[n];
  //      if(n<2) return arrayOfFactorials[1];
        return arrayOfFactorials[n]=(computeFunc(n-1).mod(MOD_NUMBER)).multiply((new BigInteger(String.valueOf(n))).mod(MOD_NUMBER));
    }
		

	}


