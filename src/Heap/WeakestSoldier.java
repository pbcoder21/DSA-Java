package Heap;

import java.util.PriorityQueue;

public class WeakestSoldier {
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;
        
        public Row(int soldiers, int idx) {
            this.soldiers=soldiers;
            this.idx=idx;           
        }
        @Override
        public int compareTo(Row r2) {
            if(this.soldiers == r2.soldiers) { //if soldiers count are equal
                return this.idx - r2.idx; //compare on basis of idx
            }else {
                //if soldiers count are not same, then compare on basis of soldiers
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}};
        int k=2;
        
        PriorityQueue<Row> pq = new PriorityQueue<>();
        
        for(int i=0; i<army.length; i++) {
            int count = 0; //count soldiers
            for(int j=0; j<army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i)); //asc sort
        }
        
        for(int i=0; i<k; i++) {
            System.out.println("R"+pq.remove().idx);
        }              
        }
    }
