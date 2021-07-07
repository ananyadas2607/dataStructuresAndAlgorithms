package Pepcoding.Recursion;

import java.util.ArrayList;
import java.util.List;

public class questions {
    public void combinationSum(int[] arr, int idx, int target,List<List<Integer>> ans, List<Integer> smallAns)
    {
        if(target==0 || idx==arr.length){
            if (target == 0) {
                List<Integer> base = new ArrayList<>(smallAns); // deep Copy
                ans.add(base);
            }
            return;
        }
        if (target - arr[idx] >= 0) {
            smallAns.add(arr[idx]);
            combinationSum(arr, idx, target - arr[idx], ans, smallAns);
            smallAns.remove(smallAns.size() - 1);
        }

        combinationSum(arr, idx + 1, target, ans, smallAns);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> smallAns=new ArrayList<>();
        combinationSum(candidates,0,target,ans,smallAns);
        return ans;
    }
    public static void main(String args[]){

    }
}
