package com.level6;

import java.util.ArrayList;

/**
 * Created by anshul.. on 04/03/16.
 */
public class PathSum {

    boolean hasSum=false;
    int sum=0;

    public int hasPathSum(TreeNode a, int b) {
        if(a==null){
            return 0;
        }
//        hasSum(a,b);
//        return hasSum?1:0;
        return  hasSumk(a,0,b)? 1:0;
    }

    ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        hasSumk(root, 0,sum, result);
        return answer;
    }
    //what if i don't want to take sum as global variable.
    //Lets write another method where sum is passed along in the method.
    private void hasSum(TreeNode a, int b){
        if(a==null){return;}
        if(a.left==null && a.right==null){
            sum = sum + a.val;
            if(sum==b){
                hasSum=true;
            }
            sum =sum - a.val;
            return;
        }

        sum+=a.val;
        hasSum(a.left,b);
        hasSum(a.right,b);
        sum-=a.val;
    }

    private boolean hasSumk(TreeNode head, int currentSum, int requiredSum) {
        if(head==null){return false;}
        if(head.left==null && head.right==null){
            currentSum += head.val;
            if(currentSum==requiredSum){
                return true;
            }else{
                return false;
            }
        }

        currentSum += head.val;
        return hasSumk(head.left, currentSum,requiredSum) ||hasSumk(head.right,currentSum,requiredSum);
    }

    private void hasSumk(TreeNode head, int currentSum, int requiredSum, ArrayList<Integer> current) {
        if(head==null){return;}
        if(head.left==null && head.right==null){
            currentSum += head.val;
            if(currentSum==requiredSum){
                current.add(head.val);
                answer.add(new ArrayList<Integer>(current));
                current.remove(current.size()-1);
            }
            return;
        }

        currentSum += head.val;
        current.add(head.val);
        hasSumk(head.left, currentSum,requiredSum,current);
        hasSumk(head.right,currentSum,requiredSum,current);
        current.remove(current.size()-1);
        return;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.createBinaryTree(new int[]{5,3,6,2,4,1,9});
        PathSum p =new PathSum();
        for(ArrayList<Integer> i: p.pathSum(t,0)){
            for (int j:i){
                System.out.print(j+" ");
            }
            System.out.println();;
        }

    }
}
