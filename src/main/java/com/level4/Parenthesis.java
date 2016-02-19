package com.level4;

import java.util.Stack;

/**
 * Created by MyMac on 17/02/16.
 */
public class Parenthesis {


    public int isValid(String a) {

        Stack<Character> stack = new Stack<>();
        char[] charArray = a.toCharArray();
        int index=0;
        while(index<charArray.length){
            char ch = charArray[index];
            // if opening bracket then try to push.
            // if closing bracket then pop and check if it has opening bracket of same type.
            // if yes, then continue. else return 0.
            if(ch=='['||ch=='{'||ch=='('){
                stack.push(ch);
            }else{
                if(stack.size()==0){
                 return 0;
                }
                char top = stack.pop();
                if(ch==']' && top!='[' || ch=='}' && top!='{' || ch==')' && top!='(')
                    return 0;
            }
            index++;
        }
        if(stack.size()==0){
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        System.out.print(parenthesis.isValid("[{"));

    }
}
