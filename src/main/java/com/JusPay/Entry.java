package com.JusPay;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by MyMac on 25/03/16.
 */
public class Entry {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] entryCount = new int[N];
        int max = 0, num;
        for (int i = 0; i < N; i++) {
            num = sc.nextInt();
            if(num!=-1) {
                entryCount[num]++;
                if (entryCount[num] > max) {
                    max = entryCount[num];
                }
            }
        }
        System.out.println(max);


    }
}