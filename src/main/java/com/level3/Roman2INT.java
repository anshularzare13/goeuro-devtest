package com.level3;

/**
 * Created by MyMac on 10/02/16.
 */
public class Roman2INT {

    public int romanToInt(String a) {
        int index=0;
        int sum=0;
        int M = 1000, D=500, C=100,L=50,X=10,V=5,I=1;

        char ch;
        char tmp;
        int x,y;
        while(index<a.length()-1){

            ch = a.charAt(index);
            tmp = a.charAt(index+1);
            x=getValue(ch);
            y=getValue(tmp);
            if(y>x){
                index=index+2;
                sum = sum + y-x;
            }else{
                sum = sum + x;
                index++;
            }
        }

        if(index==a.length()-1){
            sum = sum + getValue(a.charAt(index));
        }
        return sum;


    }

    private int getValue(char ch) {
        int M = 1000, D=500, C=100,L=50,X=10,V=5,I=1;
        switch (ch){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            default:
                return 1;
        }
    }

    public static void main(String[] args){
        Roman2INT roman2INT = new Roman2INT();
        System.out.println(roman2INT.romanToInt("MMCDLXXV"));


    }
}
