package com.level6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by skyhigh on 02/03/16.
 */

public class TreeTraversal {

    ArrayList<Integer> result = null;
    Stack<TreeNode> stack;
    HashMap<TreeNode,Boolean> isVisited;
    public TreeTraversal(){
        result= new ArrayList<>();
        isVisited = new HashMap<>();
        stack=new Stack<>();

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

    public ArrayList<Integer> inorderTraversal1(TreeNode a){
        //do it without recursion.
        // we have to store values in stack and check for visited nodes.
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = a;
        while (current!=null){
            stack.push(current);
            current=current.left;
        }
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            result.add(top.val);
            current = top.right;
            while (current!=null){
                stack.push(current);
                current=current.left;
            }
        }
        return result;
    }


    public ArrayList<Integer> postorderTraversal(TreeNode a){
        //do it without recursion.
        // we have to store values in stack and check for visited nodes.
        if(a==null){
            return result;
        }
        stack.push(a);
        while (!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(isVisited.containsKey(top)){
                result.add(top.val);
                stack.pop();
            }else{
                isVisited.put(top,true);
                if(top.right!=null){
                    stack.push(top.right);
                }
                if(top.left!=null){
                    stack.push(top.left);
                }
            }
        }
        return result;
    }


    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        if(a==null){
            return null;
        }
        //use one stack & one queue to solve this problem.
        //preorder means root, left, right.
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        stack1.push(a);
        while(!stack1.isEmpty()){
            TreeNode top = stack1.pop();
            result.add(top.val);
            if(top!=null){
                if(top.right!=null){
                    stack1.push(top.right);
                }
                if(top.left!=null){
                    stack1.push(top.left);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode head=TreeNode.createBinaryTree(new int[]{10,6,15,4,6,5,11  });
        TreeTraversal treeTraversal = new TreeTraversal();
        for(Integer i : treeTraversal.inorderTraversal1(head)){
            System.out.print(i + " ");
        }
    }
}
