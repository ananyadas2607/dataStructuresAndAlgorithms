package Pepcoding.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode84LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nsol = new int[n];
        int[] nsor= new int[n];
        NSOL(heights,nsol);
        NSOR(heights,nsor);
        int maxArea=0;
        for(int i=0;i<n;i++){
            int h=heights[i];
            int w=nsor[i]-nsol[i]-1;
            maxArea=Math.max(maxArea,h*w);
        }
        return maxArea;
    }

    public int largestRectangleArea_02(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int maxArea=0;
        int i=0;
        while(i<n){
            while(st.peek()!=-1 && heights[st.peek()]>=heights[i]){
                st.pop();
                int h=heights[st.peek()];
                int w=i-st.peek()-1;
                maxArea=Math.max(maxArea,h*w);
            }
        st.push(i++);
        }
        while(st.peek()!=-1){
            st.pop();
            int h=heights[st.peek()];
            int w=n-st.peek()-1;
            maxArea=Math.max(maxArea, h*w);
        }
        return maxArea;
    }

    public void NSOL(int[] arr, int[] ans){
        int n=arr.length;
        Arrays.fill(ans,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(st.size()!=0 && arr[i] < arr[st.peek()]){
                ans[st.pop()]=i;
            }
            st.push(i);
        }
    }

    public void NSOR(int[] arr, int[] ans){
        int n=arr.length;
        Arrays.fill(ans,n);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(st.size()!=0 && arr[i] < arr[st.peek()]){
                ans[st.pop()]=i;
            }
            st.push(i);
        }
    }
}
