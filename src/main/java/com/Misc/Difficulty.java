package com.Misc;

import java.util.*;

/**
 * Created by MyMac on 17/04/16.
 */
public class Difficulty {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int K=sc.nextInt();
        int[] tasks = new int[K];
        for(int i=0;i<K;i++){
            tasks[i]  = sc.nextInt();
        }

        if(K==1){
            System.out.println(tasks[0]);
        }
        else if(K==2){
            System.out.println(Max(tasks[0],tasks[1]));
        }
        else if(K==3){
            System.out.println(Max3(tasks[0],tasks[1],tasks[2]));
        }
        else{
            System.out.println(findDifficulty(tasks));
        }
    }


    static int Max(int a, int b){
        if(a>b){
            return a;
        }
        return b;
    }

    static int Max3(int a, int b, int c){
        int max =a;
        if(b > max){
            max = b;
        }
        if(c > max){
            max = c;
        }
        return max;
    }

    static int findDifficulty(int[] tasks){
        Arrays.sort(tasks);
        int val1, val2, val3;
        int len = tasks.length;
        val1 = tasks[len-1];
        val2= tasks[len-2];
        val3 = tasks[len-3];

        for(int i=len-4;i>=0;i--){
            int ce = tasks[i];
            if(ce + val3 <= val2){
                val3 = ce + val3;
            }
            else if(ce + val3 <= val1){
                int temp = val2;
                val2 = ce + val3;
                val3 = temp;
            }else if(ce >=val1 && val2 + val3<=ce){
                int t1= val1;
                int t2 = val2;
                val1=ce;
                val2 = val2+val3;
                val3 = t1;
            }
            else if(ce >= val1 && val1 + val3<=ce){
                int t1 = val1;
                val1 = ce;
                val2 = t1 + val3;
                val3 = val2;
            }
            else{
                int t1 = val1;
                val1 = ce + val3;
                val3 = val2;
                val2 = t1;
            }
        }
        return val1;
    }
}
