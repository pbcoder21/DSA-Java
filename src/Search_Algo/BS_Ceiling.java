package Search_Algo;

public class BS_Ceiling {

    public static void main(String[] args) {
        
        int[] a= {2,8,9,12,14,15,18};
        int srch=11;
        int ans=ceiling(a,srch); //recursion
        System.out.println(ans);
    }
    
    static int ceiling(int[] a,int srch) {
        
        //return -1 if srch is greater than greater no. in array
        if(srch>a[a.length-1]) {
            return -1;
        }
        
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
        return li;  //Not Found
    }
}

