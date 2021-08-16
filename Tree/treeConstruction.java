package Pepcoding.Tree;

public class treeConstruction {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //LC-105- Construct binary tree from preorder and inorder traversal
    public TreeNode buildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if(psi>pei) return null;

        int idx=isi;
        while(inorder[idx]!=preorder[psi])
            idx++;
        int colse=idx-isi;
        TreeNode node=new TreeNode(preorder[psi]);
        node.left=buildTree(preorder, psi+1, psi+colse, inorder, isi,idx-1);
        node.right=buildTree(preorder, psi+colse+1, pei,inorder, idx+1, iei);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return buildTree(preorder, 0, n-1, inorder, 0, n-1);
    }

    //LC-106- Construct binary tree from postorder and inorder traversal
    public TreeNode buildTree_InPost(int[] inorder,int isi, int iei, int[] postorder, int psi, int pei) {
        if(isi>iei) return null;

        int idx=isi;
        while(inorder[idx]!=postorder[pei])
            idx++;
        int tnel=idx-isi;

        TreeNode node=new TreeNode(postorder[pei]);

        node.left= buildTree(inorder, isi,idx-1,postorder,psi,psi+tnel-1);
        node.right=buildTree(inorder, idx+1,iei,postorder,psi+tnel,pei-1);

        return node;

    }


    public TreeNode buildTree_InPost(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return buildTree_InPost(inorder, 0,n-1,postorder,0,n-1);
    }

    //Construct binary tree from PreOrder and PostOrder traversal
    public TreeNode constructFromPrePost(int[] pre, int presi, int preei, int[] post, int postsi, int postei)
    {
        if(presi>preei) return null;
        TreeNode node=new TreeNode(post[postei]);
        if(presi==preei)
            return node;

        int idx=postsi;
        while(post[idx]!=pre[presi+1])
            idx++;

        int colse=idx-postsi+1;


        node.left=constructFromPrePost(pre, presi+1,presi+ colse,post, postsi, idx);
        node.right=constructFromPrePost(pre, presi+colse+1, preei, post, idx+1, postei-1);

        return node;

    }

    public TreeNode constructFromPrePost(int[] pre, int[] post)
    {
        int n=pre.length;
        return constructFromPrePost(pre, 0,n-1,post,0,n-1);

    }

    //Largest BST Subtree
    class BSTPair{
        boolean isBst=true;
        int min= (int)1e9;
        int max= -(int)1e9;
        int size=0;
        TreeNode largestRoot=null;
    }

    public BSTPair largestBSTSubtree_(TreeNode node){
        if (node == null)
        {
            BSTPair base=new BSTPair();
            return base;
        }
        BSTPair lp=largestBSTSubtree_(node.left);
        BSTPair rp=largestBSTSubtree_(node.right);

        BSTPair mp=new BSTPair();
        mp.isBst=false;
        if(lp.isBst && rp.isBst && lp.max<node.val && node.val<rp.min){
            mp.isBst=true;
            mp.min=Math.min(lp.min, node.val);
            mp.max=Math.max(rp.max, node.val);
            mp.size=lp.size+rp.size+1;
            mp.largestRoot=node;
        }
        else{
            if (lp.size > rp.size)
            {
                mp.size = lp.size;
                mp.largestRoot = lp.largestRoot;
            }
            else
            {
                mp.size = rp.size;
                mp.largestRoot = rp.largestRoot;
            }
        }
        return mp;

    }
    public int largestBSTSubtree(TreeNode root) {
        return largestBSTSubtree_(root).size;

    }
}
