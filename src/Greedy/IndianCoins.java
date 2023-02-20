package Greedy;

import java.util.*;

public class IndianCoins {
      
    public static void main(String args[]) {
        
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int val = 590;
        
        Arrays.sort(coins, Collections.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;

        for(int i=0; i<coins.length; i++) {
            if(val >= coins[i]) {
                while(val >= coins[i]) {
                    ans.add(coins[i]);
                    count++;
                    val -= coins[i]; //update val
                }
            }
        }

        System.out.println("Count: "+count);
        
        for(int i=0;i<ans.size();i++) {
            System.out.println(ans.get(i)+"");
        }
        System.out.println();
    }
}