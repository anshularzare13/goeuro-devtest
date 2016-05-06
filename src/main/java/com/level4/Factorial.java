package com.level4;

/**
 * Created by MyMac on 04/04/16.
 */
public class Factorial {

    public int findFactorial(int n){
        if(n==0 || n==1){
            return 1;
        }

        return n*findFactorial(n-1);
    }


    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.findFactorial(5));
    }

}