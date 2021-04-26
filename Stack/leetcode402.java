package Pepcoding.Stack;

import java.util.ArrayList;

public class leetcode402 {
    public String removeKdigits(String num, int k) {
        if(num.length()==k)
            return "0";

        StringBuilder sb = new StringBuilder(num);
        for(int j=0; j<k; j++){
            int i=0;
            while(i<sb.length()-1&&sb.charAt(i)<=sb.charAt(i+1)){
                i++;
            }
            sb.delete(i, i+1);
        }

        //remove leading 0's
        while (sb.length() > 1 && sb.charAt(0)=='0')
            sb.delete(0,1);

        if(sb.length()==0){
            return "0";
        }

        return sb.toString();
    }
    public String removeKdigitsUsingStack(String num, int k){
        ArrayList<Character> st=new ArrayList<>();
        System.out.println(st.size()-1);
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            while(st.size()!=0 && st.get(st.size()-1)>ch && k>0){
                st.remove(st.size()-1);
                k--;
            }
            st.add(ch);
        }
        while(k-->0){
            st.remove(st.size()-1);
        }
        StringBuilder ans=new StringBuilder();
        boolean flag=false;
        for(Character ch: st){
            if(ch=='0' && !flag){
                continue;
            }
            flag=true;
            ans.append(ch);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        leetcode402 l=new leetcode402();
        l.removeKdigitsUsingStack("1432219",3);
    }
}
