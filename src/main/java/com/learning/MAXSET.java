package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MyMac on 11/01/16.
 */
/*
Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 */

    /*
    Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index
     */
public class MAXSET {

    public ArrayList<Integer> maxset(List<Integer> a) {

        long maxSum = Integer.MIN_VALUE;
        long localMax = 0;
        int index = 0; int length=0;
        int maxlength = 0, maxSumIndex   =0;
        for(int i=0 ;i <a.size();i++){
            if(a.get(i) < 0){
                //break here
                if(localMax > maxSum){
                    maxSum = localMax;
                    maxSumIndex = index;
                    maxlength = length;
                    localMax = 0;
                    //max
                }else if(localMax == maxSum && length > maxlength){

                    maxSumIndex = index;
                    maxlength = length;
                    localMax = 0;
                }

                length = 0;
                index = i+1;
                localMax = 0;

                //reset length
            }else{
                localMax = localMax + a.get(i);
                length++;
            }

        }

        if(localMax > maxSum){
            maxSum = localMax;
            maxSumIndex = index;
            maxlength = length;
            localMax = 0;
            //max
        }else if(localMax == maxSum && length > maxlength){

            maxSumIndex = index;
            maxlength = length;
            localMax = 0;
        }


        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=maxSumIndex ; i< maxlength + maxSumIndex; i++){
            res.add(a.get(i));

        }
        return res;

    }

    public static void main(String[] args){
        MAXSET m = new MAXSET();
        List<Integer> a = Arrays.asList(  24831, 53057, 19790, -10679, 77006, -36098, 75319, -45223, -56760, -86126, -29506, 76770, 29094, 87844, 40534, -15394, 18738, 59590, -45159, -64947, 7217, -55539, 42385, -94885, 82420, -31968, -99915, 63534, -96011, 24152, 77295 );
        for (Integer integer : m.maxset(a)) {
            System.out.print(integer
            + " ");
        }
        ;
    }


}
