package com.learning;

/**
 * Created by MyMac on 15/01/16.
 */
public class verifyprime {

    public int isPrime(int a) {

        if(a<=1){
            return 0;
        }

        for(int i=2;i <= Math.sqrt(a);i++){

            if(a%i==0){
                return 0;
            }

        }

        return 1;
    }

    public  static void main(String[] args){

        verifyprime ver = new verifyprime();
        System.out.print(ver.isPrime(1234321));

    }
}
