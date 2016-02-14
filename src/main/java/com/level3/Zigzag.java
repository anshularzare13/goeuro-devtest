package com.level3;

import java.util.Arrays;

/**
 * Created by MyMac on 10/02/16.
 */
public class Zigzag {



    public String convert(String a, int b) {
        if(b==1){
            return a;
        }
        StringBuilder[] stringBuilders = new StringBuilder[b];
        for(int i=0;i<b;i++){
            stringBuilders[i] = new StringBuilder();
        }
        int len = a.length();
        int index = 0;
        int row = 0, inc=1;
        while(index < len){
            char ch = a.charAt(index);
            index++;
            stringBuilders[row].append(ch);

            if(row==b-1){
                inc=-1;
            }else if(row==0){
                inc=1;
            }
            row = row + inc;
        }

        StringBuilder res = new StringBuilder();
        for(int i=0;i<b;i++){
            res.append(stringBuilders[i].toString());
        }
        return res.toString();
    }


    public static void main(String[] args){


        Zigzag zigzag = new Zigzag();
        System.out.print(zigzag.convert("PAYPALISHIRING", 1));
    }
}
