package Patterns;

public class Pattern4 {
	public static void main(String args[]) {
		for(int i=4;i>=1;i--) {       //i=n to 1
			for(int j=1;j<=i;j++) {   //j=1 to i
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
