package Stacks;

import java.util.*;

public class ValidParanthesis { //O(n)
    
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        int i=0;
        
        while(i<str.length()) {
            char ch = str.charAt(i); //char(parentheses) stores onebyone
                //opening chars
            if(ch == '(' || ch == '{' || ch == '[') {  
                s.push(ch); //add
            } else { 
                //closing chars
                if(s.isEmpty()) {
                    return false; //EMPTY
                }
                    //checks pair using peek()
                char top = s.peek(); 
                if((top == '(' && ch == ')') 
                    || (top == '{' && ch == '}')
                    || (top == '[' && ch == ']')) {
                        s.pop(); // pair exists -> pop()
                } else {
                    return false; //INVALID char
                }
            }
            i++; //now go to next char
        }
        if(s.isEmpty()) { //Stack empty?? yes
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        String str = "(([{}])()[])";
        //String str = "(([{}])))[])";
        System.out.println(isValid(str));
    }
}