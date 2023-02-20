package Search_Algo;

public class BS_LC744 {

//--------------------------------------------------------------------------
    public char nextGreatestLetter(char[] letters, char target) {
      
        int si=0;            //lowest val
        int ei=letters.length-1;  //highest val
      
        while(si<=ei) {
            
            //int mi=(li+hi)/2;   //(this might exceed int range
            int mi=si+(ei-si)/2;  //mid val
      
            if(letters[mi]<target) {   //Ascending array sorted concept
                si=mi+1;  //right side search
            }
            else { 
                ei=mi-1;  //left side search         
            }   
        }
        return letters[si%letters.length];  //Not Found
    } 
}