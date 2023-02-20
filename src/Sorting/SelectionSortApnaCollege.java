package Sorting;
import java.util.*;

//time complexity: O(n^2)

public class SelectionSortApnaCollege {
	
	 public static void main(String args[]) {
	       int arr[] = {7, 8, 1, 3, 2};
	 
	       //selection sort
	       for(int i=0; i<arr.length-1; i++) {  //n-1 times run 
	           int smallest = i;
	           for(int j=i+1; j<arr.length; j++) {
	               if(arr[j] < arr[smallest]) { // > for desc
	                   smallest = j;
	               }
	           }
	           //swap
	           int temp = arr[smallest];
	           arr[smallest] = arr[i];
	           arr[i] = temp;
	       }
	       
	   
	       for(int i=0; i<arr.length; i++) {
	           System.out.print(arr[i]+" ");
	       }
	 }
}



//Problem : Selection Sort

//public class SelectionSort {
//    
//      public static void selectionSort(int arr[]) {
//          
//          for(int turn=0; turn<arr.length; turn++) {
//              int minPos = turn;
//              for(int j=turn+1; j<arr.length; j++) {
//                  if(arr[minPos] > arr[j]) {
//                      minPos = j;
//                  }
//              } 
//              //swap
//              int temp = arr[turn];
//              arr[turn] = arr[minPos];
//              arr[minPos] = temp;
//          }
//      }
//    
//      public static void selectionSortDescending(int arr[]) {
//          
//          for(int turn=0; turn<arr.length; turn++) {
//              int minPos = turn;
//              
//              for(int j=turn+1; j<arr.length; j++) {
//                  if(arr[minPos] < arr[j]) {
//                      minPos = j;
//                  }
//              } 
//              //swap
//              int temp = arr[turn];
//              arr[turn] = arr[minPos];
//              arr[minPos] = temp;
//          }
//      }
//    
//      public static void printArr(int arr[]) {
//          for(int i=0; i<arr.length; i++) {
//              System.out.print(arr[i]+" ");
//          }
//          System.out.println();
//      }
//      
//      public static void main(String args[]) {
//          int arr[] = {5, 4, 1, 3, 2};
//          selectionSortDescending(arr);
//          printArr(arr);
//      }
//}