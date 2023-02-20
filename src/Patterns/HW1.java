package Patterns;

public class HW1 {
	public static void main(String args[]) {
	       int n = 4;
	      
	       for(int i=1; i<=n; i++) {   //rows, i=1 to n
	           for(int j=1; j<=n-i; j++) {  //spacesr, j=1 to n-i
	               System.out.print(" ");
	           }
	 
	           for(int j=1; j<=i; j++) { //star, j=1 to i
	               System.out.print("*");
	           }
	           System.out.println();
	       }
	   }

}
