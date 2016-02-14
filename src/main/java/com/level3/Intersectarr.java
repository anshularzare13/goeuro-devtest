package com.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MyMac on 13/02/16.
 */
public class Intersectarr {

    // DO NOT MODIFY THE LISTS
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();
        //find first index of b[0] in a and if found add it and continue it so on..
        int l1 = a.size();
        int l2 = b.size();
        if (l1 > l2) {
            int start = 0, end = l1 - 1;
            int index = -1;
            for (Integer i : b) {
                //find first occurence of i in a.
                index = -1;
                if (start <= end && i <= a.get(end) && i >= a.get(start)) {
                    index = findFirstOccurence(a, start, end, i);
                }
                if (index != -1) {
                    result.add(i);
                    start = index + 1;
                }
            }
        } else {
            int start = 0, end = l2 - 1;
            int index = -1;
            for (Integer i : a) {
                //find first occurence of i in a.
                index = -1;
                if (start <= end && i <= b.get(end) && i >= b.get(start)) {
                    index = findFirstOccurence(b, start, end, i);
                }
                if (index != -1) {
                    result.add(i);
                    start = index + 1;
                }
            }

        }
        return result;

    }

    private int findFirstOccurence(List<Integer> a, int start, int end, Integer i) {
        int firstIndex =-1;
        int low=start,high=end;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(a.get(mid).equals(i)){
                firstIndex=mid;
                high=mid-1;
            }else if(a.get(mid) > i){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
    return firstIndex;

    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList( 1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101));
//                1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98));
//                4, 7, 10, 10, 15, 17, 19, 20, 24, 27, 27, 30, 31, 35, 40, 41, 42, 46, 48, 49, 50, 51, 54, 57, 62, 62, 63, 66, 67, 68, 69, 70, 71, 73, 74, 78, 80, 81, 92, 94, 99, 101 ));
        Intersectarr intersectarr = new Intersectarr();
        for(Integer x : intersectarr.intersect(a,b)){
            System.out.print(x + " ");
        }
    }

}
