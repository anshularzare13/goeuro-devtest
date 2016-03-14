package com.level4;

import sun.security.provider.certpath.OCSP;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by MyMac on 17/02/16.
 */
public class Revstring {
    public String reverseString(String a) {
        if(a==null){return a;}

        Stack<Character> stack = new Stack<>();

        for(char ch:a.toCharArray()){
            stack.push(Character.valueOf(ch));
        }

        char[] str= new char[a.length()];
        int i=0;
        while(stack.size()>0){
            str[i++]=stack.pop();
        }
        return new String(str);

    }


    public static void main(String[] args) {
        Revstring rev = new Revstring();
        System.out.print(rev.reverseString("bdf"));
    }
}

