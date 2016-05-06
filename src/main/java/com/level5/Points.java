package com.level5;

import java.util.*;

/**
 * Created by anshul on 23/02/16.
 */
public class Points {
    private HashMap<Double, Integer> hashMap;

    public int maxPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        hashMap = new HashMap<>();
        if (A == null || B == null)
            return -1;

        if (A.size() == 0)
            return 0;

        if(A.size()==1)
            return 1;

        int n = A.size();
        int x1, y1, x2, y2;
        int val;
        int max = 0;

        for (int i = 0; i < n; i++) {

            x1 = A.get(i);
            y1 = B.get(i);
            hashMap.clear();

            for (int j = i+1; j < n; j++) {

                if (i == j)
                    continue;

                x2 = A.get(j);
                y2 = B.get(j);

                double slope = y2 - y1;
                int den = x2 - x1;

                if (den == 0)
                    slope = Double.POSITIVE_INFINITY;
                else
                    slope = slope / den;

                val = 1;

                if(slope==-0.0){
                    slope=0.0;
                }

                if (hashMap.containsKey(slope)) {
                    val = hashMap.get(slope) + 1;
                }

                hashMap.put(slope, val);

            }
            for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
                val = entry.getValue();
                max = Math.max(max, val);
            }

        }



        return max +1;
    }



    public static void main(String[] args) {
        Points p = new Points();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        int i=0;
        while (i++<N){
            one.add(sc.nextInt());
            two.add(sc.nextInt());
        }
        System.out.print(p.maxPoints(one,two));

    }
}
//6 -6 -17 5 -16 -18 -17 2 -4 5 -13 -2 20