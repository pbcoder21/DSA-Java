package Stacks;

import java.util.Stack;

public class NGEStack {
    //Next Greater Right
    public static void main(String[] args) {
        int arr[]= {6,8,0,1,3}; 
        Stack<Integer> s=new Stack<>();
        int nxtGreater[]=new int[arr.length];
       
        for(int i=(arr.length-1);i>=0;i--){ //backward loop
            //1. while //NOT EMPTY
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) { 
                s.pop();                           //arr[i%arr.length] for circular
            }
            //2. if-else //EMPTY
            if(s.isEmpty()) {
                nxtGreater[i]=-1;
            }else {
                nxtGreater[i]=arr[s.peek()];
            }
            //3. push index in s
            s.push(i);     // s.push(i%arr.length); for circular  
        }
        // print nxt greaters
        for(int i=0; i<nxtGreater.length; i++) {
            System.out.print(nxtGreater[i]+" ");
        }
        System.out.println();
        // 6  8 0 1  3
        // 8 -1 1 3 -1 
    }
}
// Next Greater Left 
    // for(int i=0;i<=arr.length-1;i++) { //forward loop

//Next Smaller Right
   // while(!s.isEmpty() && arr[s.peek()] >= arr[i]) 
    //   if(s.isEmpty()) {
    //      nrs[i] = arr.length;

//Next Smaller Left
    //for(int i=0;i<=arr.length;i++) { //forward loop
    //while(!s.isEmpty() && arr[s.peek()] >= arr[i]) 