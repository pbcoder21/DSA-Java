package Stacks;
import java.util.*;

public class AreainHistogram {

    public static void maxArea(int arr[]) {
        int nls[] = new int[arr.length]; //Next Left Smallest
        int nrs[] = new int[arr.length]; //Next Right Smallest
        
        //Next Right Smallest //--->small
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--) { //<---
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nrs[i] = arr.length;
            } else {
                nrs[i] = s.peek();
            }
            s.push(i);
        }

        //Next Left Smallest   //small<----
        s = new Stack<>(); //stack EMPTY
        for(int i=0; i<arr.length; i++) { //--->
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nls[i] = -1;
            } else {
                nls[i] = s.peek();
            }
            s.push(i);
        }

        //Calculate Area(Rectangle)  //width=j-i-1=nsr[i]-nsl[i]-1
        int maxArea = 0;
        for(int i=0; i<arr.length; i++) {
            int currArea = arr[i]*(nrs[i]-nls[i]-1); //height x width
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("max area of histogram = " + maxArea);
    }
      
    public static void main(String args[]) {
        int arr [] = {2,1,5,6,2,3};
        maxArea(arr);
   }
}