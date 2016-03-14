package com.level3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MyMac on 09/03/16.
 */
public class RemoveElementfromArray {

    public int removeElement(ArrayList<Integer> a, int b) {
        //swap element b to first and trim the array finally
        int count=0;
        for(int i=0;i<a.size();i++){

            if(a.get(i)!=b)
            {
                a.set(count++,a.get(i));
            }
        }
        return a.subList(0,count).size();
    }

    public static void main(String[] args) {
        RemoveElementfromArray rm = new RemoveElementfromArray();
        System.out.println(rm.removeElement(new ArrayList<>(Arrays.asList(1,2,3,4)),2));

    }

}
