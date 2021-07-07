package Pepcoding.Recursion;

public class bitManipulation {
    //191
    public int hammingWeight(int n) {
         int count=0;
         for(int i=0;i<32;i++){
             if((n & (1 << i))!=0)
                 count++;

         }
         return count;
     }

     //191-Optimized Solution 2
     public int hammingWeight_optimized(int n) {
         int count=0;
         while(n!=0){
             if((n & 1)!=0) count++;
             n>>>=1;
         }
         return count;
     }

     //191- Optimized solution 3
     public int hammingWeight_3(int n) {
         //Optimized SOlution
         int count=0;
         while(n!=0){
             count++;
             n &= (n-1);
         }
         return count;
     }

     //338
     public int[] countBits(int n) {
         int[] ans=new int[n+1];
         int count=0;
         ans[0]=0;
         for(int i=1;i<=n;i++){
             ans[i]=ans[i& (i-1)]+1;
         }
         return ans;

     }

     //231
     public boolean isPowerOfTwo(int n) {
         return n > 0 && ((n & (n-1))==0);
     }

    //342
    public boolean isPowerOfFour(int n) {
        if(n<=0 || (n&(n-1))!=0) return false;

        int count=0;
        while(n!=0){
            if((n&1)==0)
                count++;
            n>>>=1;
        }
        return (count&1)==0;//Check if count or number of zeroes are even
    }

    //136
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int ele: nums)
            ans^=ele;
        return ans;
    }

    //137


}
