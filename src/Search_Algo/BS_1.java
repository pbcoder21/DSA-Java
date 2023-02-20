package Search_Algo;  //Kunal Kushwaha     

public class BS_1 {

    public static void main(String[] args) {
    //Order Agnostic
        int[] a= {0,8,9,12,14,15,18};
        int srch=18;
        int ans=binarySearchAgnostic(a,srch); //recursion
        System.out.println(ans);
    }    
    //return the index
    //return -1 if it does not exist
    static int binarySearchAgnostic(int[] a,int srch) {
        
        int li=0;            //lowest val
        int hi=a.length-1;  //highest val
        
        //find whether the array is sorted or not
        boolean isAsc=a[li]<a[hi];      
        while(li<=hi) {            
            //int mi=(li+hi)/2;   //(this might exceed int range
            int mi=li+(hi-li)/2;  //mid val
            
            if(a[mi]==srch) {
                return mi;
            }
            
            if(isAsc) {  //Ascending Order
                //System.out.println("Asc");
                if(a[mi]<srch) { 
                    li=mi+1;  //right side search
                }
                else { 
                    hi=mi-1;  //left side search
                }                
            }else {      //Descending Order
                //System.out.println("Desc");
                if(a[mi]<srch) {
                    hi=mi-1;  //left side search
                }
                else {
                    li=mi+1; //right side search
                }              
            }   
        }
        return -1;  //Not Found
    }
}

