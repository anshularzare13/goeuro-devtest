package com.zenify;

/**
 * Created by MyMac on 08/03/16.
 */
public class SecretMessage {

    static int[] encrypt(String[] words) {
        int size=words.length;
        int[] result = new int[size];
        for(int i=0;i<size;i++){
            String currentWord = words[i];
            int len = currentWord.length();
            int left,right,minOps=0;
            left=len/2-1;
            if(len%2==0){
                right = len/2;
            }else{
                right = len/2+1;
            }
            while(left>=0 && right<len){
                minOps+=Math.abs(currentWord.charAt(left)-currentWord.charAt(right));
                left--;
                right++;
            }
            result[i] = minOps;
        }
        return result;
    }


    public static void main(String[] args) {
        SecretMessage sm = new SecretMessage();
        for(int i : sm.encrypt(new String[]{"abc" ,"abcba","abcd","abcdef"})){
            System.out.println(i);
        }
    }
}
