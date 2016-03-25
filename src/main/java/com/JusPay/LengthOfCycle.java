package com.JusPay;

import java.util.Scanner;

/**
 * Created by MyMac on 25/03/16.
 */
public class LengthOfCycle {
        public static void main(String args[] ) throws Exception  {

        //* Read input from stdin and provide input before running
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] array = new int[N];
        for(int i=0;i<N;i++){
            array[i] = sc.nextInt();
        }

        int maxLength=0;
        int currentLength =0;
        boolean[] visited = new boolean[N];
        int[] lA = new int[N];
        for(int i=0;i<N;i++){
            lA = new int[N];
            if(!visited[i]){
                currentLength = findLength(array, array[i] , 0, visited, lA);
                if(currentLength>maxLength){
                    maxLength = currentLength;
                }
            }
        }
        System.out.println(maxLength);
    }

    private static int findLength(int[] array, int s, int length, boolean[] visited, int[] lA){


        if(s==-1 || array[s]==-1){
            return -1;
        }

        if(visited[s]){
            return length-lA[s];
        }

        visited[s] = true;
        lA[s] = length;
        return findLength(array, array[s], length+1, visited, lA);
    }
}
