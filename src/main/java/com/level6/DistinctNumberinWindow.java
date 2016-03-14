package com.level6;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by MyMac on 08/03/16.
 */
public class DistinctNumberinWindow {

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result  = new ArrayList<Integer>();
        HashMap<Integer,Integer> count = new HashMap<>();
        if(B>A.size()){
            return result;
        }

        //initially populate the map with B entries.
        for(int i=0;i<A.size();i++){
            int val = A.get(i);
            if(count.containsKey(val)){
                count.put(val, count.get(val)+1);
            }else{
                count.put(val,1);
            }

            if(i>=B){
                int indexToremove = i-B;
                int value = A.get(indexToremove);
                int c = count.get(value);
                if(c==1) {
                    count.remove(value);
                }else{
                    count.put(value, c-1);
                }
            }
            if(i>=B-1) {
                result.add(count.size());
            }
        }
        return result;
    }
}
