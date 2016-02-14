package com.learning.learning.part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by MyMac on 16/01/16.
 */
public class IntervalProblem {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        //first problem is to search closest greater number in given intervals.
        int start = newInterval.start;
        int end = newInterval.end;
        if(start > end){
            int temp = end;
            end = start;
            start = temp;
        }
        //do binary search on fucking interval array.
        // what will it return ?
        // Also need to understand its input and output criteria.
        //ok.
        // From a list of intervals, return an interval if one of the number lies between start to end.
        // If a number is not in any on the given intervals. then return 0.

        //New approach lets no do binary search. First lets try to understand how brute force linear algorithm will work.
        //traverse intervals and find closest larger number than start.

        //find closest interval.
        Interval close1 = new Interval();
        boolean liesInBetween1 = false;
        int indexOfClosest1 =0;
        int i;
        for(i = 0; i < intervals.size(); i++){
            Interval current = intervals.get(i);

            if(start >= current.start && start <= current.end){
                //start lies in this interval.
                close1 = current;

                liesInBetween1 = true;
                break;
            }else if(start < current.start){
                // we missed, previous interval is closest.
                break;
            }
            else if(start > current.end){
                close1 = current;
            }
        }
//        if(liesInBetween1) {
//            indexOfClosest1 = i;
//        }else{
//            indexOfClosest1 = i-1;
//        }

        indexOfClosest1 = i;


        boolean liesInBetween2 = false;
        Interval close2 = new Interval();

        int indexOfClosest2 =0;
        for(i = 0; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(end >= current.start && end <= current.end) {
                //start lies in this interval.
                close2 = current;
                liesInBetween2 = true;
                break;
            }
            else if(end < current.start){
                // we missed, previous interval is closest.
                break;
            }
            else if(end > current.end){
                close2 = current;
            }
        }
        if(liesInBetween2) {
            indexOfClosest2 = i;
        }else{
            indexOfClosest2 = i-1;
        }

        if(liesInBetween1 && liesInBetween2){
            Interval toBeInserted = new Interval(close1.start, close2.end);
            int count = indexOfClosest2 - indexOfClosest1 +1;
            int c=0;
            for(i = indexOfClosest1; c < count; ){
                c++;
                intervals.remove(i);
            }
            intervals.add(indexOfClosest1, toBeInserted);
        }else if(liesInBetween1){
            Interval tobeInserted = new Interval(close1.start, end);
            int count = indexOfClosest2 - indexOfClosest1 +1;
            int c=0;
            for(i = indexOfClosest1; c < count; ){
                c++;
                intervals.remove(i);
            }
            intervals.add(indexOfClosest1, tobeInserted);

        }else if(liesInBetween2){
            Interval tobeInserted = new Interval(start, close2.end);
            int count = indexOfClosest2 - indexOfClosest1 +1;
            int c=0;
            for(i = indexOfClosest1; c < count; ){
                c++;
                intervals.remove(i);
            }
            intervals.add(indexOfClosest1, tobeInserted);

        }else{
            Interval tobeInserted = new Interval(start, end);
            int count = indexOfClosest2 - indexOfClosest1 +1;
            int c=0;
            for(i = indexOfClosest1; c < count; ){
                c++;
                intervals.remove(i);
            }
            intervals.add(indexOfClosest1, tobeInserted);
        }
        return intervals;
    }

    public static void main(String[] args){
        IntervalProblem ip  = new IntervalProblem();
        //creating input..
        Interval i1 = new Interval(2,3);
        Interval i2 = new Interval(4,7);
        Interval i3 = new Interval(9,11);
        Interval i4 = new Interval(14, 19);

        ArrayList<Interval> input = new ArrayList<>();
        input.add(i1);input.add(i2);input.add(i3);input.add(i4);

        Interval insrt = new Interval(8,2);

        ip.insert(input, insrt);
    }
}


class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
}
