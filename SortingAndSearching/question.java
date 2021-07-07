package Pepcoding.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class question {

    //Two Sum without duplicate elements and array sorted in ascending order
    public int[] twoSum_1(int[] arr, int target) {
        int si=0, ei=arr.length-1, sum=0;
        while(si<=ei){
            sum = arr[si]+arr[ei];
            if(sum==target)
                return new int[]{si+1,ei+1};
            else if(sum>target)
                ei--;
            else
                si++;
        }
        return new int[]{0};
    }

    //Two Sum with duplicate elements and array sorted in ascending order
    public List<List<Integer>> twoSumWithoutRange(int[] arr, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        int si=0, ei=arr.length-1, sum=0;
        while(si<ei){
            sum=arr[si]+arr[ei];
            if(sum== target){
                ans.add(Arrays.asList(arr[si], arr[ei]));
                si++;
                ei--;
                while (si < ei && arr[si] == arr[si - 1])
                    si++;
                while (si < ei && arr[ei] == arr[ei + 1])
                    ei--;
            }
            else if (sum < target)
                si++;
            else
                ei--;
        }
        return ans;
    }

    //Two Sum with duplicate elements and array sorted in ascending order with range
    public List<List<Integer>> twoSum(int[] arr, int target, int si, int ei) {
        List<List<Integer>> ans=new ArrayList<>();
        int  sum=0;
        while(si<ei){
            sum=arr[si]+arr[ei];
            if(sum== target){
                List<Integer> smallAns=Arrays.asList(arr[si], arr[ei]);
                ans.add(smallAns);
                si++;
                ei--;
                while (si < ei && arr[si] == arr[si - 1])
                    si++;
                while (si < ei && arr[ei] == arr[ei + 1])
                    ei--;
            }
            else if (sum < target)
                si++;
            else
                ei--;
        }
        return ans;
    }

    public void prepareAns(List<List<Integer>> ans, List<List<Integer>> smallAns, int fixEle) {
        for (List<Integer> arr : smallAns) {
            List<Integer> ar = new ArrayList<>();
            ar.add(fixEle);
            for (int ele : arr)
                ar.add(ele);
            ans.add(ar);
        }
    }
    public List<List<Integer>> threeSum(int[] arr, int target, int si, int ei) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=si;i<ei;){
            List<List<Integer>> smallAns=twoSum(arr,target-arr[i],i+1,ei);
            prepareAns(ans, smallAns, arr[i]);
            i++;
            while (i < ei && arr[i] == arr[i - 1])
                i++;
        }
        return ans;
    }

    public List<List<Integer>> fourSum(int[] arr, int target, int si, int ei) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = si; i < ei;) {
            List<List<Integer>> smallAns = threeSum(arr, target - arr[i], i + 1, ei);
            prepareAns(ans, smallAns, arr[i]);
            i++;
            while (i < ei && arr[i] == arr[i - 1])
                i++;
        }

        return ans;
    }

    public List<List<Integer>> kSum(int[] arr, int target, int k, int si, int ei) {
        if (k == 2)
            return twoSum(arr, target, si, ei);

        List<List<Integer>> ans = new ArrayList<>();
        while(si<ei) {
            List<List<Integer>> smallAns = kSum(arr, target - arr[si], k - 1, si + 1, ei);
            prepareAns(ans, smallAns, arr[si]);
            si++;
            while (si < ei && arr[si] == arr[si - 1])
                si++;
        }

        return ans;
    }

    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = kSum(arr, target, 4, 0, n - 1);

        return ans;
    }

    //Two Sum Count
    public int twoSumCount(int[] nums1, int[] nums2, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int ele:nums1)
            map.put(ele,map.getOrDefault(ele,0)+1);

        int count=0;
        for(int ele:nums2)
            if(map.containsKey(target-ele))
                count+=map.get(target-ele);
        return count;
    }

    //Four sum count
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int ele1: nums1){
            for(int ele2: nums2){
                map.put((ele1+ele2),map.getOrDefault(ele1+ele2,0)+1);
            }
        }
        int count=0, target=0;
        for(int ele1: nums3){
            for(int ele2:nums4){
                if(map.containsKey(target-(ele1+ele2)))
                    count+=map.get(target-(ele1+ele2));
            }
        }
        return count;
    }

    //Four Sum Count with extra space
    int fourSumCount_02(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums1.length, idx = 0;
        int[] A = new int[n * n];
        int[] B = new int[n * n];

        for (int e1 : nums1)
            for (int e2 : nums2)
                A[idx++] = e1 + e2;

        idx = 0;
        for (int e1 : nums3)
            for (int e2 : nums4)
                B[idx++] = e1 + e2;

        return twoSumCount(A, B, 0);
    }


    public static void main(String[] args){

    }

}
