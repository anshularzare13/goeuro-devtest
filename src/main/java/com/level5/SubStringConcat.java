package com.level5;

import java.util.*;

/**
 * Created by MyMac on 27/02/16.
 */
public class SubStringConcat {


    public ArrayList<Integer> findSubstring(String a, final List<String> b) {

        //fill the hashmap with all entries of given word.
        //words can be same as well.
        //Can also save number of occurences of each word.
        HashMap<String, Integer> map = new HashMap<>();
        int sizeOfList = b.size();
        int sizeOfEachWord = b.get(0).length();
        for(String str : b) {
            if (map.containsKey(str)) {
                int val = map.get(str);
                map.put(str, val+1);
            }else {
                map.put(str, 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int totalSize = sizeOfEachWord*sizeOfList;
        //Now once we have map filled we can find desired result by traversing maps and find indexes.

        for(int j=0;j<=a.length()-totalSize;j++){
            HashMap<String, Integer> localhash = new HashMap<>();
            localhash.putAll(map);
            boolean isTrue = true;
            for(int i=j;i<j+totalSize;i=i+sizeOfEachWord) {
                String key = a.substring(i,i+sizeOfEachWord);
                if(localhash.containsKey(key))
                {
                    int val = localhash.get(key);
                    if(val==1){
                        localhash.remove(key);
                    }
                    else{
                        localhash.put(key,val-1);
                    }
                }
                else
                {
                    break;
                }
            }
            if(localhash.size()==0){
                result.add(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubStringConcat subStringConcat = new SubStringConcat();
        for(Integer I:subStringConcat.findSubstring("abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa", Arrays.asList("cac","aaa","aba","aab","abc"))){
            System.out.print(I+" ");
        }
//0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98
    }
}
