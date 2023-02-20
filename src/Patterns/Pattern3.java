package Patterns;

public class Pattern3 {
	public static void main(String args[]) {
		for(int i=1;i<=4;i++) {       // i=1 to n
			for(int j=1;j<=i;j++) {   // j=1 to i
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
