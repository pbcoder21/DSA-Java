package Recursion;   //Yt: https://www.youtube.com/watch?v=ZiY58-I-rHs&list=PLN4aKSfpk8TRJQvMutaaCzQ4kV1pitvi_&index=16

public class Power {
	
	public static int Power(int x,int n) {     // 2^5 = 2 * 2^4
		if(n==0) {                             //         * (recursion0
			return 1;
		}
		int assumption= Power(x, n-1);  //(x,n+1)
		int ans= x*assumption;          
		return ans;
	}
	
	public static void main(String args[]) {
		System.out.println(Power(3,4));  //(2,-2)
		
	}

}
