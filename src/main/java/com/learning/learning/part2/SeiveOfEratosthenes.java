package com.learning.learning.part2;

import java.util.ArrayList;

/**
 * Created by MyMac on 17/01/16.
 */
public class SeiveOfEratosthenes {

    public ArrayList<Integer> sieve(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // initialising all elements of result as 0.
        for(int i=0;i <=a;i++){
            if(i==0 || i==1) {
                result.add(i, 0);
                // 0 and 1 are not prime.
            }else {
                result.add(i, i);
            }
        }

        for(int i=2;i <= Math.sqrt(a); i++){
            if(result.get(i)!=0){
                // then strike off all factors of i upto a.
                for(int j=2; i*j<=a ;j++){
                    result.set(j*i,0);
                }
            }
        }

        ArrayList<Integer> out =  new ArrayList<Integer>();

        for(int i=0;i<result.size();i++){
            if(result.get(i)!=0){
                out.add(i);
            }
        }
        return out;


    }

    //to find out all prime numbers upto n we use seive of eratosthenes.
    // we strike off factors of prime number.

    public static void main(String[] args){
        SeiveOfEratosthenes s = new SeiveOfEratosthenes();
        for (Integer integer : s.sieve(50) ){
                        System.out.print(integer + " ");
        }

    }
}
