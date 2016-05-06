package com.VmWare;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MyMac on 08/04/16.
 */
public class SmartIDE {
    public static final String SINGLE_LINE_COMMENT = "//";
    public static final String MULTI_LINE_COMMENT_S = "/*";
    public static final String MULTI_LINE_COMMENT_E = "*/";

    public static void main(String[] args) {

        //read all lines first.

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        int count=0;
        while(count++<129 && scanner.hasNextLine()){
            arrayList.add(scanner.nextLine());
        }

        int len = arrayList.size();
        ArrayList<String> result = new ArrayList<>();
        boolean isMultiLineComment = false;
        for(int i=0; i < len; i++){
            String currentLine = arrayList.get(i);
            if(currentLine==null || currentLine.length()==0){
                continue;
            }

            if(!isMultiLineComment) {
                if (currentLine.contains(SINGLE_LINE_COMMENT)) {
                    currentLine = currentLine.substring(currentLine.indexOf(SINGLE_LINE_COMMENT), currentLine.length());
                } else if (currentLine.contains(MULTI_LINE_COMMENT_S)) {
                    currentLine = currentLine.substring(currentLine.indexOf(MULTI_LINE_COMMENT_S), currentLine.length());
                    isMultiLineComment = true;
                    if (currentLine.contains(MULTI_LINE_COMMENT_E)) {
                        isMultiLineComment = false;
                        currentLine = currentLine.substring(currentLine.indexOf(MULTI_LINE_COMMENT_S), currentLine.indexOf(MULTI_LINE_COMMENT_E) + 2);
                    }
                }else{
                    currentLine = "";
                }
            }else{
                if(currentLine.contains(MULTI_LINE_COMMENT_E)){
                    currentLine = currentLine.substring(0,currentLine.indexOf(MULTI_LINE_COMMENT_E)+2);
                    isMultiLineComment = false;
                }
            }

            if(currentLine!="") {
                result.add(currentLine.trim());
            }

        }
        for(int i =0 ;i < result.size();i++){
            System.out.println(result.get(i));
        }
    }
}



