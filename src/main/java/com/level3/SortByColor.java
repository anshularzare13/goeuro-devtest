package com.level3;

import com.level6.SortedArrayToBST;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MyMac on 20/03/16.
 */
public class SortByColor
{

    public ArrayList<Integer> sortColors(ArrayList<Integer> a) {

        //The below method takes two pass,can i do it in one pass of the array.
        //yes i can take two pointers, start one from front other from end.
        // swap all 2's at the end and swap all one's at the beginning.
        //you will have sorted array.
        // int count1 =0, count2 =0, count3=0;

        //  for(int i=0; i <a.size();i++){
        //         if(a.get(i)==0){
        //             count1++;
        //         }
        //         else if(a.get(i)==1){
        //             count2++;
        //         }
        //         else if(a.get(i)==2){
        //             count3++;
        //         }
        //  }

        //  for(int i=0;i<a.size();i++){

        //      if(count1>0){
        //          a.set(i, 0);
        //          count1--;
        //      }
        //      else if(count2>0){
        //          a.set(i,1);
        //          count2--;
        //      }
        //      else if(count3>0){
        //          a.set(i,2);
        //          count3--;
        //      }
        //  }

        int start=0;int end=a.size()-1;
        if(a.size()==0 || a==null){
            return a;
        }

        while(end>=start && a.get(start)==0){
            start++;
        }


        while(end>=start && a.get(end)==2){
            end--;
        }

        for(int i=start;i<=end && end>=start;){
            if(a.get(i)==0){
                //swap with start..
                if(start!=i) {
                    a.set(i, a.get(start));
                    a.set(start, 0);
                }
                start++;
                i++;
            }
            else if(a.get(i)==2){
                //swap with end
                a.set(i, a.get(end));
                a.set(end, 2);
                end--;
            }
            else{
                i++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        SortByColor srb = new SortByColor();
        ArrayList<Integer> x = srb.sortColors(new ArrayList<Integer>(Arrays.asList(0, 2, 0, 0, 0, 2, 2, 0, 0, 1, 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 0, 2, 2, 0, 2, 0, 1, 0, 2, 2, 1, 2, 0, 1, 1, 0, 0, 0, 2, 1, 1, 2, 2, 0, 0, 1, 1, 0, 2, 0, 0, 0, 0, 2, 0, 1, 0, 2, 1, 0, 0, 1, 2, 1, 2, 0, 1, 2, 2, 2, 1, 2, 1, 1, 0, 2, 2, 0, 2, 2, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 2, 2, 1, 0, 2, 2, 0, 0, 1, 0, 1, 2, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 2, 0, 1, 1, 1, 2, 0, 1, 2, 2, 2, 2, 1, 0, 2, 2, 0, 0, 2, 2, 0, 1, 0, 1, 0, 2, 2, 1, 1, 0, 2, 2, 0, 2, 2, 2, 0, 1, 0, 0, 1, 2, 2, 0, 1, 1, 1, 2, 0, 1, 1, 2, 2, 2, 1, 1, 0, 2, 2, 2, 0, 0, 2, 2, 2, 0, 0, 0, 0, 1, 2, 1, 1, 1, 0, 0, 2, 0, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 2, 2, 1, 2, 1, 1, 2, 1, 2, 2, 2, 0, 1, 2, 0, 2, 1, 0, 1, 1, 0, 1, 1, 0, 0, 2, 0, 0, 1, 0, 2, 1, 2, 2, 1, 0, 2, 2, 1, 1, 0, 0, 0, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 1, 2, 1, 2, 0, 1, 2, 2, 2, 2, 0, 2, 2, 1, 0, 2, 0, 2, 1, 1, 1, 1, 0, 1, 0, 2, 2, 2, 2, 1, 0, 2, 0, 0, 0, 0, 0, 2, 1, 0, 0, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 0, 2, 2, 1, 1, 2, 2, 2, 0, 2, 0, 1, 1, 1, 0, 2, 2, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0, 1, 0, 1, 0, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 0, 1, 1, 2, 0, 2, 0, 2, 2, 1, 2, 2, 0, 1, 0, 2, 1, 2, 2, 2, 1, 0, 2, 2, 0, 1, 0, 2, 0, 0, 2, 2, 0, 0, 1, 2, 1, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 1, 1, 0, 2, 2, 0, 2, 2, 0, 2, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 1, 1, 0, 0, 2, 0, 1, 0, 1, 0, 2, 1, 1, 0, 2, 0, 1, 0, 2, 0, 2, 2, 1, 0 )));
        ArrayPrintUtil.print1DArray(x);
    }

}

