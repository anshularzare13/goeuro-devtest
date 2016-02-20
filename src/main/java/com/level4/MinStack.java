package com.level4;

import java.util.Stack;

/**
 * Created by MyMac on 20/02/16.
 */
public class MinStack {


    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    MinStack(){
        stack1.clear();
        stack2.clear();
    }

    public void push(int x) {
        stack1.push(x);

        if(stack2.size()!=0){
                if(stack2.peek()>x){
                    stack2.push(x);
                }
        }else{
            stack2.push(x);
        }
    }

    public void pop() {
        if(stack1.size()!=0){
            int num = stack1.pop();
            if(num==stack2.peek()){
                stack2.pop();
            }
        }
    }

    public int top() {
        if(stack1.size()>0) {
            return stack1.peek();
        }
        return -1;
    }

    public int getMin() {
        if(stack2.size()>0){
            return stack2.peek();
        }
        return -1;

    }


    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(5);//
        m.push(3);
        System.out.println(m.top());
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.top());
        System.out.println(m.getMin());

    }
}
