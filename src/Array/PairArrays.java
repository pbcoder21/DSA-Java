package Array;
import java.util.Arrays;

public class PairArrays {

    public static int printPairs(int nums[]) {
        for(int i=0;i<nums.length;i++) {
            int curr=nums[i];
            for(int j=i+1;j<nums.length;j++) {
                System.out.print("("+curr+","+nums[j]+")");
            }
            System.out.println();
        }
        return 0;
    }
    public static void main(String[] args) {
        int nums[]= {2,4,6,8,10};
        System.out.println(Arrays.toString(nums));
        System.out.print(printPairs(nums));
    }
}
