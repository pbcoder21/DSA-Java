package Recursion; //Sum of Natural Numbers

public class Sum {
	 
	public static int recurSum(int n) {
		if (n == 1) {             // 1+2+3+4+5.....+(n-1) + n
		    return 1;              //          left        right
		}
		
		int left=recurSum(n-1);
		return n+left;  
	    }
	   
	    public static void main(String args[]) {  // Driver code
	        int n = 5;
	        System.out.println("Final = " + recurSum(n));
	    }

}
