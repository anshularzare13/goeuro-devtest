package com.level3;

/**
 * Created by anshul on 02/02/16.
 */
public class Lengthlast {

    public int lengthOfLastWord(final String a) {

        int fin=0, len=0;
        char[] ch = a.toCharArray();
        int index=0,length = ch.length;
        while(index < length){
            if(ch[index]==' '){
                if(len!=0) {
                    fin = len;
                }
                len=0;
            }else{
                len++;
            }
            index++;
        }

        if(len==0){
            return fin;
        }
        return len;
    }


    public static void main(String[] args){
        Lengthlast l = new Lengthlast();
        System.out.println(l.lengthOfLastWord(" hello   worlds "));

    }
}
