package Sorting;

import java.util.*;

public class InsertionSortApnaCollege {
    
      public static void insertionSort(int arr[]) {
         for(int i=1; i<arr.length; i++) {
             int curr = arr[i];
             int prev = i-1;
                //to find the index where curr is to be inserted
             while(prev >= 0 && arr[prev] > curr) { // < for desc
                 arr[prev+1] = arr[prev];
                 prev--; 
             }
             //insertion
             arr[prev+1] = curr;
         }
      }

      public static void printArr(int arr[]) {
          for(int i=0; i<arr.length; i++) {
              System.out.print(arr[i]+" ");
          }
          System.out.println();
      }
     
      public static void main(String args[]) {
          int arr[] = {5, 4, 1, 3, 2};
          //insertionSort(arr);
          printArr(arr);
    
              //Inbuilt Sorting Algo
          //Arrays.sort(arr);
          //Arrays.sort(arr,0,5);
          //Arrays.sort(arr,Collections.reverseOrder()); //for this change int->Integer/work in objects
          //Arrays.sort(arr,0,5,Collections.reverseOrder());
          //printArr(arr);
          
      }
}
