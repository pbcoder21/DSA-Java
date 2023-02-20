package Queue;

import java.util.*;

public class Interleave {
    public static void interleave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int sz = q.size();
        
        for(int i=0; i<sz/2; i++) {
            //add first half element in first queue
            firstHalf.add(q.remove()); //jo q se remove honga usko add karoo firstHalf queue me
        } 

        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove()); //from 1st queue
            q.add(q.remove()); //then from 2n queue
        } //do alternate addition
    }
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interleave(q);

        while(!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }
        System.out.println();
    }
}

// 1 2 3 4 5 6 7 8 9 10
// 1 6 2 7 3 8 4 9 5 10 