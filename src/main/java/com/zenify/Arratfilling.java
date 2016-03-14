package com.zenify;

import java.util.Scanner;

/**
 * Created by skyhigh on 08/03/16.
 */
public class Arratfilling {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        int N;
        Scanner sc = new Scanner(System.in);
        N  = sc.nextInt();
        int[][] arrayA = new int[N][];

        for(int i=0;i<N;i++){
            int y = sc.nextInt();
            arrayA[i] = new int[y];
            for(int j=0;j<y;j++){
                arrayA[i][j] = sc.nextInt();
            }
        }


        System.out.println(arrayA);
    }
}
