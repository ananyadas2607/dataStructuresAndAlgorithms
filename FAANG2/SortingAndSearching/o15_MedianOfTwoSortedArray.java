package Pepcoding.FAANG2.SortingAndSearching;

import java.util.*;

public class o15_MedianOfTwoSortedArray {
    //My Solution
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3=new int[nums1.length+nums2.length];

        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);

        Arrays.sort(nums3);
        int si=0, ei=nums3.length-1, mid=0;
        double median=0.0;

            mid=(si+ei)/2;

            if(nums3.length%2!=0)
                median=nums3[mid];
            else
                median=((nums3[mid])+(nums3[mid+1]))/2.0;


        System.out.println(median);
        return median;

    }
    //Solution 1- Pepcoding
    public static double findMedianSortedArrays_1(int[] a1, int[] a2) {
        int len=a1.length+a2.length;
        int[] merged= new int[len];

        int i=0;
        int j=0;
        int k=0;
        while(i<a1.length && j<a2.length){
            if(a1[i]<a2[j]){
                merged[k]=a1[i];
                i++;
                k++;
            }
            else
            {
                merged[k]=a2[j];
                j++;
                k++;
            }
        }
        while(i<a1.length){
            merged[k]=a1[i];
            i++;
            k++;
        }
        while(j<a1.length){
            merged[k]=a2[j];
            j++;
            k++;
        }
        double median=0.0;
        int mid= merged.length/2;
        if(merged.length%2==1){
            median=merged[mid];
        }
        else{
            median=(merged[mid]+merged[mid-1])/2.0;
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums1={2};
        int[] nums2={};
        findMedianSortedArrays(nums1, nums2);
    }
}
