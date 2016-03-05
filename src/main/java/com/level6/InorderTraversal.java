package com.level6;

import java.util.ArrayList;

/**
 * Created by skyhigh on 02/03/16.
 */

public class InorderTraversal {

    ArrayList<Integer> result = null;

    public InorderTraversal(){
        result= new ArrayList<>();
    }
    public ArrayList<Integer> inorderTraversal(TreeNode a) {

        if(a==null){
            return result;
        }

        inorderTraversal(a.left);
        result.add(a.val);
        inorderTraversal(a.right);
        return result;

    }

    public static void main(String[] args) {
        TreeNode head=TreeNode.createBinaryTree(new int[]{10,6,15,-1,-1,5,-1});
        InorderTraversal inorderTraversal = new InorderTraversal();
        for(Integer i : inorderTraversal.inorderTraversal(head)){
            System.out.print(i + " ");
        }

    }
}
