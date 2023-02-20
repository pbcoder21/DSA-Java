package Search_Algo;

import javax.sql.rowset.JoinRowSet;

public class BS_LC34 {
       
//----------------------------------------------------------------------------------------------
    
    public int[] searchRange(int[] nums, int target) {
     
        int[] ans= {-1,-1};
        boolean findStartIndex;
        
        ans[0]=search(nums, target, findStartIndex=true);
        if(ans[0]!=-1) {
            ans[1]=search(nums, target, findStartIndex=false);
        }
        
        //int start=search(nums, target, findStartIndex=true);
        //int end=search(nums, target, findStartIndex=false);
        //ans[0]=start;
        //ans[1]=end;
        return ans;
    }
    
        int search(int[] nums,int target, boolean findStartIndex) {
            int ans=-1;
            int si=0;            //lowest val
            int ei=nums.length-1;  //highest val
          
            while(si<=ei) {
                
                int mi=si+(ei-si)/2;  //mid val
          
                if(nums[mi]<target) {   //Ascending array sorted concept
                    si=mi+1;  //right side search
                }else if(nums[mi]>target){ 
                    ei=mi-1;  //left side search         
                }else {
                    ans=mi;
                    if(findStartIndex) { //true: find for start
                        ei=mi-1;
                    }else {              //false: find for end
                        si=mi+1;
                    }
                }
            }
            return ans;
        }
}