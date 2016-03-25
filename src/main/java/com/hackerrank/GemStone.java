package com.hackerrank;

/**
 * Created by MyMac on 23/03/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GemStone {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N==0){
            return;
        }
        int[] charArray = new int[26];
        int count=0;int sum=0;
        int temp=N;
        scanner.nextLine();
        while(temp-->0){
            String s = scanner.nextLine();
            for(int i=0;i<s.length();i++){
                int ch = s.charAt(i)-'a';
                if(charArray[ch]==count){
                    charArray[ch]=count+1;
                }
            }
            count++;
        }
        for(int i=0;i<26;i++){
            if(charArray[i]==N){
                sum++;
            }
        }
        System.out.println(sum);
    }
}