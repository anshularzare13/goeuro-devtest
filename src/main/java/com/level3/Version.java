package com.level3;

/**
 * Created by MyMac on 08/02/16.
 */
public class Version {

    public int compareVersion(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        int index1=0, index2=0,prev1 =0,prev2=0;
        int end1,end2;
        String p1,p2;
        long num1,num2;
        char ch;
        while(a.charAt(index1)=='0'){
            index1++;
        }
        while (b.charAt(index2)=='0'){
            index2++;
        }
        prev1 = index1;
        prev2 = index2;
        while(true) {
            if(index1 == -1 && index2==-1){
                return 0;
            }
            index1 =  a.indexOf('.',prev1);
            index2 = b.indexOf('.',prev2);

            end1 = index1!=-1?index1:a.length();
            end2 = index2!=-1?index2:b.length();
            if(prev1>end1){
                p1 = "0";
            }else{
                p1= a.substring(prev1, end1);
            }

            if(prev2>end2){
                p2 = "0";
            }
            else {
                p2 = b.substring(prev2, end2);
            }

            if(p1.length()>p2.length()){
                return 1;
            }else if(p2.length()>p1.length()){
                return -1;
            }else{
                int x= p1.compareTo(p2);
                if(x>0){
                    return 1;
                }else if(x<0){
                    return -1;
                }
            }

            prev1 =  end1+1;
            prev2= end2+1;
        }
    }


    public int compareVersion2(String a, String b){


        int index1=0, index2=0;
        char ch;
        while(a.charAt(index1)=='0'){
            index1++;
        }
        while (b.charAt(index2)=='0'){
            index2++;
        }
        while(true){

            char ch1,ch2;

            if(index1>=a.length() && index2>=b.length()){
                return 0;
            }
            if(index1 < a.length()) {
                 ch1 = a.charAt(index1);
            }else{
                ch1 = '0';
            }

            if(index2<b.length()) {
                 ch2 = b.charAt(index2);
            }else{
                ch2 = '0';
            }

            if(ch1=='.' && ch2=='.'){
                index1++;index2++;
                continue;
            }else if(ch1!='.'  &&ch1!='0' && ch2=='.'){
                return 1;
            }
            else if(ch1=='.' && ch2 !='.' && ch2!='0'){
                return -1;
            }
            else{
                if(ch1>ch2 && index1<a.length()){
                    return 1;
                }else if(ch2>ch1 && index2<b.length()){
                    return -1;
                }
            }
            index1++;index2++;
        }
    }

    private String removeStartZeros(String a) {


        return null;
    }


    public static void main(String[] args){
        Version version = new Version();
        System.out.println(version.compareVersion("01", "1"));
    }

}
