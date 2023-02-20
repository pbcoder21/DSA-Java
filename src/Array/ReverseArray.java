package Array;

public class ReverseArray {
    
    public static void reverse(int nums[]){
        int s=0,e=nums.length-1;
        
        while(s<e) {
            //swap
            int temp=nums[e];
            nums[e]=nums[s];
            nums[s]=temp;
            
            s++;
            e--;
        }
    }
    
    public static void main(String[] args) {
        int nums[]= {2,3,4,5,6};
        
        reverse(nums);
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
        System.out.println();   
    }

}
