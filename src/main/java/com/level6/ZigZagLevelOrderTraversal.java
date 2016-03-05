package com.level6;

import com.level3.ArrayPrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by MyMac on 05/03/16.
 */
public class ZigZagLevelOrderTraversal{

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {

        //LEts do it in a for while loop.
        //I can not do zigzag traversal with only one queue.
        //I need a stack as well.
        //because says i have stored 6,3 now to do opposite order traversal i have to first get 3 then 6.
        // Think of some logic on paper and then come back.
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(null);
        stack.push(a);
        boolean rtl=false;
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp==null) {
                if(current.size()!=0){
                    res.add(current);
                }
                if(queue.size()==0){
                    break;
                }
                current = new ArrayList<>();
                rtl = !rtl;
                stack.push(null);
                while(queue.size()!=0){
                    stack.push(queue.remove());
                }
                continue;
            }
            current.add(tmp.val);
            if(rtl){
                if(tmp.right!=null) {
                    queue.offer(tmp.right);
                }
                if(tmp.left!=null) {
                    queue.offer(tmp.left);
                }
            }else{
                if(tmp.left!=null) {
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null) {
                    queue.offer(tmp.right);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.createBinaryTree(new int[]{5,3,6,-1,2,4,-1});
        ZigZagLevelOrderTraversal zg = new ZigZagLevelOrderTraversal();
        ArrayPrintUtil.print2DArray(zg.zigzagLevelOrder(t));
    }
}
