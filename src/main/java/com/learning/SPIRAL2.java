package com.learning;

import java.util.ArrayList;

/**
 * Created by MyMac on 12/01/16.
 */
public class SPIRAL2 {

    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {


        if(a==0){
            return null;
        }else{
            a=a-1;
        }
        int i,T=0, L=0, B=a, R=a;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(a);
        for(i=0;i <=a;i++){
            result.add(i,new ArrayList<Integer>());

        }
        for(i=0;i<=a;i++){
            for(int j=0;j<=a;j++){
                result.get(i).add(j,0);
            }
        }

        int dir=1;
        int count=0;

        while(T<=B && L<=R){
            if(dir==1){
                for(i=L;i<=R;i++){
                    result.get(T).set(i,++count );
                }
                T++;
                dir++;
            }else if(dir==2){
                for(i=T;i<=B;i++){
                    result.get(i).set(R, ++count);
                }
                R--;
                dir++;
            }else if(dir==3){
                for(i=R;i >= L;i--){
                    result.get(B).set(i, ++count);
                }
                B--;
                dir++;
            }else{
                for(i=B;i>=T;i--){
                    result.get(i).set(L, ++count);
                }
                L++;
                dir=1;
            }
        }

        return result;
    }

    public static void main(String[] args){
        SPIRAL2 s = new SPIRAL2();
        ArrayList<ArrayList<Integer>> arrayLists = s.generateMatrix(2);
        for(ArrayList<Integer> res : arrayLists){
            for( Integer i : res){
                System.out.print(i +" ");
            }
            System.out.println();
        }
    }

}
