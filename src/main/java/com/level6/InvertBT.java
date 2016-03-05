package com.level6;

/**
 * Created by MyMac on 04/03/16.
 */
public class InvertBT {

    public TreeNode invertTree(TreeNode root) {
        //first invert root ka left, then root ka right then finally root.

        if(root==null || (root.left==null && root.right==null)){
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.createBinaryTree(new int[]{5,3,6,2,4});
        InvertBT in = new InvertBT();
        TreeNode.printInOrder(in.invertTree(t));

    }
}
