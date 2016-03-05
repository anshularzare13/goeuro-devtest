package com.level6;

/**
 * Created by MyMac on 03/03/16.
 */
public class KthSmallestElementBST {

    // How can you solve this problem without using extra memory.
    // and in the same time complexity.
    public KthSmallestElementBST(){
    }

    int count=1;
    int element;

    public int kthsmallest(TreeNode a,int k){
        kthsmallestvoid(a,k);
        return element;
    }

    public void kthsmallestvoid(TreeNode a, int k) {
        if(a==null){
            return ;
        }

        kthsmallestvoid(a.left, k);
        if(count==k){
            element= a.val;
        }
        count++;
        kthsmallestvoid(a.right,k);
    }


    public static void main(String[] args) {
        TreeNode t = TreeNode.createBinaryTree(new int[]{5,3,6,2,4});
        KthSmallestElementBST kthSmallestElementBST = new KthSmallestElementBST();
        System.out.println(kthSmallestElementBST.kthsmallest(t,1));
    }
}
