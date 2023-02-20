package Recursion;

public class Fibonacci {
		public static int fib(int n) {
			if(n==0 || n==1) {  //base
				return n;
			}
			
			int fnm1=fib(n-1);  //fib n-1
			int fnm2=fib(n-2);  //fib n-2
			return fnm1+fnm2;  //small work
		}
		
		public static void main(String args[]) {
			System.out.println(fib(5));
		}
}
