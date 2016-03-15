package com.Tracxn;

import java.util.Stack;

/**
 * Created by MyMac on 16/03/16.
 */
public class RoundI {
    public static boolean canOrderTrucksInOrder(int[] incomingTruckOrder) {

        Stack<Integer> stack = new Stack<>();
        int count=1;

        for(int i=0;i<incomingTruckOrder.length;i++){
            //check if a[i]=count;
            if(incomingTruckOrder[i]==count){
                count++;
                continue;
            }else if(!stack.isEmpty() && stack.peek()==count){
                count++;
                stack.pop();
                continue;
            }else{
                stack.push(incomingTruckOrder[i]);
            }
        }
        while(!stack.isEmpty()){
            if(count!=stack.pop()){
                return false;
            }
            count++;
        }
        return true;
    }

    public static String decryptMessage(String encryptedMessage, int numberOfColumns) {

        if(encryptedMessage==null||encryptedMessage.length()==0){
            return encryptedMessage;
        }

        StringBuilder[] stringBuilder = new StringBuilder[numberOfColumns];
        for(int i=0;i<numberOfColumns;i++){
            stringBuilder[i] = new StringBuilder();
        }
        boolean leftToRight = true;

        for(int index=0;index<encryptedMessage.length();index++){
            if(index>0 && index%numberOfColumns==0){
                leftToRight=!leftToRight;
            }
            int colIndex = index%numberOfColumns;
            if(leftToRight) {
                stringBuilder[colIndex].append(encryptedMessage.charAt(index));
            }
            else{
                stringBuilder[numberOfColumns-1-colIndex].append(encryptedMessage.charAt(index));
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<numberOfColumns;i++){
            answer.append(stringBuilder[i].toString());
        }
        return answer.toString();
    }

    public static int getMaximumAmount(int coinValue) {

        int sum=0;
        if(coinValue<=0){
            return 0;
        }
        if(coinValue==1 || coinValue==2 || coinValue==3){
            sum+=coinValue;
            return sum;
        }

        int sum1 = getMaximumAmount(coinValue/2);
        int sum2 =  getMaximumAmount(coinValue/3);
        int sum3 =  getMaximumAmount(coinValue/4);
        if(sum1+sum2+sum3>coinValue){
            sum+=sum1+sum2+sum3;
        }
        else {
            sum+=coinValue;
        }
        return sum;
    }
}
