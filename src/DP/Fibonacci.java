package DP;

public class Fibonacci {
    
        public static int fib(int n, int f[]) { //O(n)
            if(n==0 || n==1) {  //base
                return n;
            }
            
            if(f[n] != 0) { // fib[n] is already calculated
                return f[n];
            }
            int fnm1=fib(n-1,f);  //fib n-1
            int fnm2=fib(n-2,f);  //fib n-2
            f[n]=fnm1+fnm2;
            return f[n];
        }
         
        private static int fibTabulation(int n) {
            int dp[] = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            for(int i=2; i<=n ; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
            
        }
        
        public static void main(String args[]) {
            int n=5;
            int f[]=new int[n+1]; //here store the values
            // memoization 
            //System.out.println(fib(n,f));
            
            //Tabulation
            System.out.println(fibTabulation(n));
        }
}
  