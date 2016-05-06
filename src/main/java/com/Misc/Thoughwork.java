package com.Misc;

import java.util.Scanner;

/**
 * Created by MyMac on 06/04/16.
 */


public class Thoughwork {

    private static final int NumberOfRovers = 2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int posX, posY;
        posX = scanner.nextInt();
        posY = scanner.nextInt();

        int noOfRovers = NumberOfRovers;
        while(noOfRovers-->0){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String cdir  =  scanner.next();
            //Lets give integer representation to each direction.
            //if  (North -> 1) (East->2) (South ->3) (West ->4)
            int dir = 0;
            if(cdir.equals("N")){
                dir=1;
            }else if(cdir.equals("E")){
                dir=2;
            }
            else if(cdir.equals("S")){
                dir=3;
            }
            else if(cdir.equals("W")){
                dir=4;
            }
            else{
                System.out.println("Invalid direction, Returning.");
                continue;
            }

            String instructions  = scanner.next();
            for(int i =0 ; i< instructions.length(); i++) {
                char ch = instructions.charAt(i);
                if(ch=='M'){
                    //move one step ahead in the current direction.
                    if(dir==1 && y < posY){
                        y = y +1;
                    }
                    else if(dir==2 && x< posX){
                        x = x+1;
                    }
                    else if(dir ==3 && y> 0){
                        y = y-1;
                    }
                    else if(dir==4 && x>0){
                        x = x-1;
                    }

                }
                else {
                    //change direction according to left or right.
                        if(ch=='L') {
                            dir--;
                        }
                        else {
                            dir++;
                        }
                    if(dir==0){
                        dir =4;
                    }
                    else if(dir==5){
                        dir=1;
                    }
                }
            }

            if(dir==1){
                cdir="N";
            }
            else if(dir==2){
                cdir="E";
            }else if(dir==3){
                cdir="S";
            }
            else {
                cdir="W";
            }

            System.out.println(x+ " "+ y + " "+ cdir);

        }

    }
}
