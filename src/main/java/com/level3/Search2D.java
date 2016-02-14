package com.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anshul on 30/01/16.
 */
public class Search2D {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        //first select the row to apply binary search.

        int i=0, selectedRowIndex=0;
        int m = a.size();
        int n = a.get(0).size();
        for(i=0;i<m;i++){
            if(a.get(i).get(0) <= b && a.get(i).get(n-1) >= b){
                selectedRowIndex = i;
                break;
            }
        }
        // apply binary search on selected row index.

        int low = 0, high = n-1;
        ArrayList<Integer> selectedRow = a.get(selectedRowIndex);
        while(low<=high){
            int mid = low + (high-low)/2;
            if(selectedRow.get(mid)==b){
                return 1;
            }else if(selectedRow.get(mid) > b){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
    return 0;
    }

    public static void main(String[] args){
        Search2D s = new Search2D();
        ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(1,4,14));
        ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(16,25,36));
        ArrayList<Integer> three = new ArrayList<Integer>(Arrays.asList(71,81,91));

        ArrayList<ArrayList<Integer>> in = new ArrayList<ArrayList<Integer>>();
        in.add(one);in.add(two);in.add(three);
        System.out.println(s.searchMatrix(in, 91));
    }
}
