package com.level3;

/**
 * Created by MyMac on 30/01/16.
 */
public class Sqrt {


    public int sqrt(int a) {
        int result=0;
            //time complexity of this is O(sqrt(n))
            // one should try to do it in O(logn)
            if(a==0){
                return 0;
            }else if(a==1){
                return 1;
            }
            int low=0, high = a;
            int mid;
            while(low<=high){
                mid = low + (high-low)/2;

                if(mid==0){
                    low = mid+1;
                    continue;
                }
                if(mid == a/mid && a%mid==0){
                    return mid;
                }

                if(mid >= a/mid){
                    high = mid-1;
                }else{
                    low = mid+1;
                    result = mid;
                }
            }
//            if((int) i*i==a){
//                return (int) i;
//            }else if(i*i>a){
//                return (int)i-1;
//            }
        return result;
    }

    public static void main(String[] args){

        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(5));

    }

}
