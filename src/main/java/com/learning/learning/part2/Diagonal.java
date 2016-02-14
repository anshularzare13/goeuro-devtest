package com.learning.learning.part2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MyMac on 18/01/16.
 */
public class Diagonal {


    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {

        if(a.size()==0){
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int i=0,j=0,k=0;
        int N= a.size();

        for(i=0; i < N ;i++){
            j=i;k=0;
            result.add(new ArrayList<Integer>());
            while(j>=0 && k<N){
                result.get(i).add(a.get(k).get(j));
                j--;
                k++;
            }
        }
        int count = i-1;
        for(i=1;i<N;i++){
            j=i;k=N-1;
            result.add(new ArrayList<Integer>());
            count++;
            while(j<N&&k>=0){
                result.get(count).add(a.get(j).get(k));
                k--;
                j++;
            }
        }

        return result;


    }


    public static void main(String[] args){
        Diagonal d = new Diagonal();
        ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(4,5,6));
        ArrayList<Integer> three = new ArrayList<Integer>(Arrays.asList(7,8,9));

        ArrayList<ArrayList<Integer>> in = new ArrayList<ArrayList<Integer>>();
        in.add(one);in.add(two);in.add(three);
        for (ArrayList<Integer> arrayList : d.diagonal(in)) {
            for (Integer i : arrayList){
                System.out.print(i+ " ");
            }
            System.out.println();
        }
        ;

    }

}
