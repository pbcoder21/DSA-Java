package BinaryTree;
import java.util.*;

public class TopView {
    
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class QueueInfo {
        Node node;
        int hd; //horizontal distance

        public QueueInfo(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        if(root == null) {
            return;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Queue<QueueInfo> q = new LinkedList<>(); // LevelOrderTraveral / BFS
        q.add(new QueueInfo(root, 0)); //root node, null
        q.add(null); //tracks where single level is finished
        
        int min = 0, max = 0;

        while(!q.isEmpty()) {
            QueueInfo curr = q.remove(); //curr info out
            if(curr == null) {  // means, level/loop is over
                if(q.isEmpty()) {
                    break; 
                } else {
                    q.add(null); //next lvl insert again null
                }
            } else {

                //check if HD is encountered for 1st time
                if(!map.containsKey(curr.hd)) { //checks existence T/F
                    map.put(curr.hd, curr.node.data); //add it coz its 1st time
                }    //add  // key  :   value 

                if(curr.node.left != null) { //curr node ka leftchild is not null , add in queue
                    q.add(new QueueInfo(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }

                if(curr.node.right != null) {
                    q.add(new QueueInfo(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for(int i=min; i<=max; i++) {
            System.out.print(map.get(i)+" "); //map.get(i).data if <Int, Node>
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        /*   
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7  

                expected output : 4 2 1 3 7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
                    1
                   / \
                  2   3
                   \ 
                    4  
                     \
                      5
                       \
                        6 

                expected output : 2 1 3 6
        */
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.right = new Node(4);
        root2.left.right.right = new Node(5);
        root2.left.right.right.right = new Node(6);

    
        topView(root);
        topView(root2);
    }
}