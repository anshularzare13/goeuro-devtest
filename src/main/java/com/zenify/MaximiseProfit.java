package com.zenify;

/**
 * Created by skyhigh on 08/03/16.
 */
public class MaximiseProfit {


    static int maxProfit(int[] prices) {
        // imp thing to note is buy event should precede sell event.
           if(prices.length==0 || prices.length==1){
               return -1;
           }
           int globalProfit = 0, currentProfit=0;
           int indexMax = -1, indexMin = -1;
           int currentMin = Integer.MAX_VALUE, currentMax = Integer.MIN_VALUE;
           for(int index = 0; index < prices.length; index++){
               int currentVal = prices[index];
               if(currentVal > currentMax){
                   currentMax = currentVal;
                   indexMax = index;
               }
               if(currentVal < currentMin){
                   currentMin = currentVal;
                   indexMin = index;
               }
               currentProfit = currentMax-currentMin;
               if(currentProfit>globalProfit && indexMax>=indexMin){
                   globalProfit=currentProfit;
               }
           }
        if(globalProfit<=0){
            return -1;
        }
        return globalProfit;
    }


    public static void main(String[] args) {
        MaximiseProfit mp = new MaximiseProfit();
        System.out.println(mp.maxProfit(new int[]{}));
    }
}
