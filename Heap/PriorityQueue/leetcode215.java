package Pepcoding.Heap.PriorityQueue;

import java.util.PriorityQueue;

public class leetcode215 {
    //TC:O(NlogK) ---> if k>n then this works ow this will give TLE
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int ele:nums){
            pq.add(ele);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a; //max PQ
        });
        for(int ele:nums){
            pq.add(ele);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void downHeapify(int[] arr, int pi, int li){
        int maxIdx=pi, lci=2*pi +1, rci=2*pi+2;
        if(lci<=li && arr[lci] >arr[maxIdx])
            maxIdx=lci;
        if(rci<=li && arr[rci] >arr[maxIdx])
            maxIdx=rci;
        if (maxIdx != pi) {
            swap(arr, pi, maxIdx);
            downHeapify(arr, maxIdx, li);
        }
    }
    //O(N + KlogN) tends to O(N)
    public int findKthLargest_Btr(int[] nums, int k) {
        int li=nums.length-1;
        for(int i=li;i>=0;i--)
            downHeapify(nums, i, li);
        while(k-->1){
            swap(nums,0, li--);
            downHeapify(nums,0,li);
        }
        return nums[0];
    }




}
