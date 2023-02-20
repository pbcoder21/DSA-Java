package Search_Algo;   //https://leetcode.com/problems/search-in-rotated-sorted-array/

public class BS_LC33 { //search-in-rotated-sorted-array
            
        public static void main(String[] args) {
                int[] nums= {4,5,6,7,0,1,2,3};
                System.out.println(findPivot(nums));
            }
        
        int search(int[] nums, int target) {
            int pivot=findPivot(nums);
            //if pivot is not found the array is not rotated
            if(pivot==-1) {
                //just do normal BS
                return binarySearch(nums,target, 0, nums.length-1);
            }
            //if pivot is found, you have found 2 asc sorted array            
            if(nums[pivot]==target) {
                return pivot;
            }
            if(nums[0]<=target) {
                return binarySearch(nums, target, 0, pivot-1);
            }
            return binarySearch(nums, target, pivot+1, nums.length-1);
        }

        int binarySearch(int[] nums,int target, int s, int e) {
            while(s<=e) {
                int m=s+(e-s)/2;  //mid
                
                if(nums[m]<target) { //right side search
                    s=m+1;  
                }
                else if(nums[m]>target){
                    e=m-1;  //left side search
                }else {
                    return m;
                }
            }
            return -1;              
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







