package com.level5;

import java.util.HashMap;

/**
 * Created by MyMac on 21/02/16.
 */
public class Colorful {

    // first find all subsequences and store their product in hashmap. if something comes back return false. else go on
    public int colorful(int a) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        //find subsquences starting with 1st int
        String s = String.valueOf(a);
        for(int i=0;i<s.length();i++){
            int prod=1;
            for(int length=0;length<s.length()-i;length++){
                prod = prod * Integer.parseInt((s.substring(i+length,i+length+1)));
                if(map.containsKey(prod)){
                    return 0;
                }else{
                    map.put(prod,true);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Colorful colorful = new Colorful();
        System.out.print(colorful.colorful(23));
    }
}
