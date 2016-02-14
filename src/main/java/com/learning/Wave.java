package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by MyMac on 15/01/16.
 */
public class Wave {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        //
        Collections.sort(a);
        for(int i=0;i < a.size() -1 ;i=i+2){
            //swap a[i] & a[i+1]
            int temp = a.get(i);
            a.set(i, a.get(i+1));
            a.set(i+1, temp);
        }

        return a;
    }

    public static void main(String[] args){
        Wave wave = new Wave();
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(4,5,2,1));
        ArrayList<Integer> wave1 = wave.wave(input);
        Iterator<Integer> it = wave1.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }


}
