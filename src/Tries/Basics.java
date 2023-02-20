package Tries;

public class Basics {
    
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
    
    public static void main(String[] args) {
        
        String words[] = {"the", "a", "there", "their", "any"};
        
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        
        System.out.println(search("their"));
        System.out.println(search("thor"));
        System.out.println(search("an"));    
     
    }
}
     
    
    
   
