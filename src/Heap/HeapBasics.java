package Heap;

import java.util.ArrayList;

public class HeapBasics {
    
    static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();
        
        //ADD IN A HEAP
        public void add(int data) { //O(logn)
            //step1: add at last idx
            arr.add(data);
            
            int x = arr.size()-1; //x is child idx
            int parent = (x-1)/2; // parent idx
            
            //step2: fix heap
                 //child val < parent val
            while(arr.get(x) < arr.get(parent)) { //O(logn) // > for maxHeap
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
                
                x = parent; //update value //child=parent
                parent = (x-1)/2;
            }          
            
        }
        
        public int peek() {
            return arr.get(0);
        }
        
        private void heapify(int i) {
            int leftc = 2*i+1;
            int rightc = 2*1+2;
            int minIdx = i;
            
            if(leftc < arr.size() && arr.get(minIdx) > arr.get(leftc)) { // < for maxHeap
                minIdx = leftc;
            }
            if(rightc < arr.size() && arr.get(minIdx) > arr.get(rightc)) { // < for maxHeap
                minIdx = rightc;
            }
            if(minIdx!=i) { //root is not min
                //swap   //root is changed then swap
                int temp=arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                
                heapify(minIdx);           
            }                      
        }
        
        //DELETE IN A HEAP
        public int remove() {
            int data=arr.get(0);
            
            //step1: swap first and last node //O(1)
            int temp=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1  , temp);
            
            //step2: delete last //O(1)
            arr.remove(arr.size()-1);
            
            //step3: fix heap => heapify //O(logn)
            heapify(0); //calls heapify function
            return data;
        }
    
        public boolean isEmpty() {
            return arr.size()==0;
        }
    }
    
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        
        while(!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();               
        }       
    }
}
