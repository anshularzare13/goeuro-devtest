package com.level3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MyMac on 01/02/16.
 */
public class Searchrotated {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {

        int low = 0, high = a.size()-1;
        int mid;


        while(low<=high){
            mid = low + (high-low)/2;
            if(a.get(mid)==b){
                return mid;
            }
            else if(a.get(mid) <= b && b<=a.get(high)){
                low = mid+1;

            }else if(a.get(low) <=b && b<=a.get(mid)){
                high = mid-1;
            }
            else if(a.get(low)<=a.get(mid)){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }




    public static void main(String[] args){
        Searchrotated searchrotated = new Searchrotated();
        List<Integer> inp  = Arrays.asList(4,5,6,7,0,1,2);
        System.out.println(searchrotated.search(inp, 16));

    }
}
