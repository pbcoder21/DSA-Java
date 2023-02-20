package Recursion;    //Apna College
 
import Functions.Sumof2no;

public class Rec3Sum { 
	// 1+2+3+4+..(n-1) + n
	
	public static void sum(int i,int n,int sum) {
		if(i==n) {
			sum+=i;
			System.out.println("Final = " + sum);
			return;
		}
		
		sum+=i;
		sum(i+1, n ,sum);
		System.out.println(i);
	}
	
	public static void main(String args[]) {
		sum(1,5,0);
	}

}
