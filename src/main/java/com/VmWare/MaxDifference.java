package com.VmWare;

import com.zenify.MaximiseProfit;

/**
 * Created by MyMac on 08/04/16.
 */
public class MaxDifference {
    static int maxDifference(int[] a){
        if(a==null || a.length==0 || a.length==1){
            return -1;
        }

        int min = a[0];
        int gMax = -1;
        int len = a.length;
        for(int i=1;i < len; i++){

            int cVal = a[i];
            if(cVal < min){
                min = cVal;
            }
            else if(cVal - min > gMax){
                gMax  = cVal - min;
            }
        }
        return gMax;
    }

    public static void main(String[] args) {
        MaxDifference max = new MaxDifference();
        System.out.println(max.maxDifference(new int[]{10,2,8}));
    }
}
