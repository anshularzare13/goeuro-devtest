package com.level4;

import java.util.ArrayList;

/**
 * Created by MyMac on 18/02/16.
 */
public class Simplifypath {

    public String simplifyPath(String a) {
        if(a=="/"||a==null){
            return a;
        }

        ArrayList<String> path = new ArrayList<>();
        int startIndex=0,in=0;
        String eachPath;

        while(true){
            int slash = a.indexOf('/',in+1);
            int endIndx=slash;
            if(slash==-1){
                endIndx=a.length();
            }
            eachPath=a.substring(in+1, endIndx);
            in=endIndx;
            if(eachPath.equals(".")){
                //do nothing.
            }else if(eachPath.equals("..") ){
                if(startIndex>0)
                    startIndex--;
            }
            else if(!eachPath.isEmpty()){
                if(path.size()>startIndex) {
                    path.set(startIndex, eachPath);
                }else{
                    path.add(startIndex,eachPath);
                }
                startIndex++;
            }
            if(in==a.length()){
                break;
            }
        }

        StringBuilder str = new StringBuilder();
        if(path.isEmpty()){
            str.append("/");
        }
       for(int i=0;i<startIndex;i++){
           str.append("/").append(path.get(i));
       }

    return str.toString();

    }

    public static void main(String[] args) {
        Simplifypath simplifypath = new Simplifypath();
        System.out.println(simplifypath.simplifyPath("/anshul/a/v//"));

    }
}
