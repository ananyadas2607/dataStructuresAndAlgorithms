package Pepcoding.ArraysAndStrings;

public class rotateArrayByKTimes {
    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void reverse(int[] arr, int i, int j){
        while(i<j){
            swap(arr, i++,j--);
        }
    }

    public static void rotateByK(int[] arr, int r){
        int n=arr.length;
        r=r%n;
        if(r<0)
            r+=n;
        reverse(arr,0,n-1);
        reverse(arr,n-r,n-1);
        reverse(arr, 0, n-r-1);


    }
}
