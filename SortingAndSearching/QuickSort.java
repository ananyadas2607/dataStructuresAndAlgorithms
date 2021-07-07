package Pepcoding.SortingAndSearching;

public class QuickSort {

    public static void swap(int a, int b){
        int temp=a;
        a=b;
        b=temp;
    }
    public static int segregateData(int[] arr, int si, int ei, int pivot){
        int n=arr.length-1;
        swap(arr[pivot],arr[ei]);
        int p=si-1, itr=si;
        while(itr<=ei){
            if(arr[itr]<=arr[ei])
                swap(++p,arr[itr]);
            itr++;
        }
        return p;
    }

    public static void quickSort(int[] arr, int si, int ei){
        if(si>ei)
            return;
        int pivot=ei;
        int pIdx=segregateData(arr,si,ei,pivot);

        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);

    }
}
