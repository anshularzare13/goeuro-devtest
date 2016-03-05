package com.level6;

/**
 * Created by MyMac on 03/03/16.
 */
public class IdenticalBT {
    public int isSameTree(TreeNode a, TreeNode b) {
            return isSameTreeB(a,b)?1:0;
    }
    private boolean isSameTreeB(TreeNode a,TreeNode b){
        if(a==null && b==null){
            return true;
        }
        if(a==null||b==null){
            return false;
        }
        if(a.val==b.val){
            return isSameTreeB(a.left,b.left) && isSameTreeB(a.right,b.right);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}