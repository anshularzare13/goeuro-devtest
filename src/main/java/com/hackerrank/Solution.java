package com.hackerrank;

/**
 * Created by MyMac on 18/02/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        File file = new File("/Users/MyMac/Desktop/out.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            //Now check if m is greater than max continous subarray of 1's or not.
            //This is wrong approach.
            // At Every step user has three option either do x-1 or x+1 or x+m.
            // Now this seems to be problem of backtracking.
            int currntIndex=0;
            //use recursion to solve this problem.
            int mn=0;
            int ans = move(currntIndex,m,arr, true,0,true);
            if(ans==1){
                fileOutputStream.write("YES".getBytes());
                System.out.println("YES");
            }
            else{
                fileOutputStream.write("NO".getBytes());
                System.out.println("NO");
            }
            fileOutputStream.write("\n".getBytes());
        }

        fileOutputStream.close();;
    }

    private static int move(int currntIndex, int m, int[] arr, boolean isback, int cantgomplus, boolean f) {
        if(currntIndex>=arr.length-1){
            return 1;
        }

//        int prev=currntIndex;
        if(isback && arr[currntIndex+1]==0) return  move(currntIndex+1,m,arr,true,0, true);
        if(f && cantgomplus<m && (currntIndex+m >= arr.length || arr[currntIndex+m]==0)) return  move(currntIndex+m,m,arr,true,0,true);
        if(currntIndex>0 && arr[currntIndex-1]==0) return  move(currntIndex-1,m,arr,false,cantgomplus+1,true);

        //
        currntIndex=currntIndex-m;
        if(currntIndex<=0|| arr[currntIndex]==1){
            return -1;
        }
        return move(currntIndex,m,arr,false,0,false);

        //do backtracking. Don't just return yet
    }
}
