package Pepcoding.FAANG2.SortingAndSearching;

import java.util.Scanner;

public class o26_AllocateNumberOfPages {
    public static int findPages(int[]a,int n,int m)
    {
        //Your code here
        int max=0, sum=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,a[i]);
            sum+=a[i];
        }
        int lo=max, high=sum, mid=0, ans=0;
        while(lo<=high){
            mid=(lo+high)/2;
            if(isPossibleMaxPages(a,mid,m)==true){
                ans=mid;
                high=mid-1;
            }
            else
                lo=mid+1;
        }
        return ans;
    }
    public static boolean isPossibleMaxPages(int[] a, int mid, int m){
        int st=1, sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(sum>mid){
                sum=a[i];
                st++;
            }
        }
        return st<=m;
    }
}
