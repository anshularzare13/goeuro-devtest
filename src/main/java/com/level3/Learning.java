package com.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by MyMac on 14/02/16.
 */
public class Learning {
    /*
    This class aims to understand difference between Array, ArrayList & List in java.




     */




    public static void main(String[] args) {

        List<Integer> arr1 = new ArrayList<>();
        arr1.add(10);
        arr1.add(20);

//        Integer[] array = new Integer[2];
//        array[0]=0;
//        array[1]=1;

//        arr1 =  (Arrays.asList(array));

//        Collections.addAll(arr1, array);
//        arr1.set(0, 7);
//        arr1.remove(1);

        Integer[] array = new Integer[arr1.size()];
        arr1.toArray(array);
        System.out.println(array[1]);
        array[1]=100;
        System.out.println(array[1]);
        System.out.println(arr1.get(1));

    }
}
