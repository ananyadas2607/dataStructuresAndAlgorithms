package Pepcoding.Heap.PriorityQueue;

import java.util.PriorityQueue;

public class leetcode378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m= matrix[0].length;

        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->{
            int r1=a/m , c1=a%m;
            int r2=b/m , c2= b%m;

            return matrix[r1][c1] - matrix[r2][c2];
        });

        for(int i=0;i<n;i++){
            pq.add(i*m+0);
        }

        int ans=0;
        while(k-->0){
            int idx=pq.remove();
            int r=idx/m;
            int c=idx%m;

            ans=matrix[r][c];
            c++;
            if(c<m)
                pq.add(r*m+c);
        }
        return ans;

    }
}
