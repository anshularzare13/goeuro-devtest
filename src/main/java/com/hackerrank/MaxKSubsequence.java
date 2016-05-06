package com.hackerrank;

import java.util.Scanner;

/**
 * Created by MyMac on 09/04/16.
 */
public class MaxKSubsequence {
    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] array = new int[N];
            long count = 0;
            int pref_sum =0;
            int[] count_mod = new int[K];
            count_mod[0]=1;
            for(int i=0; i < array.length; i++)
            {
                array[i] = sc.nextInt();
                pref_sum+=array[i];
                pref_sum %= K;
                count_mod[pref_sum]++;
            }

            for(int i=0;i<K;i++){
                count += count_mod[i] *(count_mod[i]-1)/2;
            }

            System.out.println(count);
        }

    }
}
