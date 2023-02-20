package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxChainLength {
    
    public static void main(String args[]) { //O(nlogn)
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
            //sorting   
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int prevEnd = pairs[0][1]; //last selected pair end //chain end 
        
        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0] > prevEnd) {
                chainLen++;
                prevEnd = pairs[i][1]; //update
            }
        }

        System.out.println("max chain length = "+ chainLen);
    }
}