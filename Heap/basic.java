package Pepcoding.Heap;

public class basic {
    public static int heightOfTree(int[] arr, int idx){
        if(idx>=arr.length) return -1;

        int lh=heightOfTree(arr, 2*idx+1);
        int rh=heightOfTree(arr,2*idx+2);

        System.out.println(lh+1);
        return lh+1;
    }

    public static void main(String args[]){
        int[] arr={10,20,30,-2,-3,-4,5,6,7,8,9,22,11,13};
        heightOfTree(arr,0);
    }
}
