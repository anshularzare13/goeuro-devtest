package com.learning;

/**
 * Created by MyMac on 15/01/16.
 */
public class Factorial {
    public int trailingZeroes(int a) {

        // approach, basically i have to count number of 5's in n!.
        int count =0;
        if(a<5){
            return  0;
        }

        for(int i=5;i<=a;i=i+5){
            //count no.s of 5's in this i
            int j=i;
            while(j>=5 && j%5==0){
                count++;
                j=j/5;
            }

        }

        return count;
}
    public static void main(String[] args){
        Factorial f = new Factorial();
        System.out.print(f.trailingZeroes(12345678));
    }
}
