package com.level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by MyMac on 20/02/16.
 */
public class Evalexp {
    /*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, /. Each operand may be an integer or another expression.
   Examples:
   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */

    public int evalRPN(ArrayList<String> a) {

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<a.size();i++){
            String cur = a.get(i);
            if(cur=="+"){
                int num1= stack.pop();
                int num2 = stack.pop();
                stack.push(num1+num2);
            }else if(cur.equals("*")){
                int num1= stack.pop();
                int num2 = stack.pop();
                stack.push(num1*num2);
            }else if(cur.equals("/")){
                int num1= stack.pop();
                int num2 = stack.pop();
                stack.push(num2/num1);
            }else if(cur.equals("-")){
                int num1= stack.pop();
                int num2 = stack.pop();
                stack.push(num2-num1);
            }else{
                stack.push(Integer.parseInt(cur));
            }
        }
        return stack.peek();
    }


    public static void main(String[] args) {
        Evalexp exp = new Evalexp();
        System.out.print(exp.evalRPN(new ArrayList<String>(Arrays.asList("2", "2",  "/"))));
    }
}
