package Stacks;

import java.util.*;

public class DuplicateParanthesis {
    
    public static boolean checkDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        int i=0;
        
        while(i<str.length()) {
            char ch = str.charAt(i); //onebyone index, str ch will come
            //closing
            if(ch == ')') {
                int count = 0; //this are items present between opening and closing
                while(s.pop() != '(') {
                    count++;
                }
                if(count < 1) { //no ch is present in between
                    return true; //duplicate exists
                }
            } else {
                s.push(ch); //next str ch
            }
            i++;
        }
        return false;
    }
    public static void main(String args[]) {
         //String str = "(a+b)"; //false
//         String str = "((a+b)+(c))"; //false
//         String str = "(((a+b))+c)"; //true
//        String str = "((a+b))"; //true
        String str = "(((a+(b))+(c+d)))"; //true
        System.out.println(checkDuplicate(str));
    }
}