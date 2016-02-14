package com.level3;

import java.util.Arrays;

/**
 * Created by MyMac on 11/02/16.
 */
public class Longestpalin {


    /*
    print longest palindromic substring and its length for a given string.
     */

    public String longestPalindromebruteForce(String a) {
    //First i'l try to code brute force approach coz that is imp to understand the question.
    int strIndex=0,len=0;
    for(int l=a.length();l>1;l--){

        for(int si=0;si<=a.length()-l;si++){

            //compute substring on which we need to verify whether palindrome or not.
            String sub = a.substring(si, si+l);
            if(isPalindrome(sub)){
                return sub;
            }
        }
    }

    return a.substring(0,1);
    }


    private boolean isPalindrome(String val) {
        char[] ch = val.toCharArray();
        int len  = ch.length;
        for(int i=0;i < len/2; i++){
            if(ch[i]!=ch[len-i-1]){
                return false;
            }
        }
        return true;

    }

    public String longestPalindromeoldapproach(String a){
        int n = a.length();
        //take 2D array of n+1,n+1
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            dp[i][i]=1;
        }


        //start from top to bottom.
        int maxLen =1,startIndex=0;
        for(int i=n-1; i>0;i--){

            for(int j=i+1;j<=n;j++){
                if(a.charAt(i-1)==a.charAt(j-1) && dp[i+1][j-1]==j-i-1){
                    dp[i][j]=2+dp[i+1][j-1];
                }else{
                    dp[i][j]=Max(dp[i+1][j],dp[i][j-1]);
                }

                if(dp[i][j] > maxLen || (dp[i][j]==maxLen && i<startIndex  && dp[i][j]==j-i+1)){
                    maxLen = dp[i][j];
                    startIndex=i;
                }
            }
        }
        if(startIndex==0){
            return a.substring(startIndex,startIndex+maxLen);
        }
        return a.substring(startIndex-1,startIndex+maxLen-1);






    }

    private int Max(int i, int i1) {

        if(i>i1){
            return i;
        }
        return i1;
    }


    public static void main(String[] args){


        Longestpalin lp = new Longestpalin();
        System.out.println(lp.longestPalindrome("aaaabaaa"));
    }

    private String longestPalindrome(String a) {
        int n = a.length();
        // take boolean dp to store whether dp[i][j] is palindrome or not.
        boolean[][] dp = new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                int l = j -i +1;
                if(l==2){
                    if(a.charAt(i)==a.charAt(j)){
                        dp[i][j]=true;
                    }
                }
                else{
                    if(dp[i+1][j-1] && a.charAt(i)==a.charAt(j)){
                        dp[i][j]=true;
                    }
                }
            }
        }
        //Now just traverse the 2D array and find max len palindrome having min index.

        int maxLen = 1, startIndex=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(dp[i][j]&& j-i+1> maxLen){
                    maxLen = j-i+1;
                    startIndex = i;
                }
            }
        }

        return a.substring(startIndex,startIndex+maxLen);
    }
}
