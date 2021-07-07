package Pepcoding.ArraysAndStrings;

import java.util.HashMap;

public class LC1074numOfSubmatricesSumToTarget {
    public int countSubarrayGivenTarget(int[] arr,int tar){
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int count=0,sum=0;
        for(int ele:arr){
            sum+=ele;
            count+=map.getOrDefault(sum-tar,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public int numSubmatrixSumTarget(int[][] arr, int target) {
        int n=arr.length, m=arr[0].length;
        int count=0;

        for(int fixRow=0;fixRow<n;fixRow++){
            int[] colPrefixSumArray=new int[m];
            for(int row=fixRow;row<n;row++){
                for(int col=0;col<m;col++)
                    colPrefixSumArray[col]+=arr[row][col];
                count+=countSubarrayGivenTarget(colPrefixSumArray,target);
            }
        }
        return count;
    }
}
