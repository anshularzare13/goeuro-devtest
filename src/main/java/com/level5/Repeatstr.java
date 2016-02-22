package com.level5;

import java.util.HashMap;

/**
 * Created by MyMac on 22/02/16.
 */
public class Repeatstr {


    public int lengthOfLongestSubstring(String a) {
        //Take hashmap of char, Integer containing last index of a particular character..
        HashMap<Character, Integer> map = new HashMap<>();
        int[] dp = new int[a.length()];
        //dp storing length of substring(Non-repeating) at each index.

        int startIndex=0;
        int max=0;
        for(int i=0;i<a.length();i++){
            char ch = a.charAt(i);
            if(map.containsKey(ch)){
                int index  = map.get(ch);
                if(index>=startIndex){
                    startIndex = index+1;
                }
            }
            map.put(ch,i);
            for(int k=startIndex;k<=i;k++) {
                dp[k]++;
                if(dp[k]>max){
                    max=dp[k];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Repeatstr rp = new Repeatstr();
        System.out.println(rp.lengthOfLongestSubstring("anshulanshita"));

    }
}
