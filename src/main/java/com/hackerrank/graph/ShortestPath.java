package com.hackerrank.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by MyMac on 25/03/16.
 */
public class ShortestPath {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T  = Integer.parseInt(sc.nextLine());
        while(T-->0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();

            ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
            for(int i=0;i < N+1;i++){
                adList.add(i, new ArrayList<Integer>());
            }

            for(int i=0; i<M;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                sc.nextLine();
                adList.get(x).add(y);
                adList.get(y).add(x);
            }
            int source = sc.nextInt();
            int[] sp = new int[N+1];
            Arrays.fill(sp, Integer.MAX_VALUE);
            sp[source]  = 0;

            boolean[] visited = new boolean[N+1];
            for(int i=1; i<=N; i++){
                   int element = findMin(visited ,sp);
                   ArrayList<Integer> ar = adList.get(element);
                   visited[element] = true;
                   for (Integer j : ar) {
                       if (!visited[j]) {
                           if(sp[element]!=Integer.MAX_VALUE) {
                               int cd = sp[element] + 6;
                               if (cd < sp[j]) {
                                   sp[j] = cd;
                               }
                           }
                       }
                   }
            }

            for(int i=1;i<=N;i++){
                if(i!=source){
                    if(sp[i]==Integer.MAX_VALUE){
                        System.out.print(-1+" ");
                    }
                    else {
                        System.out.print(sp[i]+" ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static int findMin(boolean[] visited, int[] sp) {
        int min = Integer.MAX_VALUE;
        int minD = Integer.MAX_VALUE;
        for(int v=1; v < sp.length; v++){
            if(!visited[v] && sp[v] <= minD){
                minD = sp[v];
                min = v;
            }
        }
        return min;
    }
}
