package justPractice;



import java.util.Scanner;

class jp {

private static long[] fact;

public static void main(String args[]) throws Exception {
@SuppressWarnings("resource")
Scanner obj = new Scanner(System.in);
int T = Integer.parseInt(obj.nextLine());
fact = new long[100005];
fact[0] = 1;
fact[1]=1;
for(int g=2;g<100005;g++) fact[g]=0;
for (int i = 0; i < T; i++) {
int N = Integer.parseInt(obj.nextLine());
System.out.println(factorial(N));
}
}

private static long factorial(int i) {
if(i<2) return fact[i];
if(fact[i] == 0) {
fact[i] = factorial(i - 1) % 1000000007 * i % 1000000007;
}
return fact[i];
}

}
