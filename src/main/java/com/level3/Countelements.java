package com.level3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by anshul on 30/01/16.
 */
public class Countelements {

    public int findCount(final List<Integer> a, int b) {
        // Do binary search first and then count it occurrences by traversing the array linearly(or not?)

        int index = doBinary(a, 0, a.size()-1,b);
        if(index==-1){
            return 0;
        }
        int count=1;
        int tmp=index-1;
        while(tmp>=0 && a.get(tmp)==b){
            count++;
            tmp--;
        }
        tmp = index +1;
        while (tmp < a.size() && a.get(tmp)==b){
            count++;
            tmp++;
        }
        return count;
    }

    private int doBinary(List<Integer> a, int start, int end, int number) {
        int mid = (start + end)/2;
        if(start>end){
            return -1;
        }
        if(a.get(mid)==number){
            return mid;
        }else if(a.get(mid) > number){
            return doBinary(a, 0, mid-1,number);
        }else {
            return doBinary(a,mid+1, end,number);
        }
    }


    public static void main(String[] args){
        List<Integer> in = Arrays.asList( 1, 2, 6, 9, 9);
        Countelements countelements = new Countelements();
        System.out.println(countelements.findCount(in,9));
    }

}
