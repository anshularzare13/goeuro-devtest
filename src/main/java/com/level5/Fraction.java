package com.level5;

import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.MARSHAL;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by MyMac on 25/02/16.
 */
public class Fraction {

    //If you start with remainder = R at any point with denominator d, you will always get the same sequence of digits.
    //So, if your remainder repeats at any point of time, you know that the digits between the last occurrence of R will keep repeating.

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
            return "0";
        }
        if(denominator==0){
            return "";
        }
        //lets first try to find division correctly. (i.e. numbers before decimal and after decimal.
        StringBuilder str =new StringBuilder();
        if(numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0 ){
            str.append("-");
        }
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        str.append(num/den);
        HashMap<String, Integer> map =new HashMap<>();
        long remainder = (num)%(den);
        if(remainder!=0) {
            str.append(".");
            int pos = str.length();
            while (remainder != 0) {
                remainder = remainder * 10;
                String r = String.valueOf(remainder);
                if (map.containsKey(r)) {
                    int lastOcc = map.get(r);
                    String repeat = str.substring(lastOcc, str.length());
                    String start = str.substring(0, lastOcc);
                    str = new StringBuilder();
                    str.append(start).append('(').append(repeat).append(')');
                    break;
                } else {
                    str.append(remainder / den);
                    remainder = remainder % den;
                    map.put(r, pos++);
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Fraction fraction = new Fraction();
//        System.out.println(fraction.fractionToDecimal(10,-3));
        System.out.println(fraction.fractionToDecimal(-2147483648,-1));
    }
}
