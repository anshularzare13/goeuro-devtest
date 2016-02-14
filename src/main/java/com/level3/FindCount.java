package com.level3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by anshul on 30/01/16.
 */
public class FindCount {

    public int findCount(final List<Integer> a, int b) {
        // Do binary search first and then count it occurrences by traversing the array linearly(or not?)
        // Linear approach gives 0(n) time complexity which is not right.
        // You need to find first & last occurrence of a number and then find count in O(log(n))

        int firstIndex = doBinary(a, 0, a.size()-1, b, true);
        if(firstIndex==-1){
            return 0;
        }
        int lastIndex = doBinary(a, 0, a.size()-1, b, false);
        return lastIndex-firstIndex+1;
    }

    private int doBinary(List<Integer> a, int start, int end, int number, boolean searchFirst) {
        int mid = (start + end)/2;
        if(start>end){
            return -1;
        }
        if(a.get(mid)==number){
            int result = mid;
            int newRes;
            if(searchFirst){
                newRes =  doBinary(a, 0,mid-1, number, true);
            }else{
                newRes=  doBinary(a, mid+1, end, number, false);
            }

            if(newRes!=-1){
                return newRes;
            }
            return result;


        }else if(a.get(mid) > number){
            return doBinary(a, 0, mid-1,number, searchFirst);
        }else {
            return doBinary(a,mid+1, end,number, searchFirst);
        }
    }


    public static void main(String[] args){
        List<Integer> in = Arrays.asList(1, 2, 6, 9, 9);
        FindCount countelements = new FindCount();
        System.out.println(countelements.findCount(in,9));
    }
}
