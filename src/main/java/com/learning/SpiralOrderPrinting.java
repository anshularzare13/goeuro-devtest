package com.learning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyMac on 09/01/16.
 */
public class SpiralOrderPrinting {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // find size of a, number of rows = m, number of columns = n.
        int m = a.size();
        int n = a.get(0).size();
        int T = 0, B=m-1, L=0,R=n-1;
        int dir =0,i;
        while(T<=B && L <=R){
            if(dir==0){
                for(i=L; i<=R; i++) {
                    result.add(a.get(T).get(i));
                }
                T++;
                dir=1;
            }else if(dir==1){
                for(i=T; i<=B;i++){
                    result.add(a.get(i).get(R));
                }
                R--;
                dir=2;
            }else if(dir==2){
                for(i=R;i>=L;i--){
                    result.add(a.get(B).get(i));
                }
                B--;
                dir=2;
            }else if(dir==3) {
                for(i=B;i>=T;i--){
                    result.add(a.get(i).get(L));
                }
                L++;
                dir=0;
            }

        }
        return result;
    }




}
