package com.level5;

import java.util.ArrayList;

/**
 * Created by MyMac on 22/02/16.
 */
public class Graycode {

    public ArrayList<Integer> grayCode(int a) {
        //n represents number of bits in an integer.
        //I have to make count number each of a number of bits.
        ArrayList<String> arr = new ArrayList<>();
        arr = recursiveGrayCode(a, arr);
        ArrayList<Integer> res = binaryToDec(arr);
        return res;
    }

    private ArrayList<Integer> binaryToDec(ArrayList<String> arr) {
        ArrayList<Integer> arrayList= new ArrayList<>();
        for(String s: arr){

            char[] chars = s.toCharArray();
            int digit=0;
            int c=0;
            for(int i=chars.length-1;i>=0;i--){
                if(chars[i]=='1') {
                    digit = digit+ (int) Math.pow(2, c);
                }
                c++;
            }
            arrayList.add(digit);
        }
        return arrayList;
    }

    private ArrayList<String> recursiveGrayCode(int a, ArrayList<String> arrayList) {
        if(a==0){
            return new ArrayList<>();
        }
        if(a==1){
            ArrayList<String> res = new ArrayList<>();
            res.add("0");
            res.add("1");
            return res;
        }
        ArrayList<String> one = recursiveGrayCode(a - 1, arrayList);
        ArrayList<String> two = reverse(one);
        ArrayList<String> fin = new ArrayList<>();
        // add one with 0 prefixes & two with 1 prefixes.
        for(String i : one){
            StringBuilder str = new StringBuilder();
            str.append("0").append(i);
            fin.add(str.toString());
        }
        for(String i : two){
            StringBuilder str = new StringBuilder();
            str.append("1").append(i);
            fin.add(str.toString());
        }
        return fin;

    }

    private ArrayList<String> reverse(ArrayList<String> one) {
        if(one.size()==1){
            return one;
        }
        int sz = one.size();
        ArrayList<String> rev = new ArrayList<>();
        for(int i=sz-1;i>=0;i--){
            rev.add(one.get(i));
        }
        return rev;
    }

    public static void main(String[] args) {
        Graycode gc =new Graycode();
        for(Integer i: gc.grayCode(20)){
            System.out.println(i);
        }

    }
}
