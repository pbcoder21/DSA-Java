package Queue;

//queue using Java Collection Framework
import java.util.*;

public class QueueC {
    
     public static void main(String args[]) {
         //Queue<Integer> q = new LinkedList();
         Queue<Integer> q = new ArrayDeque<>(); //LinkedList<>();
         q.add(1);
         q.add(2);
         q.add(3); //O(1)
         q.add(4);
         q.add(5);
 
         while(!q.isEmpty()) {
             System.out.println(q.peek());
             q.remove();
         }
     }
}
