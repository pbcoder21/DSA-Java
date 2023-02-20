package Recursion;  //https://www.youtube.com/watch?v=ZiY58-I-rHs&list=PLN4aKSfpk8TRJQvMutaaCzQ4kV1pitvi_&index=16

public class PowerNeg {
	
	public static double PowerNeg(int x,int n) {
		if(n==0) {
			return 1;
		}
		double assumption= PowerNeg(x, n+1);  //(x,n+1)
		double ans= (1/(double)x)*assumption;          
		return ans;
	}
	
	public static void main(String args[]) {
		System.out.println(PowerNeg(2,-4));  //(2,-2)
	}
}
