package BinaryTree;

import java.util.*;

import BinaryTree.Basics2.Node;

public class LowestCommonAncestor {
     
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
            //ROOT to NODE path
    public static boolean getPath(Node root, int n, ArrayList<Node> path) { //O(n)
        if(root == null) {       //root ---> n path nikalna hai
            return false;
        }

        path.add(root); 

        if(root.data == n) { //node mill gayi
            return true;  //dont go into subtrees
        }
        
        //if node not found, find in subTrees
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        
        if(foundLeft || foundRight) { //both T
            return true;
        }
        
        //if not found in leftSubTree and rightSubTree
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) { //O(n)
        ArrayList<Node> path1 = new ArrayList<>(); //AL me node store
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        //last common ancestor
        int i = 0;
        for(; i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) { //till path1 == path2 , if not equal break
                break;
            }
        }

        //last equal node -> i-1th
        Node lca = path1.get(i-1); //this is last equal value
        return lca;
    }

    //Approach 2 - Find first node which found n1 & n2 in it's subtrees
    //constant space(not extra space) //O(n)
    public static Node lca2(Node root, int n1, int n2) { 
        if(root == null) {
            return null;
        }

        if(root.data == n1 || root.data == n2) { //both T
            return root; //becomes lca
        }

        Node leftFound = lca2(root.left, n1, n2); //check if LCA exits in leftSubTree
        Node rightFound = lca2(root.right, n1, n2); //check if LCA exits in rightSubTree
        
        if(leftFound == null) { //not in leftSubtree
            return rightFound; //so. it is in rightSubtree
        }
        if(rightFound == null) {
            return leftFound;
        }
            
        return root;
       
    }
    
    public static void main(String args[]) {
        /*
                    1
                   / \
                  2   3 
                 / \ / \
                4  5 6  7   
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //System.out.println(lca(root, 4, 5).data);
        //BEST APROACH 2
        
        Node lca = lca2(root, 4, 4);
        if(lca != null)
            System.out.println(lca.data);
    }
}