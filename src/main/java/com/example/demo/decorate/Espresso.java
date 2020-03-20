package com.example.demo.decorate;

/**
* 浓缩咖啡
*/
public class Espresso extends Beverage {

    public Espresso(){
        descript = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
