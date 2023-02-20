package Queue;

//queue using 2 stacks
import java.util.*;

public class QueueUsing2Stacks {

     static class Queue {
         static Stack<Integer> s1 = new Stack<>();
         static Stack<Integer> s2 = new Stack<>();

         public static boolean isEmpty() {
             return s1.isEmpty(); //s1 stack is empty
         }
             //add O(n) //2 while loop = O(2n)=O(n)
         public static void add(int data) {
             while(!s1.isEmpty()) { // ! jab tak khali nhi hota, add karoo 
                 s2.push(s1.pop()); // s1(data) --> s2(data)
             }
             s1.push(data); //s1 me add new data
             
             while(!s2.isEmpty()) { //s2(data) --> s1(data)
                 s1.push(s2.pop());
             }          
         }
             //remove
         public static int remove() {
             return s1.pop(); //top will be removed
         }

         public static int peek() {        
             return s1.peek(); //top will be viewed
         }
     }
     
     public static void main(String args[]) {
         Queue q = new Queue();
         q.add(1);
         q.add(2);
         q.add(3);

         while(!q.isEmpty()) {
             System.out.println(q.peek());
             q.remove();
         }
     }
}
