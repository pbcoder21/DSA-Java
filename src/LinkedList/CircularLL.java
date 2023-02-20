package LinkedList;  //move in forward direction

import java.util.Scanner;

public class CircularLL { 
     
    static class Node{
        int data;
        Node next;
        
        Node(int data){  //constructor
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    Node tail=null; //tail pointer to access last node
    
    public void creation() { //O(1) //insert item in LL
        int data,m,n,p;
        Scanner sc=new Scanner(System.in);
        System.out.println("Circular Linked-List Program");
        do {
        System.out.println("Enter data : ");
        data=sc.nextInt();
            
        Node new_node=new Node(data);
        if(head==null) {
            head=new_node;
            tail=new_node;
            new_node.next=head; //circular-loop
        }
        else {
            System.out.println("Enter 1 to insert the item at beginning, 2 to insert at the end, 3 to insert at the specific location");
            m=sc.nextInt();
            switch(m) {
                case 1:  //insert at beginning
                    new_node.next=head;
                    head=new_node;
                    tail.next=head; //c-loop
                    break;
                        
                case 2:  //insert at end
                    tail.next=new_node;
                    tail=new_node;
                    new_node.next=head; //c-loop
                    break;
                        
                case 3:  //insert at specific location  
                    System.out.println("Enter position of node to be inserted ");
                    p=sc.nextInt();
                    Node temp1=head;
                    for(int i=0;i<(p-1);i++) {
                        temp1=temp1.next;                           
                    }
                    new_node.next=temp1.next;
                    temp1.next=new_node;
                    tail.next=head; //c-loop
                    break;
                    }
            }
        System.out.println("Press Add:1 or Delete:2");
        n=sc.nextInt();
        }
        while(n==1);
        System.out.println();   
    }
    
    public void deletion() { //O(1) //delete item in LL
        int data,m,n,p;
        Scanner sc=new Scanner(System.in);
        System.out.println("Now Deletion");
        do {
        if(head==null) {
            System.out.println("LL is empty");
        }
        else {
            System.out.println("Enter 1 to delete the item at beginning, 2 to delete at the end, 3 to delete at the specific location");
            m=sc.nextInt();
            switch(m) {
                case 1:  //delete at beginning
                    Node temp=head;
                    temp=temp.next;
                    head=temp;
                    tail.next=head; //c-loop
                    break;
                        
                case 2:  //delete at end
                    Node temp1=head;
                    Node ptr=temp1.next;
                    while(ptr.next!=null) {
                        temp1=ptr;
                        ptr=ptr.next;
                    }
                    temp1.next=head; //c-loop
                    tail=temp1;
                    break;
                         
                case 3:   //delete at specific location
                    System.out.println("Enter position of node to be deleted ");
                    p=sc.nextInt();
                    Node temp2=head;
                    Node ptr1=temp2.next;
                    for(int i=0;i<(p-2);i++) {
                        temp2=ptr1;
                        ptr1=ptr1.next;                           
                    }
                    temp2.next=ptr1.next;
                    break;
                    }
            }
        System.out.println("Do u want to delete element.If Yes, Press:1, If No, Press:2");
        n=sc.nextInt();
        }
        while(n==1);   
    }
    
    public void traverse() {  //display  //traversal time: O(n) go till last node
        Node temp=head;
        if(head==null) {
            System.out.println("LL does not exist");
        }
        else {
            do{
                System.out.println(temp.data);
                temp=temp.next;
            }
            while(temp!=head);
        }
    }
    
    public static void main(String[] args) {
        CircularLL ll=new CircularLL();
        ll.creation();
        ll.deletion();
        ll.traverse();
    }
    }
