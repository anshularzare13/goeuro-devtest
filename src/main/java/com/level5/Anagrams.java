package com.level5;

import java.util.*;

/**
 * Created by MyMac on 21/02/16.
 */
public class Anagrams {

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {

        //for all words maintain hashmap.
        HashMap<String, Integer> hashMap  = new HashMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //for each word a new hashmap will be added if it is not an anagram of any of previous word.
        int count =0;
        for(int i=0; i < a.size();i++){
            String str = a.get(i);
            char[] chstr  = str.toCharArray();
            Arrays.sort(chstr);
            str = new String(chstr);
            if(hashMap.get(str)!=null){
                int val = hashMap.get(str);
                if(res.size()>val){
                    ArrayList<Integer> x = res.get(val);
                    x.add(i+1);
                }
            }else{
                hashMap.put(str,count++);
                ArrayList<Integer> y = new ArrayList<>();
                y.add(i+1);
                res.add(y);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Anagrams an = new Anagrams();
        for(ArrayList<Integer> arrayList : an.anagrams(Arrays.asList("cat","dog","tac","cta"))){
            for(Integer ix : arrayList){
                System.out.print(ix + " ");
            }
            System.out.println();
        }
    }
}
