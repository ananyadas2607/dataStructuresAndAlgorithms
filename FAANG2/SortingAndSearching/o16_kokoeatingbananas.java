package Pepcoding.FAANG2.SortingAndSearching;

public class o16_kokoeatingbananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;

        for(int ele: piles){
            max=Math.max(ele,max);
        }
        if(h==piles.length)
            return max;

        int si=0,ei=max,total_time=0,speed=Integer.MAX_VALUE;
        while(si<=ei){
            int mid=si+(ei-si)/2;

            if(isPossible(piles, h, mid)==true){
                speed=mid;
                ei=mid-1;
            }
            else
                si=mid+1;
        }
        return speed;

    }
    public static boolean isPossible(int[] piles, int h, int sp){
        int time=0;

        for(int i=0;i<piles.length;i++){
            time+=(int)Math.ceil(piles[i]*1.0/sp);
        }
        return time<=h;
    }
}
