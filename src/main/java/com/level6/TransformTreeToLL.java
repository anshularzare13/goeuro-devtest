package com.level6;

/**
 * Created by MyMac on 06/03/16.
 */
public class TransformTreeToLL {

    public TreeNode flatten(TreeNode a) {
        if(a==null){
            return null;
        }

        flatten(a.left);
        flatten(a.right);

        TreeNode tmp  = a.right;
        a.right = a.left;
        TreeNode t = a.left;
        while (t!=null &&t.right!=null){
            t= t.right;
        }
        if(t!=null) {
            t.right = tmp;
        }else{
            a.right = tmp;
        }
        a.left=null;
        return a;
    }

    public static void main(String[] args) {
        TreeNode  t =TreeNode.createBinaryTree(new int[]{121, 108, 126, 94, 110, 124, -1, 91, 95, 109, 117, 122, 125, 88, 92, -1, 98, -1, -1, 111, 120, -1, 123, -1, -1, 87, 90, -1, 93, 97, 107, -1, 116, 118, -1, -1, -1, -1, -1, 89, -1, -1, -1, 96, -1, 103, -1, 115, -1, -1, 119, -1, -1, -1, -1, 101, 104, 112, -1, -1, -1, 99, 102, -1, 105, -1, 113, -1, 100, -1, -1, -1, 106, -1, 114, -1, -1, -1, -1, -1, -1});
//        TreeNode t = TreeNode.createBinaryTree(new int[]{5,3,6,-1,4,-1,-1,-1,-1,-1,8,-1,-1,-1,-1});
        TransformTreeToLL tl = new TransformTreeToLL();
        TreeNode s = tl.flatten(t);
        TreeNode.printInOrder(s);
    }
}
