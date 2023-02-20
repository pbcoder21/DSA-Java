package Recursion;   // 1 to 5 //INCREASING

public class Rec2 {   
	
	public static void printNumb(int n) {
		if(n==6) {    //Base Case/Condition
			return;
		}
		
		System.out.println(n);//Print
		printNumb(n+1);  //Recursion fns : fns calling itself

	}
	
	public static void main(String args[]) {
		int n=1;
		printNumb(1);
	}


}
