package Recursion;          // 5! = 5x4! (big problem into small problems)
						    // 4! = 4x3! = n * fact
public class Factorial {
	
	public static int Fact(int n) {
		if(n==1 || n==0) { //BC
			return 1;
		}
		
		int fact=Fact(n-1);
		return n*fact;
	}
	
	public static void main(String args[]) {
		System.out.println(Fact(5));
	}

}
