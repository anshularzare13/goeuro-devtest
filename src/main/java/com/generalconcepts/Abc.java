package com.generalconcepts;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MyMac on 27/03/16.
 */
public class Abc {
    public static void main(String args[] ) throws Exception {
        String SLC = "//";
        String MLCS = "/*";
        String MLCE = "*/";
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String[] lines = new String[200];
        int count=0;
        while(sc.hasNextLine() && count <200){
            lines[count++]=sc.nextLine();
        }

        ArrayList<String> comments = new ArrayList<String>();
        //processing
        boolean isMulComment = false;
        for(int i=0;i<count;i++){
            String l = lines[i];
            l.trim();

            if(isMulComment){
                if(l.endsWith(MLCE)){
                    isMulComment = false;
                    comments.add(l);
                }
            }
            else{
                if(l.contains(SLC)){
                    l = l.substring(l.indexOf(SLC),l.length());
                    comments.add(l);
                }
                else if(l.startsWith(MLCS)){
                    comments.add(l);
                    if(!l.endsWith(MLCE)){
                        isMulComment  = true;
                    }
                }
            }
        }
        for(int i=0;i<comments.size();i++){
            System.out.println(comments.get(i));
        }
        sc.close();
    }
}
