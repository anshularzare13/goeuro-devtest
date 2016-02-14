package com.level3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MyMac on 13/02/16.
 */
public class Maxone {


    public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        int stIndex=0;
        int maxLen =0;
        for(int i=0;i< a.size();i++){
            int noOfFlip=b;
            int currentLength=0;
            int j=i;
            while(j<a.size()&&noOfFlip>=0){
                if(a.get(j)==1){
                    currentLength++;
                }else if(noOfFlip>0){
                    noOfFlip--;
                    currentLength++;
                }else{
                    break;
                }
                j++;
            }
            if(currentLength>maxLen){
                maxLen = currentLength;
                stIndex=i;
            }
        }
        ArrayList<Integer> rs = new ArrayList<>();
        for(int i=0;i<maxLen;i++){
            rs.add(stIndex++);
        }
        return rs;
    }


    public static void main(String[] args){
        Maxone max = new Maxone();
        for(Integer i : max.maxone(new ArrayList<Integer>(Arrays.asList(1,1,0,1,1,0,0,1,1,1)),2)){
                System.out.println(i+" ");
        }
    }

}
