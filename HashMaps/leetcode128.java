package Pepcoding.HashMaps;

import java.util.HashSet;

public class leetcode128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> h=new HashSet<>();
        for(int ele: nums){
            h.add(ele);
        }
        int len=0;
        for(int ele:nums){
            if(!h.contains(ele)) continue;

            int ple=ele-1;
            int pre=ele+1;
            h.remove(ele);
            while(h.contains(ple)) {
                h.remove(ple);
                ple--;

            }
            while(h.contains(pre)){
                h.remove(pre);
                pre++;
            }
            len=Math.max(len, pre-ple-1);
        }
        return len;
    }
}
