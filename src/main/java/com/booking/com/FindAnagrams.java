package com.booking.com;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * Created by skyhigh on 22/02/16.
 */
public class FindAnagrams {
    /*
    Given two strings, str1,str2 find minimum number of characters that should be removed for making it an anagram.
    Eg[ read,dear -> 0]
     [man, made] ->2
     [read,reader] ->2].
     */

    private static int minChars(String s1, String s2){
       //How did i solved this problem
        // I have used hashmap to solve this problem, let me use them again.
        HashMap<Character, Integer> hash1 = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            if(hash1.containsKey(ch)){
                hash1.put(ch, hash1.get(ch)+1);
            }else{
                hash1.put(ch,1);
            }
        }

        int minChars = 0;

        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(hash1.containsKey(ch)){
                int val = hash1.get(ch);
                if(val==1){
                    hash1.remove(ch);
                }else{
                    hash1.put(ch,val-1);
                }
            }else{
                minChars++;
            }
        }

        Collection<Integer> values = hash1.values();
        for(Integer i : values)
        {
            minChars+=i;
        }
        return minChars;

    }


    public static void main(String[] args) {
        FindAnagrams fa = new FindAnagrams();
        System.out.println(fa.minChars("abc","bb"));

    }
}