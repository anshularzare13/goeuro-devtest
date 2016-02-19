package com.level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by MyMac on 19/02/16.
 */
public class Nearest {

    public ArrayList<Integer> prevSmallerBruteForce(ArrayList<Integer> arr) {
        //it can be done easily in O(n2). Let's see if we can do something better.
        //brute force approach. This is not the best approach, This is O(n2) algo.
        if(arr==null || arr.size()==0){
            return arr;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        for(int i=1;i<arr.size();i++){
            int j;
            for(j=i-1;j>=0;j--){
                if(arr.get(j) < arr.get(i) ){
                    arrayList.add(arr.get(j));
                    break;
                }
            }
            if(j<0){
                arrayList.add(-1);
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        //it can be done easily in O(n2). Let's see if we can do something better.
        //brute force approach. This is not the best approach, This is O(n2) algo.
        if(arr==null || arr.size()==0){
            return arr;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        arrayList.add(-1);
        stack.push(arr.get(0));
        for(int i=1;i<arr.size();i++){
            int num = arr.get(i);
            while(stack.size()!=0){
                if(stack.peek()>=num){
                    stack.pop();
                }else
                    break;
            }
            if(stack.size()>0){
                arrayList.add(stack.peek());
            }else{
                arrayList.add(-1);
            }
            stack.push(num);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Nearest nr = new Nearest();
        ArrayList<Integer> rs = nr.prevSmaller(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        for(Integer r : rs){
            System.out.print(r+ " ");
        }
        System.out.println();
    }
}
