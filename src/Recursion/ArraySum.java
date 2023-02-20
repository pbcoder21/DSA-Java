package Recursion;

public class ArraySum {
	
	public static int sum(int arr[],int start) {
		if(start==arr.length-1) {  //base
			return arr[start]; 
		}
		
		return arr[start]+sum(arr, start+1);  //work + assumption |
	}
	
	public static void main(String args[]) {
		int arr[] = {2,3,5,9,7,10};
		System.out.println(sum(arr, 0));
	}

}
