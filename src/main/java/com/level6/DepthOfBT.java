package com.level6;

/**
 * Created by MyMac on 03/03/16.
 */
public class DepthOfBT {
    public int maxDepth(TreeNode a) {
        if(a==null){
            return 0;
        }
        int ldepth  = 1+maxDepth(a.left);
        int rdepth = 1+maxDepth(a.right);
        return Math.max(ldepth,rdepth);
    }


    public int minDepth(TreeNode a){
        if(a==null) {
            return 0;
        }
        if(a.right==null) {
            return 1 + minDepth(a.left);
        }
        if(a.left==null){
           return 1+minDepth(a.right);
        }
        int ldepth = 1+minDepth(a.left);
        int rdepth = 1 + minDepth(a.right);
        return Math.min(ldepth,rdepth);
    }


    public static void main(String[] args) {
        TreeNode t = TreeNode.createBinaryTree(new int[]{ 1, 2, -1, -1, 3, -1, -1});
        DepthOfBT dp = new DepthOfBT();
        System.out.println(dp.maxDepth(t));
        System.out.println(dp.minDepth(t));
    }
}
