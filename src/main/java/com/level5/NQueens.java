package com.level5;

import java.text.StringCharacterIterator;
import java.util.ArrayList;

/**
 * Created by MyMac on 26/02/16.
 */
public class NQueens {



    ArrayList<ArrayList<String>> finalResult = new ArrayList<ArrayList<String>>();
    int size;
    public NQueens(){
        finalResult= new ArrayList<ArrayList<String>>();
        size=0;
    }


    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        finalResult = new ArrayList<>();
        if(a==2||a==3){
            return finalResult;
        }
        size=a;
        ArrayList<String> current = new ArrayList<>();
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                current.add(".");
            }
        }
        solveNQueenUtil(current,0);
        return finalResult;
    }

    private boolean solveNQueenUtil(ArrayList<String> current, int col) {
        if(col>=size){
            return true;
        }
        for(int row=0; row<size; row++){

            if(isSafePosition(current,row,col)){
                current.set(size*col+row,"Q");
                //if position is safe, place the queen at row,col and go to next column.
                if(solveNQueenUtil(current,col+1)){
                    //Add " " at the end of each row.
                    ArrayList<String> s = new ArrayList<>();
                    StringBuilder stringBuilder=new StringBuilder();
                    for(int i=0;i<size*size;i++){
                        stringBuilder.append(current.get(i));
                        if(i!=0 && (i+1)%size==0){
                            s.add(stringBuilder.toString());
                            stringBuilder=new StringBuilder();
                        }
                    }
                    if(size==1){
                        s.add(stringBuilder.toString());
                        finalResult.add(s);
                    }else {
                        finalResult.add(s);
                    }
                }
                //Do backtracking and look for other possible result.
                current.set(row+size*col,".");
            }
        }
        return false;
    }

    private boolean isSafePosition(ArrayList<String> current, int row, int col) {

        //check on only previous (left) columns.

        //first check in the same row till column col.
        for(int c=0;c<col;c++){
            if(current.get(size*c+row).equals("Q")){
                return false;
            }
        }

        //check diagonally up towards left.
        for(int r=row,c=col;r>=0 && c>=0;r--,c--){
            if(current.get(r+size*c).equals("Q")){
                return false;
            }
        }

        //check diagonally down towards left.
        for(int r=row,c=col;c>=0 && r<size;r++,c--){
            if(current.get(r+size*c).equals("Q")){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        NQueens n = new NQueens();
        for(ArrayList<String> arr : n.solveNQueens(6)){
            for(String i : arr){
                System.out.print(i);
            }
        System.out.println();
        }

    }
}