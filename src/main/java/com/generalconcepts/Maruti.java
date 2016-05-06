package com.generalconcepts;

/**
 * Created by MyMac on 27/03/16.
 */
public class Maruti implements Car {

    private int price;
    public boolean isSuperCar;


    protected Maruti(int pr, boolean isSCar){
        this.price = pr;
        this.isSuperCar=isSCar;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean isSuperCar() {
        return this.isSuperCar;
    }


    public static void main(String[] args) {
        Car c = new Maruti(100, false);
    }
}
