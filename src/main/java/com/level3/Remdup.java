package com.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MyMac on 13/02/16.
 */
public class Remdup {
    /*Remove duplicates from Sorted Array
    Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

    Note that even though we want you to return the new length, make sure to change the original array as well in place

    Do not allocate extra space for another array, you must do this in place with constant memory.
    */

    public int removeDuplicates(ArrayList<Integer> a) {
        int index=0;
        int e1,e2;
        int count=0;
        while(index<a.size()){
            e1 = a.get(index);
            a.set(count,e1);
            count++;
            //get last index of e1 in a
            int lastIndex = findLastOccurence(a, index, a.size() - 1, e1);
            index=lastIndex+1;
        }
        return count;
    }

    private int findLastOccurence(List<Integer> a, int start, int end, Integer i) {
        int firstIndex =-1;
        int low=start,high=end;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(a.get(mid).equals(i)){
                firstIndex=mid;
                low = mid+1;
            }else if(a.get(mid) > i){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return firstIndex;

    }

    public static void main(String[] args) {
        Remdup re = new Remdup();
        System.out.println(re.removeDuplicates(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3))));

    }
}
