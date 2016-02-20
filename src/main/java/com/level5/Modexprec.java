package com.level5;

/**
 * Created by MyMac on 20/02/16.
 */
public class Modexprec {

    public int Mod(int a, int b, int c) {
        if(a==0){return 0;}
        if(b==0){return 1;}
        if(b==1){
            int z=a%c;
            if(z<0){
                return z+c;
            }
            return z;
        }
        if(b%2==0){
            int y=Mod(a,b/2,c);
            return (y*y)%c;
        }
        else{
            return a%c*(Mod(a,b-1,c));
        }
    }


    public static void main(String[] args) {
        Modexprec m = new Modexprec();
        System.out.print(m.Mod(0,0,1));

    }
}

