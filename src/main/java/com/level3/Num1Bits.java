package com.level3;

/**
 * Created by MyMac on 13/02/16.
 */
public class Num1Bits {


    public int numSetBits(long a) {

        int count=0;
        while(a>0){
            if(a%2==1){
                count++;
            }
            a/=2;
        }
        return count;
    }

    public static void main(String[] args){
        Num1Bits n  = new Num1Bits();
        System.out.println(n.numSetBits(500));

    }
}
