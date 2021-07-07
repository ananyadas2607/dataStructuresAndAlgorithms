package Pepcoding.Tree;

import java.util.ArrayList;
import java.util.List;

public class o3_Leetcode863 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static boolean nodeToRootpath(TreeNode root, int data, ArrayList<TreeNode> ans ){
        if(root == null)
            return false;

        if(root.val == data) {
            ans.add(root);
            return true;
        }
        boolean res= nodeToRootpath(root.left,data,ans) || nodeToRootpath(root.right, data, ans);
        if (res)
            ans.add(root);
        return res;

    }
    public static void kdown(TreeNode root, int k, TreeNode block, List<Integer> ans) {
        if (root == null || k < 0 || root == block)
            return;

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        kdown(root.left, k - 1, block, ans);
        kdown(root.right, k - 1, block, ans);
    }

    //Space-O(n)
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> path=new ArrayList<>();
        nodeToRootpath(root, target.val,path);
        List<Integer> ans=new ArrayList<>();
        TreeNode block=null;
        for(int i=0;i<path.size();i++){
            kdown(path.get(i),k-i,block,ans);
            block=path.get(i);
        }
        return ans;
    }

    //Space-O(1)
    public static int distanceK_optimizedSpace(TreeNode root, TreeNode target, int k, List<Integer> ans){
        if(root == null)
            return -1;

        if(root== target){
            kdown(root, k, null, ans);
            return 1;
        }
        int ld=distanceK_optimizedSpace(root.left, target, k, ans);
        if(ld!=-1){
            kdown(root, k-ld,root.left, ans);
            return ld+1;
        }

        int rd=distanceK_optimizedSpace(root.right, target, k, ans);
        if(rd!=-1){
            kdown(root, k-rd,root.left, ans);
            return rd+1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        List<Integer> ans = new ArrayList<>();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        TreeNode target = root.left.right;
        System.out.println(distanceK(root, target, 2));
        System.out.println(distanceK_optimizedSpace(root, target, 2, ans));
    }

}
