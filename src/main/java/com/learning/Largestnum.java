package com.learning;

import java.util.*;

import static java.util.Collections.*;

/**
 * Created by MyMac on 16/01/16.
 */
public class Largestnum {

    public String largestNumber(final List<Integer> a) {

        List<Integer> copy = new ArrayList<Integer>(a);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);

                StringBuilder str1 = new StringBuilder();
                str1.append(s1).append(s2);

                StringBuilder str2 = new StringBuilder();
                str2.append(s2).append(s1);


                int index = str1.toString().compareTo(str2.toString());
                if (index > 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        Collections.sort(copy, comparator);
        StringBuilder str = new StringBuilder();
        Iterator<Integer> it = copy.iterator();
        while (it.hasNext()) {
            str.append(it.next());
        }

        String toReturn = str.toString();
        //remove most significant zeros if any
        if(toReturn.charAt(0)=='0'){
            toReturn="0";
        }
        return toReturn;
    }

    public static void main(String[] args) {
//        String s1 = "anshul";
//        String s2 = "arzare";
//        System.out.print(s2.compareTo(s1));
        Largestnum l = new Largestnum();
        List<Integer> input = (Arrays.asList(0,0,0));
        System.out.print(l.largestNumber(input));
    }
}