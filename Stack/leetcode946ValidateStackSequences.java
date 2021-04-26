package Pepcoding.Stack;

import java.util.Stack;

public class leetcode946ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        int i=0,n=popped.length;
        for(int ele:pushed){
            st.push(ele);
            while(st.size()!=0 && st.peek() == popped[i]){
                st.pop();
                i++;
            }
        }
        return st.size()!=0;
    }
}
