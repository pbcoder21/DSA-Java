package Hashing;

import java.util.*;

public class HashMapCode {
    
        static class HashMap<K,V>{ //generics/parametrize types
            
            private class Node{
                K key;  // variable_type  variable_name;
                V value;
                
                public Node(K key, V value) { //constructor 
                    this.key=key;
                    this.value=value;
                }
            }
            
            private int n; //n = nodes
            private int N; //N = buckets
            private LinkedList<Node> buckets[]; //N=buckets.length
            //                  int   arr[]     //buckets hai arrays ka naam
            //buckets array jiska type hai LL of nodes   //this is HashMap
            
            public HashMap() {  //HashMap Constructor
                this.N=4;       //initilize with empty LL(complusory)
                this.buckets=new LinkedList[4]; //initilaisation of bucket bucket aray whose type is LL
                for(int i=0;i<4;i++) {
                    this.buckets[i]=new LinkedList<>();
                }
            }
            
            private int hashFunction(K key) { // 0 to N-1 ( key--[hf]--bucket[i] ) 
                int bi=key.hashCode(); //23a@5 , -342 it can be neg
                return Math.abs(bi) % N;  //make it pos // num%2 --(0,1
            } 
            
            private int searchinLL(K key,int bi) { //LL   | | | | | 
                 LinkedList<Node> ll= buckets[bi];
                 
                 for(int i=0;i<ll.size();i++) {
                     if(ll.get(i).key==key) { //Node.key==key
                         return i; //di (LL index)
                     }
                 }
                 return-1;
            }
            
            @SuppressWarnings("unchecked")
            private void reHash() {  //empty array is created
                LinkedList<Node> oldBucket[]=buckets; //store current data somewhere
                buckets=new LinkedList[N*2]; //size incr
                
                for(int i=0;i<N*2;i++) { //empty LL is created
                    buckets[i]=new LinkedList<>();
                }
                
                for(int i=0;i<oldBucket.length;i++) {
                    LinkedList<Node> ll=oldBucket[i];
                    for(int j=0;j<ll.size();j++) {
                        Node node=ll.get(j);
                        put(node.key,node.value);
                    }
                }
                
            }
            
            public void put(K key, V value) { //Add Value
                int bi=hashFunction(key); // --0--1--2--3--4-- (bi)bucket-index (bucket array ka index)
                int di=searchinLL(key,bi); //  |  |  |  |  |   (di)data-index (LL ka index)
                
                if(di==-1) { //key does'nt exist,
                    buckets[bi].add(new Node(key, value));  //new node added in LL
                    n++;     //as new key is add -> increase it
                }else {
                    Node node= buckets[bi].get(di); 
                    node.value=value;      //key exist -> update node value
                }
                
                double lambda=(double)n/N;
                if(lambda>2.0) {
                      reHash();//do Re-Hashing
                }  
            }
            
            public boolean containsKey(K key) { // T/F ?
                int bi=hashFunction(key); // ----------------- bucket-index
                int di=searchinLL(key,bi); //  |  |  |  |  |   data-index
                
                if(di==-1) { //key doesn't exist,
                    return false;    
                }else {
                    return true; //key exist
                }
            }
            
            public V remove(K key) {
                int bi=hashFunction(key); // ----------------- bucket-index
                int di=searchinLL(key,bi); //  |  |  |  |  |   data-index
                
                if(di==-1) { //key doesn't exist,
                    return null;    
                }else {
                    Node node= buckets[bi].remove(di);
                    n--;
                    return node.value;
                }
                  
            }
            
            public V get(K key) {  //retrieve
                int bi=hashFunction(key); // -----------------
                int di=searchinLL(key,bi); //  |  |  |  |  |
                
                if(di==-1) { //key doesn't exist
                    return null;
                }else {
                    Node node= buckets[bi].get(di); 
                    return node.value;     //key exist
                }
            }
            
            public ArrayList<K> keySet(){  //gives set of key:value
                ArrayList<K> keys=new ArrayList<>();
                
                for(int i=0;i<buckets.length;i++) { //bi 
                    LinkedList<Node> ll=buckets[i];
                    for(int j=0;j<ll.size();j++) {
                        Node node=ll.get(j);
                        keys.add(node.key);
                    }   
                }
                return keys;   
            }
            
            public boolean isEmpty() {
                return n==0;
            }
        }
        
        public static void main(String[] args) {
            HashMap<String,Integer> map=new HashMap<>();
            map.put("India",190);
            map.put("China",200);  //insert values
            map.put("US",50);
            
            ArrayList<String> keys = map.keySet(); //print values
            for(int i=0; i<keys.size(); i++) {
                System.out.println(keys.get(i)+" : "+map.get(keys.get(i))); //keys:value print
            }

            map.remove("India");
            System.out.println(map.get("India"));
        }
        

}
