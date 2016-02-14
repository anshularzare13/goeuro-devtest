package com.learning.learning.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by MyMac on 16/01/16.
 */
public class Setzero {




    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        if(a.size()==0){
            return;
        }
        //first get the locations of all zero's in the array.
        ArrayList<Integer> rowZero = new ArrayList<Integer>();
        ArrayList<Integer> colZero = new ArrayList<Integer>();
        // co-ordinates are saved in x,y as in a[i],a[i+1]


        int m = a.size(); // number of rows
        int n = a.get(0).size(); // number of columns.

        int i=0, j=0;

        for(i=0;i<m;i++){
            for(j=0;j<n;j++){

                // all rowZero or ColhasallZeros then break it;
                if(colZero.size()==n || rowZero.size()==m){
                    break;
                }
                if(a.get(i).get(j)==0){

                    if(!rowZero.contains(i)){
                        rowZero.add(i);
                    }

                    if(!colZero.contains(j)){
                        colZero.add(j);
                    }
                }
            }
        }

        for(i=0;i<rowZero.size();i=i+1) {
            makeRowZero(a, rowZero.get(i), n);
        }


        for(i=0;i<colZero.size();i=i+1) {
            makeColumnZero(a, colZero.get(i), m);
        }
    }

    private void makeRowZero(ArrayList<ArrayList<Integer>> a,Integer integer, Integer index) {

        for(int i=0;i<index ; i++){
            a.get(integer).set(i,0);
        }
    }

    private void makeColumnZero(ArrayList<ArrayList<Integer>> a,Integer integer, Integer index) {

        for(int i=0;i<index ; i++){
            a.get(i).set(integer,0);
        }
    }


    public static void main(String[] args){
        Setzero setzero  = new Setzero();
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(0,0,0));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(0,0,0));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(1,1,1));

        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

        input.add(one);
        input.add(two);
        input.add(three);

        int m = input.size(); // number of rows
        int n = input.get(0).size(); // number of columns.

        int i=0, j=0;

        setzero.setZeroes(input);
        for(i=0;i<m;i++){
            for(j=0;j<n;j++) {
                System.out.print(input.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

}
