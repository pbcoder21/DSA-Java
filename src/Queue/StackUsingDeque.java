package Queue;

import java.util.*;

public class StackUsingDeque {

    static class Stack {  
        Deque<Integer> deque = new LinkedList<>();

        //deque will start behaving as stack
        public void push(int data) {   //   ________
            deque.addLast(data);      //    |_|_|_|__ <-addLast
        }

        public int pop() {                //   ________
            return deque.removeLast();   //    |_|_|_|__ <- removeLast
        }

        public int peek() {           //   ________
            return deque.getLast();  //    |_|_|_|__ <-getLast
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("peek = " + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}