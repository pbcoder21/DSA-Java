package BinaryTree;

public class SubtreeOfAnother {
    
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //FIND IDENTICAL
    public static boolean isIdentical(Node node, Node subRoot) { //checks 2 subtree identical or not
         if(node == null && subRoot == null) { //AND operator(dono null) //identical
             return true; //structure is same
         } 
         else  //non identical conditions  //OR operator(ek bhi null)
             if(node == null || subRoot == null || node.data != subRoot.data) {
             return false;
         }

         if(!isIdentical(node.left, subRoot.left)) { //leftsubtree -> gets non identical
             return false;
         }
         if(!isIdentical(node.right, subRoot.right)) { //rightsubtree -> gets non identical
             return false;
         }
         
         return true;
     }
     
    public static boolean isSubtree(Node root, Node subRoot) {  //finds subroot kaha hai in main tree
         if(root == null) {
             return false;
         }
          
         if(root.data == subRoot.data) { //compare, matched, then call isIdentical
             if(isIdentical(root, subRoot)) { //checks rest subTree
                 return true; //Yes, got it
             }
         }
         
         boolean leftAns = isSubtree(root.left, subRoot); // checks in leftSubtree -> try to compare/match root==subroot
         boolean rightAns = isSubtree(root.right, subRoot); //checks in rightSubtree
         
         return leftAns || rightAns; //returns boolean T/F (1ek me bhi true return true)
    }
    
    public static void main(String args[]) {
        /*
                    1
                   / \
                  2   3
                 / \   \
                4   5   6  
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        /**
                  2   
                 / \   
                4   5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
    }
}