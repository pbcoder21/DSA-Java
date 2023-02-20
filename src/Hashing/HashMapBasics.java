package Hashing;  //Basics
 
import java.util.*;

public class HashMapBasics{
    
    public static void main(String[] args) {
        //country(key), population(value)
        HashMap<String, Integer> map=new HashMap<>();
        
        //Insertion (.put(key,value))
        map.put("India",120); 
        map.put("US", 30);
        map.put("China", 150);
        
        //print
        System.out.println(map);
        
        //update
        map.put("China", 180);
        System.out.println(map);
        
        //search/lookup(check for existence  (.containsKey(key)) -> true/false
        System.out.println(map.containsKey("China")); //exist
        System.out.println(map.containsKey("Iran")); //not exist
//        if(map.containsKey("China")) {
//            System.out.println("key is present in the map");
//        }else {
//            System.out.println("key is not present in the map");
//        }
        
        //To get values of corresponding keys (.get(key) -> value)
        System.out.println(map.get("China")); //key exist
        System.out.println(map.get("Iran")); //key doesnt exist
        
        //Iteration in HashMap
//        int[] a= {12,15,18};
//        for(int i=0;i<3;i++) {
//            System.out.print(a[i]+" ");
//        }
//        System.out.println();
//        
//        for(int val:a) {
//            System.out.print(val+" ");
//        }
//        System.out.println();
        
        //EntrySet
        for(Map.Entry<String, Integer> e:map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        
        //KeySet
        Set<String> keys=map.keySet();
        for(String key: keys) {
            System.out.println(key+" : " + map.get(key));
        }
        
        //Deletion (.remove(key)) -deletes both key,value
        map.remove("China");
        System.out.println(map);
        
        
        
        
        
        
    }
    
    
    
}
