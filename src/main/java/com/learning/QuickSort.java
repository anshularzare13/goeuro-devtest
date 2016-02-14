package com.learning;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MyMac on 15/01/16.
 */
public class QuickSort {

    private ArrayList<Integer> quickSort(ArrayList<Integer> arrayList, int start, int end){

        if(start == end){
            return  arrayList;
        }

        int l=start,r=start;
        int pivot = arrayList.get(end-1);
        for(int i = start;i < end ; i++){

            if(arrayList.get(i)<=pivot){
                //swap and increment l,r;
                if(l!=r){
                    //swap
                    int temp = arrayList.get(l);
                    arrayList.set(l, arrayList.get(r));
                    arrayList.set(r, temp);
                }
                l++;
            }
            r++;

        }

        quickSort(arrayList, start, l-1);
        quickSort(arrayList, l, end);
        return arrayList;
    }

    public static void main(String[] args){

        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(10,90,8,7,6,5));
        input.toArray();
        QuickSort quickSort = new QuickSort();
        for(Integer integer: quickSort.quickSort(input, 0, input.size())){
            System.out.print(integer+ " ");
        }

    }
}
