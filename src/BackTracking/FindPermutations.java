package BackTracking;

public class FindPermutations {
    
    public static void findPermutation(String str, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i); //1st choice a,b,c
            String leftpart = str.substring(0,i);
            String rightpart = str.substring(i+1);
            String newStr=leftpart+rightpart;
            findPermutation(newStr, ans+curr);
        }
    } 

    public static void main(String args[]) {
        String str = "abc";
        findPermutation(str, "");
    }
}