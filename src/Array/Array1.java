package Array;

import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;

public class Array1 {
	 public static void main(String args[]) {
		   System.out.print("Enter Array Size : ");

		   Scanner sc = new Scanner(System.in);
	       int size = sc.nextInt();
	       int numbers[] = new int[size];
	      
	       for(int i=0; i<size; i++) {
	           numbers[i] = sc.nextInt();
	       }
	 
	       //print the numbers in array
	       for(int i=0; i<size; i++) {
	           System.out.print(numbers[i]+" ");
	       }
	   }
}
