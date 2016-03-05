package com.level6;

/**
 * Created by MyMac on 05/03/16.
 */
public class LowestCommonAncestor {

    boolean isOnePresent = false;
    boolean isTwoPresent = false;
    public int lca(TreeNode a, int val1, int val2) {
        TreeNode res = findLCA(a,val1,val2);
        if(isOnePresent && isTwoPresent){
            return res.val;
        }
        return -1;

    }
    private TreeNode findLCA(TreeNode head, int val1, int val2){
        if (head == null) {return head;}
        if (head.val == val1){
            isOnePresent=true;
            if(present(head,val2)){
                isTwoPresent=true;
            }
            return head;
        }else if(head.val==val2){
            isTwoPresent=true;
            if(present(head,val1)){
                isOnePresent=true;
            }
            return head;

        }
        TreeNode left = findLCA(head.left, val1, val2);
        TreeNode right = findLCA(head.right, val1, val2);

        if (left == null && right == null) {
            return left;
        }else if(left!=null && right!=null){
            return head;
        }
        else if(left==null){
            return right;
        }else{
            return left;
        }

    }

    private boolean present(TreeNode h, int v) {
        if(h==null){
            return false;
        }
        if(h.val==v){
            return true;
        }
        return present(h.left,v) ||present(h.right,v);
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.createBinaryTree(new int[]{5,3,6,2,4,1,9});
        LowestCommonAncestor lca = new LowestCommonAncestor();
        System.out.println(lca.lca(t,3,2));
    }
}
