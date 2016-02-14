package com.learning;

import java.util.ArrayList;

/**
 * Created by MyMac on 13/01/16.
 */
public class Primesum {
    public ArrayList<Integer> primesum(int a) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if(a==4){
            result.add(2);
            result.add(2);
            return result;
        }

        for(int i=3; i<= a/2;i=i+2){

            if(isPrime(i) && (i==a/2 || isPrime(a-i))){
                result.add(i);
                result.add(a-i);
                break;
            }

        }
        return result;

    }

    private boolean isPrime(int number) {
        for(int i=3;i <=(int ) Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Primesum primesum = new Primesum();
        ArrayList<Integer> primesum1 = primesum.primesum(12345678);
        for(Integer integer : primesum1){
            System.out.print(integer + " ");
        }
    }
}
