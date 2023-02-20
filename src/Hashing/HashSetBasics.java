package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetBasics {
    
    public static void main(String[] args) {
        //create
        HashSet<Integer> set=new HashSet<>();
        //ArrayList<Integer> list=new ArrayList<>();
        
        //insert (.add)
        set.add(1); //list.add(1)
        set.add(2);
        set.add(3);
        set.add(1); //only unique will be added
        
        //print all elements
        System.out.println(set);
        
        //size
        System.out.println("Size : "+set.size());
        
        //search (.contains)
        set.contains(1);
        System.out.println(set.contains(1));
        
        //delete (.remove)
        //set.remove(1);
        System.out.println(set);
        
        if(!set.contains(1)) {
            System.out.println("doesnt contain 1");
        }
        
        //Iterator(traverse)
        Iterator it=set.iterator();
        // .next , .hasNext
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
         
        
        
    }

}
