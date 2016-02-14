package com.learning;

/**
 * Created by MyMac on 15/01/16.
 */
public class decbin {
    public String findDigitsInBinary(int a) {
        StringBuilder str = new StringBuilder();

        int count=0;
        while(a>1){
            str.append(a%2);
            a=a/2;
        }

        if(a==0){
            str.append(0);
        }else if (a==1){
            str.append(1);
        }
        str = str.reverse();
        return  str.toString();
    }

    public static void main(String[] args){
        decbin db = new decbin();
        System.out.print(db.findDigitsInBinary(0));
    }

}
