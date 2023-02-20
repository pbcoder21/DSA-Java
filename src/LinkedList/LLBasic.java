package LinkedList;

public class LLBasic {
     
        public static class Node {
           int data;
           Node next;
     
           Node(int data) {
               this.data = data;
               this.next = null;
               //size++;
           }
        }
       
        public static Node head;
        public static Node tail;
        public static int size;
         
        public void addFirst(int data) { //O(1)
            Node newNode = new Node(data);
            size++;
            if(head == null) {
                head = tail = newNode;
                return;
            }
              
            newNode.next = head;
            head = newNode;
        }   
         
        public void addLast(int data) { //O(1)
            Node newNode = new Node(data);
            size++; 
            if(head == null) {
                head = tail = newNode;
                return;
            }
         
            Node lastNode = head;
            while(lastNode.next != null) { 
                lastNode = lastNode.next;
            }
         
            lastNode.next = newNode;
               //tail.next=newNode;
               //tail=newNode;
        }
           
        public void addMiddle(int idx,int data) {  //O(n)
            if(idx==0) {
                addFirst(data);
                return;
            }
            Node newNode = new Node(data);
            size++;
            Node temp=head;
            int i=0;
               
            while(i<idx-1) {
                temp=temp.next;
                i++;
            }
               //i=idx-1 , temp --> prev
            newNode.next=temp.next;
            temp.next=newNode;            
        }
         
        public int removeFirst() {
            if(size==0) {
                System.out.println("LL is empty");
                return Integer.MIN_VALUE;
            }else if(size==1) {
                Integer val=head.data;
                head = tail = null;  
                size=0;
                return val;
            }
            Integer val=head.data;
            head=head.next;
            size--;
            return val;
        }
         
        public int removeLast() {
            if(size==0) {
                System.out.println("LL is empty");
                return Integer.MIN_VALUE;
            }else if(size==1) {
                int val = head.data;
                head=tail=null;
                size=0;
                return val;
            }
                 //prev : i =size-2
            Node prev=head;
            for(int i=0;i<size-2;i++) {
                prev=prev.next;
            }    
            int val=prev.next.data; //tail.data
            prev.next=null;
            tail=prev;
            size--;
            return val;
        } 
        
        //SEARCH FOR A KEY IN LL
        //ITERATIVE
        public int itrSearch(int key) { //return position of val
            Node temp=head;
            int i=0;
            while(temp!=null) {
                if(temp.data==key) { //key found
                    return i;
                }
                temp=temp.next;
                i++;  
            }
            return -1;  //key not found
        }
               
      //SEARCH FOR A KEY IN LL
      //RECURSION  //O(n)
        public int helper(Node head, int key) {
            if(head==null) { //Base Condition
                return -1;
            }
            if(head.data==key) {
                return 0;
            }
            int idx=helper(head.next, key);
            if(idx==-1) {
                return -1;
            }
            return idx+1;    
        }
        
        public int recSearch(int key) {
            return helper(head,key);
        }
 //-------------------------------------------------------------------------------------------------------------      
        //REVERSE LL
        //ITERATIVE APPROACH
        public void reverse() {
            Node prev=null;
            Node curr=tail=head;
            Node next;
            
            while(curr!=null) {
                next=curr.next; //currentSituation
                curr.next=prev; //Do it mapping backwards
                //update
                prev=curr; //move forwards
                curr=next;
            }
            head=prev;
        }
        
        //RECURSIVE
        public Node reverseRecursive(Node head) {
            if(head==null || head.next==null) {
                return head;
            }
            Node newHeadNode=reverseRecursive(head.next);
            head.next.next=head;
            head.next=null;
            return newHeadNode;
        }
//-------------------------------------------------------------------------------------------------------------------------       
        //Find & Remove Nth node from END
        //ITERATIVE O (n)  //TC:O(n), SC:O(1)
        public void deleteNthfromEnd(int n) {
            //calculate size
            int sz=0;
            Node temp=head;
            while(temp!=null) {
                temp=temp.next;
                sz++;
            }
            if(n==sz) { //if n=1 and sz=1 ,then remove Head
                head=head.next; //removeFirst
                return;
            }
            //sz-n
            int i=1;
            int iToFind=sz-n; //delete node ke 1node pehle
            Node prev=head;
            while(i<iToFind) { //1<2, now points 2nd node, dlt 3rdnode i.e next to 2nd node
                prev=prev.next;
                i++;
            }
            prev.next=prev.next.next; //dlt 3rdnode i.e next to 2nd node
            return;
        }
        
