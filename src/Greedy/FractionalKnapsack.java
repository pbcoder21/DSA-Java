package Greedy;

import java.util.Comparator;
import java.util.Arrays;

public class FractionalKnapsack {
    
    public static void main(String args[]) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;
 
        double ratio[][] = new double[weight.length][2]; //2D
        for(int i=0; i<weight.length; i++) {
            ratio[i][0] = i; //Oth col=> idx
            ratio[i][1] = value[i]/(double)weight[i]; //1st col=> ratio store
        }
            //sorting the ratio i.e basis on index 1
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;
         
        for(int i=ratio.length-1; i>=0; i--) { //ratio.length=3, 2->1->0
            int idx = (int)ratio[i][0];
            
            if(capacity - weight[idx] >= 0) { //pick whole item
                finalVal += value[idx];
                capacity -= weight[idx];
            } else {
                //pick fractional
                finalVal += (int)(ratio[i][1] * capacity); 
                break;
            }
        }
        System.out.println(finalVal);
    }
}