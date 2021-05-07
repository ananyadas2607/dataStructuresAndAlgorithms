package Pepcoding.Heap.HeapConstruction;

import java.util.ArrayList;

public class heap {
    private ArrayList<Integer> arr;
    private boolean isMaxHeap=true;

    void defaultValue(boolean isMaxHeap){
        this.arr=new ArrayList<>();
        this.isMaxHeap=isMaxHeap;
    }
    void constructHeap() //O(nlogN) -> O(n)
    {
        for(int i=this.arr.size()-1;i>=0;i--){
            downHeapify(i);
        }
    }

    heap() {
        defaultValue(true);
    }

    heap(boolean isMaxHeap) {
        defaultValue(isMaxHeap);
    }

    heap(int[] arr, boolean isMaxHeap) {
        defaultValue(isMaxHeap);

        for (int ele : arr)
            this.arr.add(ele);

        constructHeap();
    }

    int size() //O(1)
    {
        return this.arr.size();
    }

    boolean isEmpty() //O(1)
    {
        return this.arr.size() == 0;
    }
    int remove() //O(log N)
    {
        int rEle = this.arr.get(0);
        int n=this.arr.size();
        swap(0,n-1);
        this.arr.remove(n-1);
        downHeapify(0);
        return rEle;

    }
    void add(int data) //O(log N)
    {
        this.arr.add(data);
        int n=this.arr.size();
        upHeapify(n-1);
    }

    int top() // O(1)
    {
        return this.arr.get(0);
    }

    private void swap(int i, int j) //O(1)
    {
        int temp=this.arr.get(i);
        this.arr.set(i, this.arr.get(j));
        this.arr.set(j, temp);
    }

    private boolean compareTo(int i, int j) {
        if (isMaxHeap)
            return this.arr.get(i) > this.arr.get(j);
        else
            return this.arr.get(i) < this.arr.get(j);
    }

    private void downHeapify(int pi) //O(log n)
    {
        int maxIdx = pi;
        int lci=2*pi+1;
        int rci=2*pi+2;

//        if(lci< arr.size() && arr.get(lci)>arr.get(maxIdx)) //This will construct maxHeap
//        {
//            maxIdx=lci;
//        }
//        if(rci< arr.size() && arr.get(rci)>arr.get(maxIdx)) //This will construct maxHeap
//        {
//            maxIdx=rci;
//        }

        if(lci< arr.size() && compareTo(lci,maxIdx)) //This will construct minHeap
        {
            maxIdx=lci;
        }
        if(rci< arr.size() && compareTo(rci,maxIdx)) //This will construct minHeap
        {
            maxIdx=rci;
        }
        if(maxIdx!=pi){
            swap(pi, maxIdx);
            downHeapify(maxIdx);
        }
    }

    private void upHeapify(int ci) //O(log n)
    {
        int pi=(ci-1)/2;

        if(pi>=0 && this.arr.get(ci) > this.arr.get(pi)){
            swap(pi,ci);
            upHeapify(pi);
        }
    }
}
