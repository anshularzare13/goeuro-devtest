package com.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by MyMac on 19/03/16.
 */
public class MaxElement {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc  = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        while(N-->0){
            int m = sc.nextInt();
            switch(m){
                case 1:
                    int element = sc.nextInt();
                    stack.push(element);

                    if(!maxStack.empty()){
                        int top = maxStack.peek();
                        if(element >= top){
                            maxStack.push(element);
                        }
                    }else{
                        maxStack.push(element);
                    }
                    break;

                case 2:
                    if(!stack.empty()) {
                        int top = stack.pop();
                        if(!maxStack.empty() && top == maxStack.peek()){
                            maxStack.pop();
                        }
                    }
                    break;

                case 3:
                    if(!maxStack.empty()){
                        System.out.println(maxStack.peek());
                    }
                    break;
            }
        }
        sc.close();
    }
}
