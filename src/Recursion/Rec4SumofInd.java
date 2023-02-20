package Recursion;  //123  --> 1+2+3=6

import Functions.Sumof2no;

public class Rec4SumofInd {
	
	public static int Sum(int n) {
		if(n==0) {
			return 0;
		}
		int last=n%10;
		int remaining=n/10;
		return Sum(remaining)+last;
		
	}
	
	public static void main(String args[]) {
		System.out.println(Sum(123));  
	}

}
