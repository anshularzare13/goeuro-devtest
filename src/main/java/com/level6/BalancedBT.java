package com.level6;

/**
 * Created by MyMac on 02/03/16.
 */
public class BalancedBT {
    int isBalanced;
    public BalancedBT(){
         isBalanced = 1;
    }


    public int isBalanced(TreeNode a) {
        findHeight(a);
        return isBalanced;
    }

    private int findHeight(TreeNode a){
        if(isBalanced==0){
            return -1;
        }
        if(a==null){
            return -1;
        }
        int l = 1+ findHeight(a.left);
        int r = 1+ findHeight(a.right);
        if(Math.abs(l-r)>1) {
            isBalanced = 0;
        }
        return Math.max(l, r);
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.createBinaryTree(new int[]{10,6,15,3,-1,-1,-1,90});
        BalancedBT bt = new BalancedBT();
        System.out.println(bt.isBalanced(t));
    }
}
