package LinkedList;

import java.util.LinkedList;

public class Basics {

    public static void main(String args[]) {
        //create
        LinkedList<String> list = new LinkedList<String>();
        
        //add
        list.add("is");
        list.add("a");
        list.addLast("list");
        list.addFirst("this");
        list.add(3, "linked");
        System.out.println(list);
        
        //get specific
        System.out.println(list.get(0));
        
        //get size
        System.out.println(list.size()); 
        
        //remove
        list.remove(3);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
    }
}


