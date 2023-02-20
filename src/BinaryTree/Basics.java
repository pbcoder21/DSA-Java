package BinaryTree;

import java.util.*;

public class Basics {
    
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class BinaryTree{
        static int idx = -1; //idx should be update
        public static Node buildTree(int nodes[]) { //method 
            idx++; // index will keep on increasing
            if(nodes[idx] == -1) { // -1 is there, null
                return null;
            }
            
            Node newNode = new Node(nodes[idx]); 
            newNode.left=buildTree(nodes); //left subtree (recursively)
            newNode.right=buildTree(nodes); //right subtree calling
            return newNode; //
            
        }
        
        // PREORDER TRAVERSAL
        public static void preorder(Node root) { //O(n)
            if(root == null) {
                return;
            }
            System.out.print(root.data+" "); //root
            preorder(root.left); //left subtree
            preorder(root.right); // right subtree
        }
        
        // INORDER TRAVERSAL
        public static void inorder(Node root) { //O(n)
            if(root == null) {
                return;
            }
            inorder(root.left); //left subtree
            System.out.print(root.data+" "); //root 
            inorder(root.right); // right subtree
        }
        
        // POSTORDER TRAVERSAL
        public static void postorder(Node root) { //O(n)
            if(root == null) {
                return;
            }
            postorder(root.left); //left subtree 
            postorder(root.right); // right subtree
            System.out.print(root.data+" "); //root
        }
        
        //LEVEL ORDER TRAVERSAL
        public static void levelorder(Node root) { //O(n)
            if(root == null) {
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            
            while(!q.isEmpty()) { //jab tak q not gets empty, 
                Node currNode = q.remove(); //bahar nikalo currNode elem
                if(currNode==null) {
                    System.out.println(); //if curr=null,next line print
                    if(q.isEmpty()){
                        break;//if q complete empty, break
                    }else { //still element left in q
                        q.add(null); //again add null
                    }
                }else { //currNode is not null means element are present from beginning
                    System.out.print(currNode.data+" ");
                    if(currNode.left !=null) { //left child is not null
                        q.add(currNode.left); //add karlo left node ko
                    }
                    if(currNode.right !=null) { //right child is not null
                        q.add(currNode.right); //add karlo right node ko
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes); //root
    
        tree.preorder(root);
        //tree.inorder(root);
        //tree.postorder(root);
        //tree.levelorder(root);
    }

}
