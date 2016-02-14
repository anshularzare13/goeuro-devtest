package com.learning.learning.part2;

/**
 * Created by MyMac on 16/01/16.
 */
public class Palindrome {

    public boolean isPalindrome(int a) {
        String val = String.valueOf(a);
        char[] ch = val.toCharArray();
        int len  = ch.length;
        for(int i=0;i < len/2; i++){
            if(ch[i]!=ch[len-i-1]){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args){
        Palindrome pl = new Palindrome();
        System.out.print(pl.isPalindrome(12));
    }



}
