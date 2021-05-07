package Pepcoding.Heap.HeapConstruction;

import java.util.ArrayList;

public class heapSort {



    private static boolean compareTo(ArrayList<Integer> arr,boolean isIncreasing, int i, int j)
    {
        if (isIncreasing)
            return arr.get(i) > arr.get(j);
        else
            return arr.get(i) < arr.get(j);
    }

    private static void swap(ArrayList<Integer> arr,int i, int j) //O(1)
    {
        int temp= i;
        arr.set(i, j);
        arr.set(j, temp);
    }

    private static void downHeapify( ArrayList<Integer> arr, boolean isIncreasing, int pi, int li){
        int maxIdx=pi;
        int lci=2*pi+1;
        int rci=2*pi+2;
        if(lci<=li && compareTo( arr, isIncreasing, lci,maxIdx))
            maxIdx=lci;
        if(rci<=li && compareTo( arr, isIncreasing, rci, maxIdx))
            maxIdx=rci;

        if(pi!=maxIdx){
              swap(arr, arr.get(pi), arr.get(maxIdx));
              downHeapify(arr, isIncreasing, maxIdx, li);
        }
    }

    public  static void heapSort( ArrayList<Integer> arr, boolean isIncreasing){
        int li=arr.size() -1;
        for(int i=li;i>=0;i--){
            downHeapify(arr,isIncreasing,i,li);
        }
        while(li>=0){
            swap(arr, arr.get(0), arr.get(li--));
            downHeapify(arr, isIncreasing,0,li);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
//        int[] arr1= {10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13};
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(-2);
        arr.add(-3);
        arr.add(-4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(22);
        arr.add(11);
        arr.add(13);

        heapSort(arr,true);

        for (int ele : arr)
            System.out.println(ele);

    }
}
