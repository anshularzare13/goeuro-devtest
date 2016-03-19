package com.level6;

/**
 * Created by MyMac on 02/03/16.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    TreeNode(int x) { val = x; }
    private static  int[] array = null;
    TreeNode(int x, TreeNode t) { val=x;left = null;right=null;}
    private static int length ;
    public static TreeNode createBinaryTree(int[] number) {
        //lets say i pass 10 6 15 3 -1 5 9
        // then it mean 10 has child 6 and 15. 6 has child 3 & -1 and 15 has childs 5 and 9 respectively (left & right in order).
        // 3 -1 5 and 9 are leaf nodes.

        TreeNode head = new TreeNode(number[0]);
        array = number;
        length = array.length;
        return populateTree(head, 1);
    }

    private static TreeNode populateTree(TreeNode head, int i) {
        if(i>=length){
            return head;
        }
        if(array[i]!=-1) {
            TreeNode temp = new TreeNode(array[i], null);
            head.left = temp;
            populateTree(temp, 2 * i + 1);
        }
        if(i+1>=length){
            return head;
        }
        if(array[i+1]!=-1) {
            TreeNode temp = new TreeNode(array[i + 1], null);
            head.right = temp;
            populateTree(temp, 2 * (i + 1) + 1);
        }
        return head;
    }

    public static void printInOrder(TreeNode head){
        if(head==null){
            return;
        }
        printInOrder(head.left);
        System.out.print(head.val+ " ");
        printInOrder(head.right);
    }

    public static void main(String[] args) {
        TreeNode t = createBinaryTree(new int[]{10,6,15,3,-1,5,9});
    }

}
