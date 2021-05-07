package Pepcoding.HashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> m=new HashMap<>();

        for(int ele:nums1){
            m.put(ele,m.getOrDefault(ele,0)+1);
        }
        int k=0;
        for(int ele:nums2){
            int cnt=m.getOrDefault(ele,0);
            if(cnt > 0){
                nums1[k++] =ele;
                m.put(ele,cnt-1);
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }

    //SolutionByRajneesh
    public static int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }
        HashMap<Integer, Integer> m=new HashMap<>();

        for(int ele:nums1){
            m.put(ele,m.getOrDefault(ele,0)+1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele:nums2){
            int cnt=m.getOrDefault(ele,0);
            if(cnt !=0){
                ans.add(ele);
                m.put(ele, cnt-1 );
                if(cnt==0)
                    m.remove(ele);
            }
        }

        System.out.println(ans);
        int[] res=new int[ans.size()];
        int i=0;
        for(int ele: ans){
            res[i]=ele;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1={4,9,5};
        int[] nums2 = {9,4,9,8,4};
        intersect1(nums1,nums2);
    }

}
