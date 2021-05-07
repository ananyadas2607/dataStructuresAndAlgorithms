package Pepcoding.Heap;

import java.util.PriorityQueue;

public class leetcode703 {
    int K=0;
    PriorityQueue<Integer> pq=new PriorityQueue<>();

    public void KthLargest(int k, int[] nums) {
        this.K=k;
        for(int ele:nums){
            this.pq.add(ele);
            if (this.pq.size() > this.K)
                this.pq.remove();
        }


    }

    public int add(int val) {
        this.pq.add(val);
        if (this.pq.size() > this.K)
            this.pq.remove();

        return this.pq.peek();
    }
}
