package com.level3;

import java.util.ArrayList;

/**
 * Created by MyMac on 08/03/16.
 */
public class ValidIPAddres {

    private ArrayList<String> result;
    ValidIPAddres(){
        result = new ArrayList<>();
    }

    public ArrayList<String> restoreIpAddresses(String a) {
        if(a.length()<4){
            return null;
        }
        ///this can be done via backtracking and recursion.
        //I have to put three dots.
        StringBuilder str = new StringBuilder();
        return findIP(a, 0, 3, str);
    }

    private ArrayList<String> findIP(String a, int currentIndex, int rDots, StringBuilder str) {

        if(rDots==0){
            String toAppendAtLast = a.substring(currentIndex,a.length());
            if(isValidIp(toAppendAtLast)) {
                str.append(toAppendAtLast);
                result.add(new String(str.toString()));
                str.delete(str.lastIndexOf(".")+1,str.length());
            }
            return result;
        }


        for(int i=currentIndex;i<a.length()  && rDots>0;i++){
            str.append(a.charAt(i));
            String now =str.toString();
            int lastIndexofDot = now.lastIndexOf(".");
            String fin;
            if(lastIndexofDot==-1){
                fin = now;
            }else{
                fin = now.substring(lastIndexofDot+1, now.length());
            }
            if(isValidIp(fin)){
                str.append(".");
                rDots--;
                findIP(a,i+1,rDots,str);
                if(str.charAt(str.length()-1)=='.'){
                    rDots++;
                }
                str.deleteCharAt(str.length()-1);
            }else{
                str.delete(str.lastIndexOf(".")+1,str.length());
                return result;
            }
        }
        str.delete(str.lastIndexOf(".")+1,str.length());
        return result;
    }

    private boolean isValidIp(String fin) {
        if(fin.equals("") || fin==null || fin.length()>3 || (fin.startsWith("0") && fin.length()>1)){
            return false;
        }
        int i = Integer.parseInt(fin);
        if(i>=0 && i<=255){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidIPAddres vp = new ValidIPAddres();
        for(String s:vp.restoreIpAddresses("0100100")){
            System.out.println(s);
        }
    }

}
