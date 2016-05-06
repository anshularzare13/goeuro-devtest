package com.Misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by noone on 05/05/16.
 */
public class UnEatenLeaves {

    static int unEatenLeaves(int N, int[] A){
        int cp = A.length;
        Set<Integer> leave = new HashSet<>();
        Arrays.sort(A);
        boolean hasEven;
        for(int i=0;i<cp;i++){
            if(A[i]==1)
                return 0;
            else if(leave.contains(A[i]))
                continue;
            else{
                int count=1;
                while (A[i]*count<=N){
                    if(!leave.contains(A[i]*count)){
                        leave.add(A[i]*count);
                    }
                    count++;
                }
            }
        }
        return N-leave.size();
    }

    public static void main(String[] args) {
        System.out.println(unEatenLeaves(10, new int[]{2,4,5}));

    }
}
