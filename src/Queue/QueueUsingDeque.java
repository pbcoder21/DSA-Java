package Queue;

import java.util.*;

public class QueueUsingDeque {

    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        //deque will start behaving as queue
        public void add(int data) {    //   __________
            deque.addLast(data);      //    _|_|_|_|__ <-addLast
        }

        public int remove() {               //                   __________
            return deque.removeFirst();    //  removeFirst < --  _|_|_|_|__ 
        }
        
        public int peek() {              //                 __________
            return deque.getFirst();    //    getFirst <--  _|_|_|_|__
        }
    }
    
    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("peek = " + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}