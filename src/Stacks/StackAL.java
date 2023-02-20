package Stacks;

import java.util.ArrayList;

public class StackAL {
    
    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }
        
        //push
        public void push(int data) {
            list.add(data);
        }

        //pop
        public int pop() {
            if(isEmpty()) { //checks if empty
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        
        //peek
        public int peek() {
            if(isEmpty()) { //checks if empty
                return -1;
            }
            int top=list.get(list.size()-1);
            return top;
        }
    }
    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.peek();

        while(!stack.isEmpty()) { //run till stacks not get empty  
            System.out.println(stack.peek());  //print
            stack.pop(); //then delete
        }
    }
}