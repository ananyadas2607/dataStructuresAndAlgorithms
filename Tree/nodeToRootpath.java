package Pepcoding.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class nodeToRootpath {
    public static Scanner scn = new Scanner(System.in);
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static boolean nodeToRootPath_(TreeNode root, int data, ArrayList<TreeNode> ans ){
        if(root == null)
            return false;

        if(root.val == data) {
            ans.add(root);
            return true;
        }

        // if (nodeToRootPath_(root.left, data, ans))
        // {
        // ans.add(root);
        // return true;
        // }

        // if (nodeToRootPath_(root.right, data, ans))
        // {
        // ans.add(root);
        // return true;
        // }

        // return false;

        boolean res= nodeToRootPath_(root.left,data,ans) || nodeToRootPath_(root.right, data, ans);
        if (res)
            ans.add(root);
        return res;

    }

    public static  ArrayList<TreeNode> nodeToRootPath(TreeNode root, int data){
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.val == data) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }

        ArrayList<TreeNode> left = nodeToRootPath(root.left, data);
        if (left.size() != 0) {
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right = nodeToRootPath(root.right, data);
        if (right.size() != 0) {
            right.add(root);
            return right;
        }

        return new ArrayList<>();
    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
        Treenode.left = createTree(arr, IDX);
        Treenode.right = createTree(arr, IDX);

        return Treenode;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        int data = scn.nextInt();
//        ArrayList<TreeNode> ans = nodeToRootPath(root, data);

        ArrayList<TreeNode> ans=new ArrayList<>();
        nodeToRootPath_(root, data, ans);
        if (ans.size() == 0)  System.out.println();
        for (TreeNode node : ans)
            System.out.print(node.val + " ");

    }

    public static void main(String[] args) {
        solve();
    }

}
