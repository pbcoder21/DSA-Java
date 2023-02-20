package Queue;

import java.util.*;

public class StackUsing2Queues {
    
    static class Stack{
        static Queue<Integer> q1=new LinkedList<>();
        static Queue<Integer> q2=new LinkedList<>();
        
        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }
        
        public static void push(int data) {
            if(!q1.isEmpty()) { //q1 is EMPTY
                q1.add(data); //add it
            }else {
                q2.add(data); //if q1 is not empty, add in q2
            }
        }
        
        public static int pop() {
            if(isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int top=-1;
            
            //case1
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top=q1.remove(); //last data
                    if(q1.isEmpty()) {
                        break;
                    }
                    q2.add(top); //add last data in q2
                }
            }else { //case2
                while(!q2.isEmpty()) {
                    top=q2.remove();
                    if(q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }              
            }
            return top; 
        }
        
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Statck is Empty");
                return -1;
            }
            int top=-1;
            
            //case1
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top=q1.remove();               
                    q2.add(top);
                }
            }else { //case2
                while(!q2.isEmpty()) {
                    top=q2.remove();
                    q1.add(top);
                }              
            }
            return top;   
        }
    }
    
    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
               //Ans should be opp
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

}
 