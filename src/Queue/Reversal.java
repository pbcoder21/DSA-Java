package Queue;

import java.util.*;

public class Reversal {
     
    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        //stack reverses the i/p
        
        while(!q.isEmpty()) {
            s.push(q.remove());
        }

        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);   // 1 2 3 4 5
        q.add(3);   // 5 4 3 2 1 
        q.add(4);
        q.add(5);

        reverse(q);

        while(!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }
        System.out.println();
    }
}