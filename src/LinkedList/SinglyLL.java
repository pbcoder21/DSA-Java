package LinkedList;

import java.util.Scanner;

public class SinglyLL {
    
    static class Node{
        int data;
        Node next;
        
        Node(int data){  //constructor
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    
    public void creation() { //O(1) //insert item in LL
        int data,m,n,p;
        Scanner sc=new Scanner(System.in);
        System.out.println("Singly Linked List Program");
        do {
        System.out.println("Enter data : ");
        data=sc.nextInt();
            
        Node new_node=new Node(data);
        if(head==null) {
            head=new_node;
        }
        else {
            System.out.println("Enter 1 to insert the item at beginning, 2 to insert at the end, 3 to insert at the specific location");
            m=sc.nextInt();
            switch(m) {
                case 1:  //insert at beginning
                    new_node.next=head;
                    head=new_node;
                    break;
                        
                case 2:  //insert at end
                    Node temp=head;
                    while(temp.next!=null) {
                        temp=temp.next;                        
                    }
                    temp.next=new_node;
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
                    break;
                        
                case 2:  //delete at end :  O(n) goes through the LL
                    Node temp1=head;
                    Node ptr=temp1.next;
                    while(ptr.next!=null) {
                        temp1=ptr; 
                        ptr=ptr.next;
                    }
                    temp1.next=null;
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
            while(temp!=null) {
                System.out.println(temp.data + " ");
                temp=temp.next;
            }
        }
    }
    
    public static void main(String[] args) {
        SinglyLL ll=new SinglyLL();
        ll.creation();
        ll.deletion();
        ll.traverse();
    }
    }
    
    

