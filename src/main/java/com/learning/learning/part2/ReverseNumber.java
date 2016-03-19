package com.learning.learning.part2;

/**
 * Created by MyMac on 18/03/16.
 */
public class ReverseNumber {

    public int reverse(int a) {
        if(a==0){
            return a;
        }


        int isNegative = 0;
        String num = String.valueOf(a);
        char[] array = num.toCharArray();
        int start=0;
        int len = array.length;
        if(array[0]=='-'){
            isNegative = 1;
        }

        for(int i=0;i<len/2;i++)
        {
            char tmp =array[i+isNegative];
            array[i+isNegative]=array[len-1-i];
            array[len-1-i]=tmp;
        }

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        num = new String(array);
        try{
            return Integer.parseInt(num);
        }catch(Exception e){
            return 0;
        }
    }


    public static void main(String[] args) {
        ReverseNumber rn = new ReverseNumber();
        System.out.print(rn.reverse(1234));
    }
}
