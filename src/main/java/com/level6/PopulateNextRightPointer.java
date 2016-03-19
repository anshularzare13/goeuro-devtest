package com.level6;

/**
 * Created by MyMac on 16/03/16.
 */
public class PopulateNextRightPointer {
    public void connect(TreeNode root) {
        //I will write the code in 10 minutes.
        //If only i had done this problem earlier i could have done it easily in the interview.
        //But now i am getting the feel of the interviews and should be more comfortable.
        // Give me two more weeks and i will start getting offers.
        //Don't resign yet but start working more hard.
        //During office hours read java.
        TreeNode hold  = root;
        TreeNode lastLeft = root;
        while(lastLeft!=null){
            lastLeft = connectSibling(lastLeft);
        }
        return ;
    }

    public TreeNode connectSibling(TreeNode head){
        boolean is = true;
        TreeNode tmp = null;
        TreeNode prev= null;
        while(head!=null){
            TreeNode left = head.left;
            TreeNode right = head.right;
            if(left!=null && is){
                is = false;
                tmp=left;
            }else if(right!=null && is){
                tmp=right;
                is=false;
            }
            if(left!=null && right!=null){
                left.next = right;
            }

            if(prev!=null && left!=null){
                prev.next = left;
            }
            else if(prev!=null && right!=null){
                prev.next = right;
            }


            if(right!=null){
                prev=right;
            }else if(left!=null){
                prev=left;
            }
            head = head.next;
        }
        return tmp;
    }
}
