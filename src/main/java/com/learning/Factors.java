package com.learning;

import java.util.ArrayList;

/**
 * Created by MyMac on 15/01/16.
 */
public class Factors {
    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> result1  = new ArrayList<Integer>();

        if(a==0){ result.add(0); return result;}
        for(int i =1;i <= Math.sqrt(a) ;i++){
            if(a%i==0){
                result.add(i);
                if(i!=a/i) {
                    result1.add(a / i);
                }
            }
        }
        for(int i=0;i< result1.size();i++) {
            result.add(result1.get(result1.size()-1-i));
        }

        return result;
    }

    public static void main(String[] args){
        Factors f =new Factors();
        for (Integer integer : f.allFactors(12345)) {
            System.out.print(integer + " ");
        };
    }
}
