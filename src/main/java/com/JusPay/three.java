package com.JusPay;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by MyMac on 25/03/16.
 */
public class three {

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] array =  new int[N];
        for(int i=0;i<N;i++){
            array[i] = sc.nextInt();
        }

        sc.nextLine();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        int next = c1;
        while(next!=-1 && !set.contains(next)){
            if(next==c2){
                System.out.println(c2);
                return;
            }
            set.add(next);
            next = array[next];
        }

        next = c2;
        Set<Integer> set1 = new HashSet<>();
        while(next!=-1 && !set1.contains(next)){
            if(set.contains(next)){
                System.out.println(next);
                return;
            }
            set1.add(next);
            next = array[next];
        }

        //if there is no meeting cell, printing -1
        System.out.println("-1");

    }

}
