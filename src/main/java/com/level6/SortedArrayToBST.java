package com.level6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MyMac on 05/03/16.
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(final List<Integer> a) {

        return constructTree(a,0,a.size()-1);
    }

    private TreeNode constructTree(List<Integer> a, int start, int end) {

        if(end<start){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode tmp = new TreeNode(a.get(mid));
        tmp.left=tmp.right=null;

        tmp.left = constructTree(a,start,mid-1);
        tmp.right = constructTree(a,mid+1, end);

        return tmp;
    }


    public static void main(String[] args) {
        SortedArrayToBST s = new SortedArrayToBST();
        TreeNode.printInOrder(s.sortedArrayToBST(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5))));

    }
}
