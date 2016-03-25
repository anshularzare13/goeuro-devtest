package com.level3;

/**
 * Created by MyMac on 20/03/16.
 */
public class ReverseString {
    public String reverseWords(String a) {
        if(a.length()==0 || a==null){
            return a;
        }
        String[] args = a.split(" ");
        StringBuilder str = new StringBuilder();
        for(int i=args.length-1;i>=0;i--){
            if(!args[i].isEmpty()) {
                if (i != args.length - 1) {
                    str.append(" ");
                }
                str.append(args[i].trim());
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseWords("fwbpudnbrozzifml osdt  ulc jsx kxorifrhubk ouhsuhf  sswz qfho dqmy  sn myq igjgip iwfcqq"));
    }
}
