package Heap;
import java.util.*;

public class PriorityQueueBasics {
    
    
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        pq.add(2); //O(logn)
        pq.add(4);
        pq.add(1);
        pq.add(7);
        
        while(!pq.isEmpty()) {
            System.out.println(pq.peek()); //O(1)
            pq.remove(); //O(logn)
        }
    }

}
 