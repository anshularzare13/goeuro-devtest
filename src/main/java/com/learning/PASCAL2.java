package com.learning;

import java.util.ArrayList;

/**
 * Created by MyMac on 11/01/16.
 */
public class PASCAL2 {
    public ArrayList<Integer> getRow(int a) {


        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();



        int i;
        for(i = 0;i <= a; i++){
            result.add(i, new ArrayList<Integer>());
            result.get(i).add(1);
            for(int j=1 ;j <=i ; j++){
                int set = 0 ;
                if(i>j){
                    set = result.get(i-1).get(j) + result.get(i-1).get(j-1);
                }else{
                    set = 1;
                }
                result.get(i).add(set);
            }

        }


        return result.get(a);
    }
}