        //MIDDLE of LL
        public Node getMiddle(Node head) {
            Node fast = head;
            Node slow = head;
            while (fast!= null && fast.next!= null) {
                slow = slow.next; //1 jump
                fast = fast.next.next;  //2 jump
            }
            return slow; //gets mid
         }
          
         //PALINDROME // TC:O(n), SC:O(1)
         public boolean isPalindrome() {
            if(head == null || head.next == null) { //BC
                return true;
            }         
                //1.find middle
            Node mid = getMiddle(head);
                //2.reverse 2nd half
            Node prev=null; 
            Node curr=mid;  //for 2nd half 
            while(curr!=null) {
                Node next=curr.next; //currentSituation
                curr.next=prev; //Do it mapping backwards
                prev=curr; //update
                curr=next; //move forwards
            }
            
            Node right=prev; //points to null
            Node left=head;
                //3.checks if equal
            while(right!= null) {
                if(left.data!=right.data) {
                    return false;
                }
                left=left.next;
                right=right.next;
            }
            return true;
         }
//------------------------------------------------------------------------------------------------------------------------------         
         //DETECT CYCLE IN LL
         public static boolean isCycle() {
             Node slow=head;
             Node fast=head;
             
             while(fast!=null && fast.next!=null) {
                 slow=slow.next; //+1
                 fast=fast.next; //+2
                 if(slow==fast) {
                     return true; //cycle exits
                 }
             }
             return false; //cycle not exist            
         }
//---------------------------------------------------------------------------------------------------------------------------         
         //REMOVE CYCLE IN LL
         public static void removeCycle() {
             //detects cycle
             Node slow=head;
             Node fast=head;
             boolean cycle=false;
             while(fast!=null && fast.next!=null) {
                 slow=slow.next;
                 fast=fast.next;
                 if(fast==slow) {
                    cycle=true;
                    break;
                 }
             }
             if(cycle==false) {
                 return;
             }
             //find meeting points
             slow=head;
             Node prev=null; //last node
             while(slow!=fast) {
                 prev=fast;
                 slow=slow.next;
                 fast=fast.next;
             }
             //remove cycle //prev of fast node
             prev.next=null;
         }
 //------------------------------------------------------------------------------------------------------------------  
        //MERGE-SORT
         private static Node getMid(Node head) {
             Node slow=head;
             Node fast=head.next; 
             while(fast!=null && fast.next!=null) {
                 slow=slow.next;
                 fast=fast.next.next;
             }
             return slow; //gets mid: 1st half ka last node    
         }
         
         private static Node merge(Node headL, Node headR) {
             Node mergedLL=new Node(-1);
             Node temp=mergedLL;
             
             while(headL!=null && headR!=null) {
                 if(headL.data<=headR.data) {
                     temp.next=headL;
                     headL=headL.next;
                     temp=temp.next;
                 }else {
                     temp.next=headR;
                     headR=headR.next;
                     temp=temp.next;
                 }
             }
             while(headL!=null) {
                 temp.next=headL;
                 headL=headL.next;
                 temp=temp.next;
             }
             while(headR!=null) {
                 temp.next=headR;
                 headR=headR.next;
                 temp=temp.next;
             }
             return mergedLL.next;
         }
         
         //MERGE_SORT LL
         public static Node mergeSort(Node head) {
             if(head==null || head.next==null) { //BC
                 return head;
             }
             //find mid
             Node mid=getMid(head);
             //left & right
             Node rightHead=mid.next;
             mid.next=null;
             Node newLeft=mergeSort(head);
             Node newRight=mergeSort(rightHead);
             //merge
             return merge(newLeft,newRight);        
         }
//---------------------------------------------------------------------------------------------------------------------------
        //PRINT LL
        public void printList() { //O(n)
            Node temp = head;
            
            while(temp != null) {
                System.out.print(temp.data+" -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
         
        public static void main(String args[]) {
            LLBasic list = new LLBasic();
            list.addFirst(5);
            list.addLast(2);
            list.addLast(3);
            list.addLast(7);
            list.addLast(1);
            list.printList(); //1->2->3->4->5
            //System.out.println(list.recSearch(3));
           //System.out.println(list.itrSearch(3)); //search for val
           //System.out.println(list.itrSearch(10));
            //System.out.println(list.size); 
            //list.reverse();
            //list.head=list.reverseRecursive(list.head);
            //list.deleteNthfromEnd(3);
            //System.out.println(isCycle());
            //System.out.println(list.isPalindrome());
    //      list.removeFirst();
    //      list.printList();
            list.head=list.mergeSort(list.head);
    //      list.removeLast();
          list.printList();
            
            //for isCycle
//           head=new Node(1);
//           head.next=new Node(2);
//           head.next.next=new Node(3);
//           head.next.next.next=head;
           
            
        }
}
