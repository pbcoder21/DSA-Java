package Greedy;

import java.util.*;

public class ActivitySelection {
    
    public static void main(String args[]) { //O(n)
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

         //If activites were not sorted according to end time
        // O(N^2) earlier it is not sorted, go frwd then back and check overlapping
         int activity[][] = new int[start.length][3];
         for(int i=0; i<start.length; i++) {
             activity[i][0] = i; //index    //defining the activity table
             activity[i][1] = start[i];
             activity[i][2] = end[i];
         }

        // //lambda function->shortform  //sorting basis on 2nd col
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));
        
        int maxAct=0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        //1st activity
        maxAct=1;
        ans.add(activity[0][0]);
        int lastEnd = activity[0][2];

        for(int i=1; i<end.length; i++) {
            if(activity[i][1] >= lastEnd) {
                //activity select
                maxAct++;
                ans.add(activity[i][0]);
                lastEnd = activity[i][2];
            }  
        }
        System.out.println("Total : "+maxAct);

        //print As
        for(int i=0; i<ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" " );
            System.out.println(start[ans.get(i)] + "-" + end[ans.get(i)]);
        }
        
//----------------------------------------------------------------------------------------------
        
        //End time basis sort  // O(N) as it is sorted
//        int maxAct=0;
//        ArrayList<Integer> ans = new ArrayList<>();
//        
//        //1st activity
//        maxAct=1;
//        ans.add(0);
//        int lastEnd = end[0];
//
//        for(int i=1; i<end.length; i++) {
//            if(lastEnd <= start[i]) {
//                //activity select
//                maxAct++;
//                ans.add(i);
//                lastEnd = end[i]; //next
//            }  
//        }
//        System.out.println("Total : "+maxAct);
//
//        //print As
//        for(int i=0; i<ans.size(); i++) {
//            System.out.print("A"+ans.get(i)+" " );
//            System.out.println(start[ans.get(i)] + "-" + end[ans.get(i)]);
//        }
    }
}