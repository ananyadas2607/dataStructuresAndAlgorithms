package Pepcoding.FAANG2.SortingAndSearching;

import java.util.Scanner;

public class O12_countInversions {
    public static void main(String[] args){
        long[] arr={8,5,3,4,1,6,2};
        mergeSort(arr,0,arr.length-1);
        System.out.println(count);
    }
    public static long[] mergeSort(long[] arr, int lo, int high){
        if(lo==high){
            long[] base=new long[1];
            base[0]=arr[lo];
            return base;
        }
        int mid=(lo+high)/2;
        long[] left=mergeSort(arr, lo,mid);
        long[] right=mergeSort(arr,mid+1,high);
        long[] merged=merge2sortedArrays(left, right);

        return merged;
    }
    static int count=0;
    public static long[] merge2sortedArrays(long[] left, long[] right){
        int i=0,j=0,k=0;
        long[] merged = new long[left.length+ right.length];
        while(i< left.length && j<right.length){
            if(left[i]<=right[j]){
                merged[k]=left[i];
                i++;
                k++;
            }
            else{
                count+= left.length-i;
                merged[k]=right[j];
                j++;
                k++;
            }
        }
        while(i<left.length){
            merged[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            merged[k]=right[j];
            j++;
            k++;
        }
        return merged;
    }
}
