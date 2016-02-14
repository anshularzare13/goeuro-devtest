package com.level3;

import java.util.List;

/**
 * Created by MyMac on 13/02/16.
 */
public class Single {
    // DO NOT MODIFY THE LIST
    public int singleNumber(final List<Integer> a) {
        int res = a.get(0);
        for(int i=1;i<a.size();i++){
            res = res ^a.get(i);
        }
        return res;
    }

}
