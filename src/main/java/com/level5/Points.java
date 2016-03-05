package com.level5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anshul on 23/02/16.
 */
public class Points {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a.size()==0){
            return 0;
        }

        if(a.size()==1 || a.size()==2){
            return a.size();
        }
        int max=2;
        HashMap<Float, ArrayList<Integer>> slopeMap = new HashMap<>();
        HashMap<Float, ArrayList<ArrayList<Integer>>> indexm=new HashMap<>();
        for(int i=1;i<a.size();i++){
            for(int j=0;j<i;j++){
                Float aFloat = findSlope(a,b,i,j);
                if(aFloat==1f && a.get(i)==a.get(j) && b.get(i)==b.get(j)){
                    if (slopeMap.containsKey(aFloat)) {
                        ArrayList<Integer> valArray = slopeMap.get(aFloat);
                        ArrayList<ArrayList<Integer>> arrList = indexm.get(aFloat);
                        boolean areNewpoints = true;
                        for (int k = 0; k < arrList.size(); k++) {
                            ArrayList<Integer> arr = arrList.get(k);
                            if (!arr.contains(i) && arr.contains(j)) {
                                int val = valArray.get(k);
                                val++;
                                arr.add(i);
                                valArray.set(k, val);
//                                indexm.put(aFloat, arrList);
//                                slopeMap.put(aFloat, valArray);
                                areNewpoints = false;
                                if (val > max) {
                                    max = val;
                                }
                                break;
                            } else if (arr.contains(i) && arr.contains(j)) {
                                areNewpoints = false;

                            }
                        }
                        if (areNewpoints) {
                            valArray.add(2);
                            ArrayList<Integer> x = new ArrayList<>();
                            x.add(i);
                            x.add(j);
                            arrList.add(x);
                        }
                    } else {
                        ArrayList<Integer> n = new ArrayList<>();
                        n.add(2);
                        slopeMap.put(aFloat, n);
                        ArrayList<Integer> x = new ArrayList<>();
                        x.add(j);
                        x.add(i);
                        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
                        res.add(x);
                        indexm.put(aFloat, res);
                    }

                    aFloat=0f;
                    if (slopeMap.containsKey(aFloat)) {
                        ArrayList<Integer> valArray = slopeMap.get(aFloat);
                        ArrayList<ArrayList<Integer>> arrList = indexm.get(aFloat);
                        boolean areNewpoints = true;
                        for (int k = 0; k < arrList.size(); k++) {
                            ArrayList<Integer> arr = arrList.get(k);
                            if (!arr.contains(i) && arr.contains(j)) {
                                int val = valArray.get(k);
                                val++;
                                arr.add(i);
                                valArray.set(k, val);
//                                indexm.put(aFloat, arrList);
//                                slopeMap.put(aFloat, valArray);
                                areNewpoints = false;
                                if (val > max) {
                                    max = val;
                                }
                                break;
                            } else if (arr.contains(i) && arr.contains(j)) {
                                areNewpoints = false;

                            }
                        }
                        if (areNewpoints) {
                            valArray.add(2);
                            ArrayList<Integer> x = new ArrayList<>();
                            x.add(i);
                            x.add(j);
                            arrList.add(x);
                        }
                    } else {
                        ArrayList<Integer> n = new ArrayList<>();
                        n.add(2);
                        slopeMap.put(aFloat, n);
                        ArrayList<Integer> x = new ArrayList<>();
                        x.add(j);
                        x.add(i);
                        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
                        res.add(x);
                        indexm.put(aFloat, res);
                    }

                    aFloat=Float.MAX_VALUE;
                    if (slopeMap.containsKey(aFloat)) {
                        ArrayList<Integer> valArray = slopeMap.get(aFloat);
                        ArrayList<ArrayList<Integer>> arrList = indexm.get(aFloat);
                        boolean areNewpoints = true;
                        for (int k = 0; k < arrList.size(); k++) {
                            ArrayList<Integer> arr = arrList.get(k);
                            if (!arr.contains(i) && arr.contains(j)) {
                                int val = valArray.get(k);
                                val++;
                                arr.add(i);
                                valArray.set(k, val);
//                                indexm.put(aFloat, arrList);
//                                slopeMap.put(aFloat, valArray);
                                areNewpoints = false;
                                if (val > max) {
                                    max = val;
                                }
                                break;
                            } else if (arr.contains(i) && arr.contains(j)) {
                                areNewpoints = false;

                            }
                        }
                        if (areNewpoints) {
                            valArray.add(2);
                            ArrayList<Integer> x = new ArrayList<>();
                            x.add(i);
                            x.add(j);
                            arrList.add(x);
                        }
                    } else {
                        ArrayList<Integer> n = new ArrayList<>();
                        n.add(2);
                        slopeMap.put(aFloat, n);
                        ArrayList<Integer> x = new ArrayList<>();
                        x.add(j);
                        x.add(i);
                        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
                        res.add(x);
                        indexm.put(aFloat, res);
                    }
                }
                else {
                    if (slopeMap.containsKey(aFloat)) {
                        ArrayList<Integer> valArray = slopeMap.get(aFloat);
                        ArrayList<ArrayList<Integer>> arrList = indexm.get(aFloat);
                        boolean areNewpoints = true;
                        for (int k = 0; k < arrList.size(); k++) {
                            ArrayList<Integer> arr = arrList.get(k);
                            if (!arr.contains(i) && arr.contains(j)) {
                                int val = valArray.get(k);
                                val++;
                                arr.add(i);
                                valArray.set(k, val);
//                                indexm.put(aFloat, arrList);
//                                slopeMap.put(aFloat, valArray);
                                areNewpoints = false;
                                if (val > max) {
                                    max = val;
                                }
                                break;
                            } else if (arr.contains(i) && arr.contains(j)) {
                                areNewpoints = false;

                            }
                        }
                        if (areNewpoints) {
                            valArray.add(2);
                            ArrayList<Integer> x = new ArrayList<>();
                            x.add(i);
                            x.add(j);
                            arrList.add(x);
                        }
                    } else {
                        ArrayList<Integer> n = new ArrayList<>();
                        n.add(2);
                        slopeMap.put(aFloat, n);
                        ArrayList<Integer> x = new ArrayList<>();
                        x.add(j);
                        x.add(i);
                        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
                        res.add(x);
                        indexm.put(aFloat, res);
                    }
                }
            }
    }
    return max;
}

    private Float findSlope(ArrayList<Integer> a, ArrayList<Integer> b, int i, int j) {
        // points lie on same vertical line (i.e if x[i] & x[j] is same then slope is infinity.
        float X1=a.get(i);
        float X2=a.get(j);
        float Y1=b.get(i), Y2=b.get(j);
        if(X1==X2&&Y1==Y2){
            //we should send all the three values one by one.
            return 1f;
        }
        else if(Y1==Y2){
            return 0f;
        }else if(X1==X2){
            return Float.MAX_VALUE;
        }else{
            return (Y2-Y1)/(X2-X1);
        }
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

//        System.out.print(p.maxPoints(new ArrayList<Integer>(Arrays.asList(1,1,1,2)),new ArrayList<Integer>(Arrays.asList(1,1,1,2))));
        System.out.print(p.maxPoints(one,two));

    }
}
//6 -6 -17 5 -16 -18 -17 2 -4 5 -13 -2 20