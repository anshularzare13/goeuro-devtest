package com.learning;

import java.util.ArrayList;

/**
 * Created by MyMac on 09/01/16.
 */
public class PLUS1 {


        public ArrayList<Integer> plusOne(ArrayList<Integer> a) {


            int size = a.size();
            ArrayList<Integer> result = new ArrayList<Integer>();
            // boundary cases.
            int i;
            boolean allzero = true;
            boolean allnine = true;
            int count=0;
            for (i = 0; count < size; i++) {
                count++;
                if (a.get(i) > 0) {
                    allzero = false;
                    break;
                }
                a.remove(i);
                i--;
            }
            if (allzero) {
                result.add(1);
                return result;
            }
            int num;
            int remainder =1;

            for(int last = a.size() -1 ; last >=0 ;last--){

                if(remainder!=0) {
                    num = a.get(last ) + remainder;
                    result.add(num%10);
                    num = num/10;
                    remainder = num%10;
                }else{
                    result.add(a.get(last));
                }

            }
            if(remainder!=0){
                result.add(remainder);
            }
            //reverse the array.
            int finalSize = result.size();
            int lengthOfarray = finalSize/2;
            if(finalSize%2==1){
                lengthOfarray = finalSize/2+1;
            }
            for( i = 0;i < lengthOfarray;i++){
                int temp;
                temp  = result.get(i);
                result.set(i, result.get(finalSize-1-i));
                result.set(finalSize-1-i, temp);
            }
            return result;
        }


        private int constructNumber(ArrayList<Integer> a) {
            int result = 0;
            for (int i = a.size(); i > 0; i--) {
                result = result + (int) (a.get(i-1) * Math.pow(10, a.size()-i));
            }
            return result;
        }
        public static  void main(String[] args){

            ArrayList<Integer> a = new ArrayList<Integer>();
//        a.add(1);
//        a.add(1);
//        a.add(1);
//        a.add(3);a.add(2);a.add(1);
//        a.add(1);a.add(2);a.add(5);
//        a.add(9);a.add(6);a.add(5);
//        a.add(0);
//        a.add(0);
//        a.add(6);
//        a.add(0);
            a.add(9);
            a.add(9);
            PLUS1 s = new PLUS1();
            for (Integer integer : s.plusOne(a)) {
                System.out.println(integer+" ");
            }

        }


    }
