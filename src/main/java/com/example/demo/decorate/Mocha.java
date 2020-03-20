package com.example.demo.decorate;

import lombok.NoArgsConstructor;

/**
* 摩卡
*/
@NoArgsConstructor
public class Mocha extends Condiment {

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescript() {
        return beverage.getDescript() + ",mocha";
    }

    @Override
    public double cost() {
        return .2 + beverage.cost();
    }
}
