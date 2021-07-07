package Pepcoding.SortingAndSearching;

import java.util.List;
import java.util.PriorityQueue;

public class practice {
    //Leetcode 658
    public static class Pair implements Comparable<Pair> {
        int val;
        int gap;

        Pair() {

        }

        Pair(int val, int gap) {
            this.val = val;
            this.gap = gap;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.gap == o.gap)
                return this.val - o.val;
            else
                return this.gap - o.gap;
        }
    }

//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//    }
}


