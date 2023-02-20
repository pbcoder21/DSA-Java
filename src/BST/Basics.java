package BST;

import java.util.*;

import BST.PrintInRange.Node;

public class Basics {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    // INSERT IN BST
    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

         if(root.data > val) { 
                 //go to left subtree
            root.left = insert(root.left, val);
         } else { 
                 // go to right subtree
             root.right = insert(root.right, val);
         }

         return root;
    }
    
    //INORDER TRAVERSAL
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left); //left
        System.out.print(root.data+" "); //root
        inorder(root.right); //right
    }
    
    //SEARCH IN A BST
    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(root.data > key) {
            return search(root.left, key);
        }else {
            return search(root.right, key);
        }       
    }

    //DELETE A NODE IN BST
    public static Node delete(Node root, int val) {
        if(root == null) { 
            return null;
        }
 
        if(root.data > val) { // go LEFT
            root.left = delete(root.left, val);
        }

        else if(root.data < val) { //go RIGHT
            root.right = delete(root.right, val);
        }

        else {
            //case 1 - leaf node
            if(root.left == null && root.right == null) {
                return null;
            }

            //case 2 - single child
            else if(root.left == null) {
               return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            //case 3 - both child
            else {
                Node IS = inorderSuccessor(root.right); //left most node in right subtree
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }
            
       return root;
    }

    public static Node inorderSuccessor(Node root) {
        while(root.left!=null) {
            root = root.left;
        }

        return root;
    }
    
    //PRINT IN RANGE IN A BST
    public static  void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }

        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2); //print left Subtree value
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }

        else if(root.data < k1) {
            printInRange(root.left, k1, k2);
        }

        else {
            printInRange(root.right, k1, k2);
        }
    }
    
    public static void main(String args[]) {
        //int values[] = {5, 1, 3, 4, 2, 7};
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        
        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
        
        if(search(root, 3)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }

        root = delete(root, 5);
        inorder(root);
        System.out.println();
        
        printInRange(root, 4, 12);
    }
}