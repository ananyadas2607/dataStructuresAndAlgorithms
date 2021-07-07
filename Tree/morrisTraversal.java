package Pepcoding.Tree;

import java.util.ArrayList;

public class morrisTraversal {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode getRightMostNode(TreeNode node, TreeNode curr){
        while(node.right!=null && node.right != curr){
            node=node.right;
        }
        return node;
    }

    public static ArrayList<Integer> morrisInOrderTraversal(TreeNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            TreeNode left=curr.left;
            if(left==null){
                ans.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode rightMostNode=getRightMostNode(left,curr); //thread creation block
                if(rightMostNode.right==null){
                    rightMostNode.right=curr;
                    curr=curr.left;
                }
                else{
                    rightMostNode.right=null; //thread destroy block
                    ans.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}
