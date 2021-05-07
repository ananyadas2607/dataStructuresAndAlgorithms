package Pepcoding.Heap.PriorityQueue;

import java.util.PriorityQueue;

public class leetcode973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->{
            int d1=a[0]*a[0] + a[1]*a[1];//x1^2+y1^2
            int d2=b[0]*b[0] + b[1]*b[1];//x2^2+y2^2

            return d2-d1;
        });

        for(int[] p:points){
            pq.add(new int[]{p[0],p[1]});
            if(pq.size()>k) pq.remove();
        }

        int[][] ans=new int[k][];
        int i=0;
        while(pq.size()!=0){
            int[] p=pq.remove();
            ans[i++]=p;
        }
        return ans;
    }
}
