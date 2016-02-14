package com.learning.learning.part2;

/**
 * Created by anshul on 16/01/16.
 */
public class Excel1 {

    public int titleToNumber(String a) {

        char[] ch = a.toCharArray();
        int len = ch.length;
        int sum=0;
        int factor = 0;
        for(int i=len-1;i>=0;i--){
            if(factor==0){
                sum+= ((int)ch[i] - 64);
            }else{
                sum = sum + (int) Math.pow(26, factor) * ((int)ch[i] - 64);
            }
            factor++;
        }
        return sum;
    }

    public static void main(String[] args){
            Excel1 ex = new Excel1();
        System.out.print(ex.titleToNumber("ZZ"));

    }
}
