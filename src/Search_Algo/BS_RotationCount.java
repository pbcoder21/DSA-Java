package Search_Algo;

public class BS_RotationCount {

        public static void main(String[] args) {
            int nums[]= {4,5,6,7,0,1,2};
            System.out.println(countRotations(nums));   
        }
        
        private static int countRotations(int[] nums) {
            int pivot=findPivot(nums);
            return pivot+1;
        }
        
      //this will not work in duplicates
        static int findPivot(int[] nums) {
            int s=0;
            int e=nums.length-1;
            
            while(s<=e) {
                int m=e+(e-s)/2;
                //4 cases
                if(m<e && nums[m]>nums[m+1]) { //m<e is for not exceed out of bound
                    return m;
                }
                if(s<m && nums[m-1]>nums[m]) { //both exp should be true
                    return m-1;
                }
                if(nums[s]>=nums[m]) {
                    e=m-1;
                }else {
                    s=m+1;
                }
            }
            return -1;
        }
        
        //this will work in duplicate values
        static int findPivotWithDuplicates(int[] nums) {
            int s=0;
            int e=nums.length-1;
            
            while(s<=e) {
                int m=e+(e-s)/2;
                //4 cases
                if(m<e && nums[m]>nums[m+1]) { //m<e is for not exceed out of bound
                    return m;
                }
                if(s<m && nums[m-1]>nums[m]) { //both exp should be true
                    return m-1;
                }
                //if elements at m,e,s are same, skip the duplicate
                if(nums[m]==nums[s] && nums[m]==nums[e]) {
                    //skip the duplicates
                    //NOTE: what if elements at s and e were pivot?
                    //check if s is pivot
                    if(nums[s]>nums[s+1]) {
                        return s;
                    }
                    s++;
                    
                    //check e is pivot
                    if(nums[e]<nums[e-1]){
                        return m-1;
                    }
                    e--;
                }
                //left side sorted , so pivot should be in right
                else if(nums[s]<nums[m] || (nums[s]==nums[m]) && nums[m]>nums[e]){
                    s=m+1;
                }
                else {
                    e=m-1;   
              }        
            }
            return -1;
        }        
        
    }
    
