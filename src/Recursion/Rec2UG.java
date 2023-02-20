package Recursion;

public class Rec2UG {
	
	public static void printnumb(int n) {
		if(n==0) {   //Base Condition
			return;
		}
		
		printnumb(n-1);   //first n-1 lines               |
		System.out.println(n);         //         ------------------
	}
		
	public static void main(String args[]) {
		//int n=10;
		printnumb(10);
	}

}
