package com.level6;

import com.level3.ArrayPrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MyMac on 05/03/16.
 */

class Word{
    char ch;
    int count;
    ArrayList<Word> wordArray;
    Word(char c){
        this.ch =c;
        wordArray=new ArrayList<>();
        count=1;
    }
}
public class ShortestUniquePath {

    //This can be done via binary tree.
    //but we need to populate every word in a tree character by character.

    ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> prefix(ArrayList<String> a) {
        Word head = new Word('A');
        head.count = Integer.MAX_VALUE;
        for (String str : a) {
            populateTree(str, head);
        }
        //Now traverse head of the tree to find out word prefixes.
//        buildList(head, builder);
//        //this will not be in order, but will be more optimize as we will not traverse a path twice.
//        return result;
//
        Word tmp = head;
        for(String s : a){
            boolean foundPrefix=false;
            StringBuilder builder = new StringBuilder();
            head = tmp;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                //first find whether if this char is repeating or not.
                ArrayList<Word> array = head.wordArray;
                for(int j=0;j<array.size();j++){
                    Word w  =array.get(j);
                    if(w.ch==ch){
                        builder.append(ch);
                        if(w.count==1){
                            foundPrefix = true;
                        }
                        head=w;
                        break;
                    }
                }
                if(foundPrefix){
                    break;
                }
            }
            result.add(builder.toString());
        }
        return result;
    }


    private void buildList(Word head, StringBuilder builder) {

        if(head.count==1){
            result.add(builder.toString());
            return;
        }
        ArrayList<Word> arrayList = head.wordArray;
        for (int i = 0; i < arrayList.size(); i++) {
            Word w = arrayList.get(i);
            builder.append(w.ch);
            buildList(w,builder);
            builder.deleteCharAt(builder.length()-1);
        }
        return;
    }

    private void populateTree(String str, Word head) {

        for(int i=0;i<str.length();i++){
            boolean notFound=true;
            char ch = str.charAt(i);
            //first find whether if this char is repeating or not.
            ArrayList<Word> array = head.wordArray;
            for(int j=0;j<array.size();j++){
                Word w  =array.get(j);
                if(w.ch==ch){
                    //word already found. increase the count.
                    w.count = w.count+1;
                    notFound=false;
                    head=w;
                    break;
                }
            }
            if(notFound){
                Word w = new Word(ch);
                head.wordArray.add(w);
                head=w;
            }
        }
    }

    public static void main(String[] args) {
        ShortestUniquePath sq = new ShortestUniquePath();
        for(String s: sq.prefix(new ArrayList<String>(Arrays.asList("zebra","dog","duck","dove")))){
            System.out.print(s+ " ");
        }
    }

}
