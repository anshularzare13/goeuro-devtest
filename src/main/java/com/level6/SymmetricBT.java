package com.level6;

/**
 * Created by MyMac on 03/03/16.
 */
public class SymmetricBT {

    /*
    To find whether a given tree is symmetric or not.
     */
    //I can do a level order traversal and check for symmetry.
    public int isSymmetric(TreeNode a) {
        if(a==null){
            return 0;
        }
        return isSymmetric(a.left,a.right)? 1:0;

    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
       if(node1==null && node2==null){
           return true;
       }
        if(node1==null || node2==null){
            return false;
        }

        if(node1.val!=node2.val){
            return false;
        }
        return isSymmetric(node1.left,node2.right) | isSymmetric(node1.right,node2.left);
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.createBinaryTree(new int[]{1,2,2,3,4,4,5});
        SymmetricBT sbt = new SymmetricBT();
        System.out.println(sbt.isSymmetric(t));
    }
}
