package Tries;

public class CountSubstrings {

    static class Node{
        Node[] child;
        boolean eow; //End of Word
        
        public Node() {
            child = new Node[26]; //a-z
            for(int i=0; i<26; i++) {
                child[i]= null;  //root is an empty node
            }
            eow = false; //initilize with false
        }  
    }
    static Node root = new Node(); //trie root node
    
    //INSERT IN A TRIE //O(L) , L= key length
    public static void insert(String word) { //the, a , there ....
        Node curr = root; //root value
        for(int i=0; i<word.length(); i++) { // t h e | a | ....
            int idx = word.charAt(i) - 'a';
            
            if(curr.child[idx] == null) {
                //add new node
                curr.child[idx] = new Node();
            }
            if(i == word.length()-1) { //i is at last val = true kardo
                curr.child[idx].eow = true;
            }
            curr = curr.child[idx]; //root update  
        }
    }
    
    //SEARCH IN  TRIE // O(L) , L= key length
    public static boolean search(String key) {
        Node curr = root;
        for(int i=0; i<key.length(); i++) { //letter one by one
            int idx = key.charAt(i) - 'a';
            Node node = curr.child[idx];
            
            if(node == null) {
                return false;
            }   
                //last node check
            if(i == key.length()-1 && curr.child[idx].eow == false) {
                return false;
            }
            curr = curr.child[idx]; // next level
        }
        return true;
    }
    
    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.child[i] != null) {
                count += countNodes(root.child[i]);
            } 
        }
        return count+1;
    }
    
    
    public static void main(String[] args) {
        
        String str = "apple";
        
        for(int i=0; i<str.length(); i++) {
            String suffix = str.substring(i);
            System.out.println(suffix);
            
            insert(suffix); //insert in trie
        }
        System.out.println("Count = "+countNodes(root));
    }
}
     
    
    
   
