package Functions;

import java.util.Scanner;

public class Sumof2no {
	
//	public static int calculateSum(int a,int b){  //Sum Calculation
//		int sum = a+b;
//		return sum;
//		
//	}
//	
//	public static int calculateProduct(int a,int b) {  //Product Calculation
//		return a*b;
//	}
	
	public static void calculateFactorial(int c) {
		int fact=1;
		
		if(c<0) {
			System.out.println("Invalid No.");
			return;
		}
		
		for(int i=c;i>=1;i--) {
			fact=fact*i;
		}
		System.out.println("Factorial of no. is : "+ fact);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
//		
//		int sum = calculateSum(a, b);  //Sum
//		System.out.println("Sum of 2 numbers is : "+ sum);
//		
//		System.out.println("Product of 2 numbers is : "+ calculateProduct(a, b)); //Product
//		
		calculateFactorial(c);
		
		int average = (a + b + c) / 3;
	    System.out.println("Average of 3 no. is : "+average);
	}

}


