package com.level6;

import com.level3.ArrayPrintUtil;

import java.util.*;

/**
 * Created by MyMac on 04/04/16.
 */
public class TwoSum {
    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        ArrayList<Integer> result  = new ArrayList<Integer>();

        if(a==null || a.size()<2){
            return result;
        }
        int min1, min2 = Integer.MAX_VALUE;
        int index1=Integer.MAX_VALUE,index2=Integer.MAX_VALUE;

        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> r;
        int size = a.size();
        for(int i=0;i < size; i++){
            int val  = a.get(i);
            if(map.containsKey(val))
            {
                r = map.get(val);
                r.add(i+1);
                map.put(val,r);
            }
            else
            {
                r = new ArrayList<>();
                r.add(i+1);
                map.put(val,r);
            }
        }
        int val1;
        boolean found = false;
        for(int i=0;i<size;i++){
            val1 = a.get(i);
            min1= i+1;
            if(map.containsKey(b-val1)){
                found = true;
                r = map.get(b-val1);
                for(int j=0;j<r.size();j++){
                    if(r.get(j)==min1){
                        continue;
                    }

                    if(r.get(j)>min1 && min2 > r.get(j)){
                        min2 = r.get(j);
                    }
                }
                if((index2>min2 || index2==min2 && index1>min1) && min2>min1){
                    index1=min1;
                    index2=min2;
                }
            }
        }

        if(found){
            result.add(index1);
            result.add(index2);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        List<Integer> l = Arrays.asList(1,1,1);
        ArrayPrintUtil.print1DArray(twoSum.twoSum(l,2));
    }
}
