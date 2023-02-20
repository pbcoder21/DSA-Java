package Recursion;
 
public class ArraySort {
	                                          //start index
	public static boolean isSorted(int arr[] ,int start) {
		if(start==arr.length-1) {   //base     // 0 == 4
			return true; //when 4==4, true
		}
		 // 2,3,5,7,9
		if(arr[start]>arr[start+1]) {  //
			return false; 
		}
		
		boolean assumption=isSorted(arr,start+1);  //recursion
		return assumption;
		
	}
	
	public static void main(String args[]) {
		int arr[] = {2,3,5,7,9};
		System.out.println(isSorted(arr, 0));
	}

}
