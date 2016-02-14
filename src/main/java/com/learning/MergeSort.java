package com.learning;

import com.sun.xml.internal.ws.policy.PolicyMerger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MyMac on 15/01/16.
 */
public class MergeSort {

    private ArrayList<Integer> MergeSort(ArrayList<Integer> A, int start, int end){

        if(start ==end){
            ArrayList<Integer> r = new ArrayList<Integer>();
            r.add(A.get(start));
            return r;
        }
        int mid = (start + end)/2;

        ArrayList<Integer> left = MergeSort(A,start,mid );
        ArrayList<Integer> right= MergeSort(A, mid+1, end);

        return Merge(left, right, A, start);


    }

    private ArrayList<Integer> Merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> a, int start) {
        int len1 = left.size();
        int len2 = right.size();
        ArrayList<Integer> nArray = new ArrayList<Integer>();
        int i=0,j=0,k=0;
        while(i<len1 && j< len2){
            if(left.get(i) <= right.get(j)){
                nArray.add(k, left.get(i));
                i++;
            }else{
                nArray.add(k, right.get(j));
                j++;
            }
            k++;
        }
        while(i<len1){
            nArray.add(k, left.get(i));
            k++;i++;
        }
        while(j<len2){
            nArray.add(k, right.get(j));
            j++;k++;
        }

        return nArray;
    }

    public static void main(String[] args){

        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(2, 1,10,5,6,8,3,4,5,66,7,8));
        input.toArray();
        MergeSort mergeSort = new MergeSort();
        for(Integer integer: mergeSort.MergeSort(input, 0, input.size()-1)){
            System.out.print(integer+ " ");
        }

    }
}
