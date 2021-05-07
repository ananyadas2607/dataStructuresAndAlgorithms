package Pepcoding.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> h=new HashSet<>();
        for(int ele:nums1){
            h.add(ele);
        }
        ArrayList<Integer> al=new ArrayList<>();
        for(int ele:nums2){
            if(h.contains(ele)){
                al.add(ele);
                h.remove(ele);
            }
        }
        int[] res=new int[al.size()];
        int i=0;
        for(int ele: al){
            res[i]=ele;
            i++;
        }
        return res;

    }
}
