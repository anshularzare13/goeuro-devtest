package com.level3;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by MyMac on 02/02/16.
 */
public class PalindromeString {

    public int isPalindrome(String a) {

        char[] ch = a.toCharArray();
        int len = ch.length;
        int forwdindex= 0;
        int bckIndex = len-1;
        while(forwdindex<=bckIndex){
            char temp = 0, frwd = 0, bck = 0;
            while(forwdindex<len && !isAlphaNumeric(temp=ch[forwdindex++]));
            frwd = temp;
            while(bckIndex>=0 && !isAlphaNumeric(temp=ch[bckIndex--]));
            bck = temp;
            frwd = Character.toLowerCase(frwd);
            bck = Character.toLowerCase(bck);
            if(isAlphaNumeric(bck) && isAlphaNumeric(frwd) && Character.valueOf(frwd).compareTo(Character.valueOf(bck))!=0){
                return 0;
            }
            }
        return 1;
    }

    private boolean isAlphaNumeric(char ch){
        if(ch >= 'a' && ch <='z'){
            return true;
        }else if(ch >='A' && ch <= 'Z'){
            return true;
        }else if(ch >='0' && ch <= '9'){
            return true;
        }
        return false;
    }



    public static void main(String[] args){
        PalindromeString palindromeString = new PalindromeString();
        System.out.println(palindromeString.isPalindrome(".,"));
    }
}
