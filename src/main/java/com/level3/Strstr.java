package com.level3;

/**
 * Created by anshul on 03/02/16.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pritesh
 */
public class Strstr {

    public int strStr(final String haystack, final String needle) {


        //just try to implement brute force approach.
        int startIndex = 0;
        int lengthOfOrig = haystack.length();
        int lengthOfToken = needle.length();
        boolean isMatched = false;
        while (lengthOfOrig - startIndex >= lengthOfToken) {
            int tempIndex = startIndex;
            isMatched = true;
            int tokenIndex = 0;
            while(tokenIndex < lengthOfToken) {
                if(haystack.charAt(tempIndex) != needle.charAt(tokenIndex)) {
                    isMatched = false;
                    break;
                }
                tempIndex++;
                tokenIndex++;
            }
            if(isMatched){
                return startIndex;
            }
            startIndex++;
        }
        return -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // find needle from haystack. //if true return index of first matched char, else return -1/.
        String str1 = "";
        String str2 = "";
        // TODO code application logic here
        Strstr s = new Strstr();
        System.out.println(s.strStr(str1, str2));
    }
}

