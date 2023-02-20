package BinaryTree;

import java.io.NotActiveException;
import java.util.ArrayList;

public class Basics2 {
    
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    //HEIGHT OF A TREE //O(n)
    public static int height(Node root) {
        if(root == null) {
             return 0;
         }

         int lh = height(root.left);
         int rh = height(root.right);
         return Math.max(lh, rh) + 1;
    }
    
    //COUNT OF A TREE //O(n)
    public static int count(Node root) {
         if(root == null) {
             return 0;
         }

         int leftCount = count(root.left);
         int rightCount = count(root.right);
         return leftCount + rightCount + 1;
    }

    //SUM OF A TREE //O(n)
    public static int sum(Node root) {
         if(root == null) {
             return 0;
         }

         int leftSum = sum(root.left);
         int rightSum = sum(root.right);
         return leftSum + rightSum + root.data;
    }

    //DIAMETER OF A TREE  //O(N^2) //Inefficient use 2nd Approach
    public static int diameter(Node root) { 
         if(root == null) {
             return 0;
         }

         int leftDiam = diameter(root.left); //O(n)
         int leftHt = height(root.left); // O(n)
         int rightDiam = diameter(root.right);
         int rightHt = height(root.right);

         int selfDiam = leftHt + rightHt + 1;

         return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }
    
    //DIAMETER OF A TREE  //2nd Approach
    static class Info {
         int diam;
         int ht;

         public Info(int diam, int ht) {
             this.diam = diam;
             this.ht = ht;
          }
    }
    
    public static Info diameter2(Node root) {//O(n)
         if(root == null) {
             return new Info(0, 0);
         }
         Info leftInfo = diameter2(root.left);
         Info rightInfo = diameter2(root.right);

         int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
         int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

         return new Info(diam, ht);
    }

    //SUBTREE OF ANOTHER TREE
        //FIND IDENTICAL
    public static boolean isIdentical(Node node, Node subRoot) { //checks 2 subtree identical or not
         if(node == null && subRoot == null) { //identical
             return true;
         } 
         else  //non identical
             if(node == null || subRoot == null || node.data != subRoot.data) {
             return false;
         }

         if(!isIdentical(node.left, subRoot.left)) { //lsubtree -> non identical
             return false;
         }
         if(!isIdentical(node.right, subRoot.right)) { //rsubtree -> non identical
             return false;
         }
         
         return true;
     }
     
    public static boolean isSubtree(Node root, Node subRoot) {  //finds subroot kaha hai in main tree
         if(root == null) {
             return false;
         }
         if(root.data == subRoot.data) { //compare, matched, then call isIdentical
             if(isIdentical(root, subRoot)) { //check rest subTree
                 return true;
             }
         }
         
         boolean leftAns = isSubtree(root.left, subRoot); // checks in leftSubtree -> true
         boolean rightAns = isSubtree(root.right, subRoot); //checks in rightSubtree
         
         return leftAns || rightAns;
    }

    static class Info1 {
        Node node;
        int hd;

        public Info1(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    //Kth LEVEL OF A TREE
    public static void KLevel(Node root, int level, int k) {
        if(root == null) {
            return;
        }
        
        if(level == k) {
            System.out.print(root.data+" ");
            return;
        }

        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

    //LOWEST COMMON ANCESTOR
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
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

    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        //leftLCA=val rightLca = null
        if(rightLca == null) {
            return leftLca;
        }
        if(leftLca == null) {
            return rightLca;
        }

        return root;        
    }
    
    //MIN. DISTANCE BETWEEN NODES
    public static int lcaDist(Node root, int n) {
        if(root == null) { //node doesnt exist
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist+1;
        } else {
            return leftDist+1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int KAncestor(Node root, int n, int k) {
        if(root == null) { 
            return -1;
        }
        if(root.data == n) {
            return 0;
        }

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if(max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int transform(Node root) {
        if(root == null) {
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;
        
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void main(String args[]) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7   

                expected sum tree is :
                    
                    27
                   /  \
                  9    13
                 / \   / \
                0   0 0   0 
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        /**
                  2
                 / \
                4   5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        
        System.out.println("Height : "+height(root));
        System.out.println("Count : "+count(root));
        System.out.println("Sum : "+sum(root));
        //System.out.println("Diameter : "+diameter(root));
        System.out.println("Diameter : "+diameter2(root).diam);
        
        System.out.println("Subtree Identical : "+isSubtree(root, subRoot));

    }
}