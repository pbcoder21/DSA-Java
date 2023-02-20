package Recursion;

public class RemoveDupl {

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        if(idx == str.length()) { //BC (end)
            System.out.println(newStr);
            return;
        }
    
        //kaam
        char currChar = str.charAt(idx); //current char
        if(map[currChar-'a'] == true) { //idx of map
                //duplicate present, go for next char
            removeDuplicates(str, idx+1, newStr, map);
        }             //no append as duplicate char present, so go to next char
        else {        
            map[currChar-'a'] = true; //duplicate not present, make true for new
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }                //append as new char is coming, now go to next char
    }
    
    public static void main(String[] args) {
        String str="appnncollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
    
}