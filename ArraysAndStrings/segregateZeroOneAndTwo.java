package Pepcoding.ArraysAndStrings;

public class segregateZeroOneAndTwo {
    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    void segregateZeroOneAndTwo( int[] arr)
    {
        int n = arr.length, pt1 = -1, pt2 = n - 1, itr = 0;
        while (itr <= pt2)
        {
            if (arr[itr] == 0)
                swap(arr,arr[++pt1], arr[itr++]);
            else if (arr[itr] == 2)
                swap(arr,arr[pt2--], arr[itr]);
            else
                itr++;
        }
    }
}
