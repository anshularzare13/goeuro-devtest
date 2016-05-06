package com.Misc;

import java.util.Arrays;

/**
 * Created by MyMac on 14/04/16.
 */
public class NBricks {
    private long[] dp;
    private int N;
    NBricks(int N){
        this.N = N;
        this.dp = new long[this.N+1];
        Arrays.fill(dp,0);
    }

    private long getArrangements(){
        if(N<=0){
            return 0;
        }
        int temp = N/2;
        int remaining  = N;
        long arrangments = 0;
        int c = 0;
        while(c<=temp){
            if(c==0 || remaining==0 || remaining==N){
                arrangments+=1;
            }
            else{
                arrangments += factorial(c+remaining)/(factorial(c)*factorial(remaining));
            }
            c++;
            remaining=remaining-2;
        }
        return arrangments;
    }

    private long factorial(int number) {
        if(number==0){
            return 1;
        }
        if(dp[number]!=0){
            return dp[number];
        }
        dp[number] = number*factorial(number-1);
        return dp[number];
    }


    public static void main(String[] args) {
        NBricks nBricks = new NBricks(8);
//        System.out.println(nBricks.getArrangements());
        //Basically number of unique arrangments seems to be following fibbonaci series.
        System.out.println(nBricks.getArrangementsEffectively(6));

    }

    private int getArrangementsEffectively(int N) {
        if(N==0 || N==1 || N==2){
            return N;
        }
        int x = 1;
        int y = 2;
        int result = 0;
        for(int i=3;i<=N;i++){
            result = x+y;
            x=y;
            y=result;
        }
        return result;
    }
}
