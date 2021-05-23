package Pepcoding.ArraysAndStrings;

public class segregatePositiveAndNegativeNumbers {

    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void segregatePositiveandNeg(int[] arr){
        int n=arr.length;
        int pt=-1;
        int itr=0;
        while(itr<n){
            if(arr[itr] <0)
                swap(arr, arr[++pt],arr[itr]);
            itr++;
        }
    }
}
