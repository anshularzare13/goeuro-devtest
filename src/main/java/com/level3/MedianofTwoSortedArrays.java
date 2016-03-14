package com.level3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MyMac on 07/03/16.
 */
public class MedianofTwoSortedArrays {

    //This question can be easily if size of both is same otherwise not that easy.
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        int m = a.size();
        int n = b.size();
        return findMedian(a, b, 0, m);
//        }else{
//            return findMedian(b, a, 0, n);
//        }
    }

    private double findMedian(List<Integer> a, List<Integer> b, int imin, int imax) {
        int mid1 = (imin + imax)/2;
        int mid2 = (a.size() + b.size() +1)/2 - mid1;
        if(b.get(mid2-1) > a.get(mid1)){
            return findMedian(a,b,mid1+1,imax);
        }else if(a.get(mid1-1)>b.get(mid2)){
            return findMedian(a,b,imin,mid1-1);
        }else{
            if((a.size()+b.size())%2==1){
                return Max(a.get(mid1-1),b.get(mid2-1));
            }
            return ( (double) Max(a.get(mid1-1),b.get(mid2-1)) + (double) Min(a.get(mid1),b.get(mid2)))/2;
        }
    }


    private Integer Min(Integer integer, Integer integer1) {
        if(integer<integer1)
            return integer;
        return integer1;
    }

    private Integer Max(Integer integer, Integer integer1) {
        if(integer>integer1){
            return integer;
        }
        return integer1;
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays md = new MedianofTwoSortedArrays();
        List<Integer> l1 = Arrays.asList(15,61,81,91);
        List<Integer> l2 = Arrays.asList(1,2,3,4,16);
        System.out.println(md.findMedianSortedArrays(l1,l2));
    }
}
