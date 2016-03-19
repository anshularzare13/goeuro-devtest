package com.booking.com;

import java.util.HashMap;

/**
 * Created by MyMac on 22/02/16.
 */

class Point{
    int x;
    int y;
    Point(int a, int b){
        this.x = a;
        this.y = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}


public class FindLoop {
    /*
    Given set of instructions like <>^V/ SEWN, find if its forming loop at any point.
    Assume starting point of operations as 0,0.
    S - means go south/down y-1.
    N  - means go up y+1.
    E - go east x+1
    W - go west x-1
    */

    public boolean findLoop(String stream){
        //Take hashmap of points and as we traverse the stream keep storing them in hashmap.
        // Once we hit the same point again we can say that we have formed a loop.

        HashMap<Point, Boolean> points = new HashMap<>();
        int x=0,y=0;
        Point sp = new Point(x,y);
        points.put(sp, true);
        for(int i=0 ; i< stream.length();i++){
            if(stream.charAt(i)=='S'){
                y = y-1;
            }else if(stream.charAt(i)=='N'){
                y = y+1;
            }else if(stream.charAt(i)=='E'){
                x = x+1;
            }else if(stream.charAt(i)=='W') {
                x = x-1;
            }else{
                //throw an error may be saying invalid input.
            }

            Point p = new Point(x,y);
            if(points.containsKey(p)){
                return true;
            }else{
                points.put(p, true);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        FindLoop fl = new FindLoop();
        System.out.println(fl.findLoop("SSEEWW"));
    }
}
