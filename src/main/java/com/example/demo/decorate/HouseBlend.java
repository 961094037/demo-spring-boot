package com.example.demo.decorate;

public class HouseBlend extends Beverage{

    public HouseBlend(){
        descript = "HouseBlend";
    }

    @Override
    public double cost() {
        return .79;
    }
}
