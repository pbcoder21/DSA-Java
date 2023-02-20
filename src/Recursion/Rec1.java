package Recursion;  //Apna College  5 to 1 //DECREASING

public class Rec1 {
	
	public static void printNumb(int n) {
		if(n==0) {    //Base Case/Condition
			return;
		}
		
		System.out.println(n);//Print                                           -----------------
		printNumb(n-1);  //Recursion fns : fns calling itself                            |
		 
	}
	
	public static void main(String args[]) {
		int n=5;   
		printNumb(5);
	}

}
 