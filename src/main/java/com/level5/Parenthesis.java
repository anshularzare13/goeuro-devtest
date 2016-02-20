package com.level5;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.ArrayList;

/**
 * Created by anshul on 20/02/16.
 */
public class Parenthesis {

    public ArrayList<String> generateParenthesis(int a) {

        int open=a,close=a;
        ArrayList<String> res= new ArrayList<>();
        StringBuilder str = new StringBuilder();
        res = gp(open,close,res,str);
        return res;
    }

    private ArrayList<String> gp(int open, int close, ArrayList<String> res, StringBuilder stringBuilder) {

        if(close==0){
            res.add(stringBuilder.toString());
            return res;
        }
        if(open==close || open>0){
            stringBuilder.append("(");
            res=gp(open-1, close, res,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        if(close>open){
            stringBuilder.append(")");
            res =gp(open,close-1,res,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return res;
    }

    public static void main(String[] args) {

        Parenthesis p = new Parenthesis();
        for(String s: p.generateParenthesis(4)){
            System.out.println(s);
        }

    }
}
