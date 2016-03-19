package com.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by MyMac on 05/03/16.
 */
public class ArrayPrintUtil {

    public static void print2DArray(ArrayList<ArrayList<Integer>> input){
        for(List<Integer> Obj : input){
            for(Object o : Obj){
                System.out.print(o+ " ");
            }
            System.out.println();
        }
    }

    public static void print1DArray(ArrayList<Integer> arrayList){
        for(Integer i :arrayList)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void print2DArrayString(ArrayList<ArrayList<String>> input){
        for(List<String> Obj : input){
            for(Object o : Obj){
                System.out.print(o+ " ");
            }
            System.out.println();
        }
    }
}
