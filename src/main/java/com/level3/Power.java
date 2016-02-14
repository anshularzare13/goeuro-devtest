package com.level3;

import com.learning.learning.part2.Palindrome;

/**
 * Created by MyMac on 31/01/16.
 */
public class Power {
    public int pow(int x, int n, int d) {

        //find x^n mod d.
        // X^n will overflow int so we have to be careful.
        if(x==0) {return 0;}
        if(n==0) {return 1;}
        long res=x;
        long oddm=1;


        while(n>1) {
            if(n%2==0){
                res= res*res;
                n = n/2;
            }else{
                oddm = oddm*res;
                n--;
            }
           res = res%d;
            oddm = oddm%d;
        }
        res  = res*oddm;
        res = res%d;
        if (res < 0) {
            res = res + d;
        }
        return (int) res;
    }

    public static void main(String[] args){
        Power power = new Power();
        System.out.println(power.pow(5, 3, 9));
    }
}
