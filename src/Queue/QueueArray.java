package Queue;

//queue using array
public class QueueArray {
    
     static class Queue {
         static int arr[];
         static int size;
         static int rear;

         Queue(int size) {
             this.size = size;
             arr = new int[size];
             rear = -1;
         }

         public static boolean isEmpty() {
             return rear == -1;
         }
    
         public static void add(int data) {
             if(rear == size-1) { //checks if arr is initally full
                 System.out.println("Queue is Full");
                 return;
             }
             rear=rear+1; //-1 to 0th index
             arr[rear]=data; //add data
         }    
                     //O(n)
         public static int remove() {
             if(isEmpty()) { //checks if arr is initally empty
                 System.out.println("Queue is Empty");
                 return -1;
             }
             int front = arr[0];
             for(int i=0; i<rear; i++) {
                 arr[i] = arr[i+1]; // <---
             }
             rear=rear-1;
             return front;
         }

         public static int peek() {
             if(isEmpty()) {
                 System.out.println("Queue is Empty");
                 return -1;
             }
             return arr[0];
         }
     }
     public static void main(String args[]) {
         Queue q = new Queue(5);
         q.add(1);
         q.add(2);
         q.add(3);
         
         while(!q.isEmpty()) {
             System.out.println(q.peek());
             q.remove();
         }
         //System.out.println(q.remove());
         //System.out.println(q.peek());
     }
}
