package Pepcoding.Stack;

import java.util.Stack;

public class leetcode42 {
    //Approach 1
    public static int trap_01(int[] height) {

        int n=height.length;

        int[] lHeight=new int[n];
        int[] rHeight=new int[n];

        int prev=0;

        for(int i=0;i<n;i++){
            lHeight[i]=Math.max(height[i],prev);
            prev=lHeight[i];
        }

        prev=0;

        for(int i=n-1;i>=0;i--){
            rHeight[i]=Math.max(height[i],prev);
            prev=rHeight[i];
        }
        int totalWater=0;

        for(int i=0;i<n;i++){
            totalWater+=Math.min(lHeight[i],rHeight[i])- height[i];

        }
        return totalWater;
    }

    //Approach 2- Using Stack
    public static int trap_02(int[] height) {
        int n=height.length;
        Stack<Integer> st=new Stack<>();

        int totalWater=0;
        for(int i=0;i<n;i++){
            while(st.size()!=0 && height[i]>=height[st.peek()]){
                int popEleHeight=height[st.peek()];
                st.pop();
                if(st.size()==0) break;
                int w=i-st.peek()-1;
                int ph=Math.min(height[i],height[st.peek()]) - popEleHeight;
                totalWater+=w*ph;
            }
            st.push(i);
        }
        System.out.println(totalWater);
        return totalWater;
    }

    //Approach 3- Using Two Pointer Approach
    public static int trap(int[] height) {
        int n=height.length;
        int leftMax=0,rightMax=0;
        int left=0;
        int right=n-1;
        int totalWater=0;

        while(left<right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            totalWater= leftMax<rightMax? leftMax-height[left] : rightMax -height[right];
            left++;
            right--;
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[]  height = {10,8,0,8,18,5,3,0,3,5,15,5,0,5,3,20};
        trap(height);

    }
}
