package com.learning.learning.part2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MyMac on 16/01/16.
 */
public class Arrange {

    public void arrange(ArrayList<Integer> a) {

        ///modify the array to contain two numbers.
        int n = a.size();
        for(int i=0; i<a.size();i++){
            a.set(i, a.get(i) + (a.get(a.get(i))%n)*n  );
        }
        for(int i=0;i <n;i++){
            a.set(i, a.get(i)/n);
        }


    }


    public static void main(String[] args){
        Arrange arrange = new Arrange();
        ArrayList<Integer> in = new ArrayList<Integer>(Arrays.asList(1,0));
        arrange.arrange(in);

        for(Integer i : in){
            System.out.print(i + " ");
        }
    }
}
