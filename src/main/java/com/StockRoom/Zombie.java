package com.StockRoom;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;

/**
 * Created by anshul on 05/04/16.
 */
public class Zombie {


    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int dzc = sc.nextInt();
            sc.nextLine();
            String array = sc.nextLine();
            //base case
            int lengthOfFoodString = array.length();
            if (lengthOfFoodString < N) {
                System.out.println("abort mission:food");
                continue;
            }

            long[][] dp = new long[N + 1][lengthOfFoodString];

            for(int i = 0; i < N+1; i ++) {
                for(int j = 0; j < lengthOfFoodString; j ++) {
                    dp[i][j] = -1;
                }
            }

            for (int i = 0; i < lengthOfFoodString; i++) {
                if (i <= 10) {
                    long val = Long.valueOf(array.substring(0, i + 1));
                    if (val <= dzc) {
                        dp[1][i] = val;
                    }
                }
            }

            for (int i = 2; i <= N; i++) {
                for (int j = 0; j < lengthOfFoodString; j++) {
                    for (int k = 0; k < j; k++) {
                        if (j - k <= 10) {
                            long val = Long.valueOf(array.substring(k + 1, j + 1));
                            if (val <= dzc && dp[i - 1][k] != -1) {
                                dp[i][j] = Math.max(dp[i - 1][k] + val, dp[i][j]);
                            }
                        }
                    }
                }
            }

            long result = dp[N][lengthOfFoodString - 1];
            if (result != -1) {
                System.out.println(result);
            } else {
                System.out.println("abort mission: food");
            }

        }
    }
}
