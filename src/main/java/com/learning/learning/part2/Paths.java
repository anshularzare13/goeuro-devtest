package com.learning.learning.part2;

import java.util.ArrayList;

/**
 * Created by MyMac on 17/01/16.
 */
public class Paths {

    public int uniquePaths(int a, int b) {
    // To find a unique path between start and end points is solved using dynamic programming.

        // 2-D array to store unique point indexes.
        //Initialise array with  base values.
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i <= a; i++){
            dp.add(i, new ArrayList<Integer>());
            for(int j=0;j<= b ;j++){
                if(i==1 && j==1){
                    dp.get(i).add(j,1);
                }
                else if(i==1 || j==1){
                    dp.get(i).add(j, 1);
                }else {
                    dp.get(i).add(j, 0);
                }
            }
        }
        return recursivePath(a,b, dp);


    }

    private int recursivePath(int a, int b, ArrayList<ArrayList<Integer>> dp) {

        if(dp.get(a).get(b)!=0){
            return dp.get(a).get(b);
        }

        int x = recursivePath(a-1, b, dp);
        int y = recursivePath(a, b-1, dp);
        dp.get(a-1).set(b, x);
        dp.get(a).set(b-1,y);
        return x+y;
    }


    public static void main(String[] args){


        Paths p = new Paths();
        System.out.println(p.uniquePaths(10, 10));

    }


}
