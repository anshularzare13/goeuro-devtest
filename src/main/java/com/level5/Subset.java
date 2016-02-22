package com.level5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by MyMac on 21/02/16.
 */
public class Subset {

    ArrayList<ArrayList<Integer>> res ;
    ArrayList<Integer> a;


    // This approach of backtracking is correct but it is taking more time.
    // We have
    public ArrayList<ArrayList<Integer>> subsetsBacktrack(ArrayList<Integer> a) {
        //Lets create ArrayList<ArrayList<Integer>> populate it each using recursion.
        Collections.sort(a);
        res =  new ArrayList<>();
        this.a =a;
        ArrayList<Integer> current = new ArrayList<>();
        res = generateSubsets(0, current);
        return res;
    }

    private ArrayList<ArrayList<Integer>> generateSubsets(int startIndex, ArrayList<Integer> current) {
        res.add(new ArrayList<Integer>(current));
        if(startIndex==a.size()|| (current.size()>0 &&current.get(current.size()-1)==a.get(a.size()-1))){
            return res;
        }
        for(int i=startIndex; i < a.size(); i++){
                current.add(a.get(i));
                generateSubsets(i + 1, current);
                current.remove(a.get(i));
        }
        return res;
    }

    public static void main(String[] args) {

        Subset subset= new Subset();

        ArrayList<ArrayList<Integer>> res = subset.subsetsBacktrack(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        for( ArrayList<Integer> arr : res){
            for (Integer i: arr){
                System.out.print(i+ " ");
            }
            System.out.println();
        }

    }

    private ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arrayList) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        int size = arrayList.size();
        int count = (int) Math.pow(2, size);
        ArrayList<Integer> current = new ArrayList<>();
        for(int i=0; i<count;i++){
            current = new ArrayList<>();
            for(int j=0 ;j < size;j++){
                if((i & 1<<j)!=0){
                    current.add(arrayList.get(j));
                }
            }
            res.add(current);
        }
        return res;
    }

}
