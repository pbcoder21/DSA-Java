package Functions;

import java.util.Scanner;

public class NoRaisedtToPower {
	public static void main(String args[]) {  //x raised to n
	       
		System.out.println("Enter x");   
		Scanner sc = new Scanner(System.in);
	    int x = sc.nextInt();
	    System.out.println("Enter n");
	    int n = sc.nextInt();
	 
	    int result = 1;
	       //Please see that n is not too large or else result will exceed the size of int
	    for(int i=1; i<=n; i++) {   //focusing only on n raised part
	    	
	           result = result * x;  //focusing on base
	    }
	 
	     System.out.println("x to the power n is : "+ result);
	   }   

	
}
