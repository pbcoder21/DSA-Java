package BinaryTree;

public class Diameter {
    
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    //HEIGHT OF AT TREE
    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
        //return Math.max(height(root.left), height(root.right)) + 1;
    }

    //Approach-1 //O(n^2)
    public static int diameter(Node root) { //O(n^2)
        if(root == null) {
            return 0;
        }
        
        int leftDiam = diameter(root.left); //O(n)
        int leftHt = height(root.left); // O  (n)
        int rightDiam = diameter(root.right);
        int rightHt = height(root.right);

        int selfDiam = leftHt + rightHt + 1;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));

//        int diamRoot = height(root.left) + height(root.right) + 1;
//        int diamLeft = diameter1(root.left);
//        int diamRight = diameter1(root.right);
//        return Math.max(diamRoot, Math.max(diamLeft, diamRight));
    }   
    
    //Approach-2 //O(n)
    static class Info {
        int diam;
        int ht;        

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root) { //O(n)
        if(root == null) {
            return new Info(0, 0);
        }

        Info left = diameter2(root.left);
        Info right = diameter2(root.right);

        int diamRoot = left.ht + right.ht + 1;
        
        int diam = Math.max(diamRoot, Math.max(left.diam, right.diam));
        int ht = Math.max(left.ht, right.ht) + 1;
   
        return new Info(diam, ht);
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

        System.out.println(diameter(root));
        System.out.println(diameter2(root).diam);
    }
}