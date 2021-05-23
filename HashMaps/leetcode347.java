package Pepcoding.HashMaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->{
//            return a[1]-b[1];
//        });

        //The above code can be replaced by Integer instead of int[]
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->{
            return map.get(a)-map.get(b);
        });

        for(Integer key:map.keySet()){
            //pq.add(new int[]{key, map.get(key)});
            pq.add(key);
            if(pq.size()>k)
                pq.remove();
        }

        int[] ans=new int[pq.size()];
        int i=0;
        while(pq.size()!=0){
//            int[] p=pq.remove();
//            int val=p[0];
//            int freq=p[1];
            int val=pq.remove();
            ans[i++]=val;
        }
        return ans;

    }
}
