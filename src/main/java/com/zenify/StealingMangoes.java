package com.zenify;

/**
 * Created by MyMac on 08/03/16.
 */
public class StealingMangoes {


    static int stealMangoes(int[] num) {
        if(num.length==0){
            return 0;
        }

        if(num.length==1){
            return num[0];
        }
        if(num.length==2){
            return Max(num[0],num[1]);
        }
        int size = num.length;
        int[] dp = new int[size];
        boolean[] haslastElement = new boolean[size];

        dp[0] = num[0];
        haslastElement[0] = true;

        if(dp[0]>num[1])
        {
            dp[1]=dp[0];
            haslastElement[1]=false;
        }
        else{
            dp[1]=num[1];
            haslastElement[1]=true;
        }
        //populate dp with correct values.
        for(int i=2;i<num.length;i++){
            if(haslastElement[i-1]){
                if(dp[i-2]+num[i]>dp[i-1]){
                    haslastElement[i]=true;
                    dp[i] = dp[i-2] + num[i];
                }
                else{
                    dp[i] = dp[i-1];
                    haslastElement[i]=false;
                }
            }else{
                dp[i] = dp[i-1]+num[i];
                haslastElement[i]=true;
            }
        }
        return dp[size-1];
    }

    private static int Max(int i, int i1) {
        if(i>i1) {return i;}
        return i1;
    }


    public static void main(String[] args) {
        StealingMangoes sm = new StealingMangoes();
        System.out.println(sm.stealMangoes(new int[]{}));

    }
}
