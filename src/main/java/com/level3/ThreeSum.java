package com.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by MyMac on 13/02/16.
 */
public class ThreeSum {

    public int threeSumClosest(ArrayList<Integer> a, int b) {
          //first sort a
        Collections.sort(a);
        int globalClosestSum=a.get(0)+a.get(1)+a.get(2),currentClosestSum;
        for(int i=0;i<a.size()-2;i++){
            int j=i+1,k=a.size()-1;
            while(j<k){

                currentClosestSum = a.get(i)+a.get(j)+a.get(k);
                if(b>currentClosestSum){
                    j++;
                }else if(b<currentClosestSum){
                    k--;
                }
                else{
                    return b;
                }

                if(Math.abs(b-currentClosestSum)<Math.abs(b-globalClosestSum)){
                    globalClosestSum = currentClosestSum;
                }
            }
        }
        return globalClosestSum;
    }


    public static void main(String[] args){
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSumClosest(new ArrayList<Integer>(Arrays.asList(-1,2,4,1)),-1));

    }

}
