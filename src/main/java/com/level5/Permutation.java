package com.level5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MyMac on 21/02/16.
 */
public class Permutation {
    ArrayList<ArrayList<Integer>> res ;
    ArrayList<Integer> a;
    boolean[] ismarked;

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        //Lets create ArrayList<ArrayList<Integer>> populate it each using recursion.

        res =  new ArrayList<>();
        this.a =a;
        ismarked = new boolean[a.size()];
        ArrayList<Integer> current = new ArrayList<>();
        res = generatePermutation(0,current);
        return res;

    }

    private ArrayList<ArrayList<Integer>> generatePermutation(int startIndex, ArrayList<Integer> current) {

        if(startIndex==a.size()){
            res.add(new ArrayList<Integer>(current));
            return res;
        }

        for(int i=0; i < a.size(); i++){
            if(!ismarked[i]) {
                ismarked[i]=true;
                current.add(a.get(i));
                generatePermutation(startIndex + 1, current);
                ismarked[i]=false;
                current.remove(a.get(i));
            }
        }
        return res;
    }

    //Below one is swap appraoch.

//    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
//        //Lets create ArrayList<ArrayList<Integer>> populate it each using recursion.
//
//
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        // System.out.print(res.size());
//        ArrayList<Integer> current = a;
//        res = generatePermutation(a, 0, res,current);
//
//
//
//        return res;
//
//    }
//
//    private ArrayList<ArrayList<Integer>> generatePermutation(ArrayList<Integer> a, int startIndex, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> current) {
//
//        if(startIndex==a.size()-1){
//            res.add(new ArrayList<Integer>(current));
//            return res;
//        }
//
//        for(int i=startIndex; i < a.size(); i++){
//            swap(current,i,startIndex);
//            generatePermutation(a, startIndex+1,res,current);
//            swap(current,i,startIndex);
//        }
//
//
//        return res;
//    }
//
//    private void swap(ArrayList<Integer> current, int i, int startIndex) {
//        if(i==startIndex){
//            return;
//        }
//        int tmp = current.get(i);
//        current.set(i, current.get(startIndex));
//        current.set(startIndex,tmp);
//    }


    public static void main(String[] args) {


        Permutation p = new Permutation();
        ArrayList<ArrayList<Integer>> res = p.permute(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        for( ArrayList<Integer> arr : res){
            for (Integer i: arr){
                System.out.print(i+ " ");
            }
            System.out.println();
        }

    }
}
