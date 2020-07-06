package recursion;


import java.util.*;
class JosephusProblem {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		while(T-->0)
		{
		    Josephus obj=new Josephus();
		    
		    int n,k;
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}


/*This is a function problem.You only need to complete the function given below*/
class Josephus
{
   public int josephus(int n, int k)
    {
        if(n==0) {
        	return 0;
        } else {
        	return ( ( josephus(n-1, k) + k-1 ) % n +1);
        }
    }
}