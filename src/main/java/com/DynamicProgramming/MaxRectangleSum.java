package com.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by MyMac on 04/04/16.
 */
class MaxRectangle{


    private  int left;
    private  int right;
    private  int top;
    private  int bottom;
    private  int sum = Integer.MIN_VALUE;


    public void getMaxSum(int[] temp, int l, int r){

        int len = temp.length;
        int cs=0;
        int s=0,e;
        for(int i=0; i< len; i++){
            e=i;
            cs = cs + temp[i];
            if(temp[i]>cs){
                cs = temp[i];
                s = i;
            }

            if(cs>sum){
                sum = cs;
                bottom = e;
                top = s;
                left = l;
                right = r;
            }
        }

    }
    public int getSum() {
        return sum;
    }
    public int getBottom() {
        return bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getTop() {
        return top;
    }
}


public class MaxRectangleSum {


    public static int findMaxSum(int[][] array){

        if(array==null){
            return 0;
        }
        int rows = array.length;
        int cols = array[0].length;

        if(rows==0 || cols==0){
            return 0;
        }

        MaxRectangle m = new MaxRectangle();

        int[] temp;
        for(int l=0; l < cols; l++){
            temp = new int[rows];
            Arrays.fill(temp,0);
            for(int r=l ; r < cols;r++){
                for(int i=0;i<rows;i++){
                    temp[i] += array[i][r];
                }
                m.getMaxSum(temp,l,r);
            }
        }
        System.out.println("left " + m.getLeft()+ " right " +m.getRight());
        System.out.println("top " + m.getTop()+ " bottom " +m.getBottom());
        return m.getSum();
    }


    public static void main(String[] args) {
        int[][] array =  {{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };
        System.out.println(MaxRectangleSum.findMaxSum(array));

    }
}
