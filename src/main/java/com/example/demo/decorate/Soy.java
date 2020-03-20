package com.example.demo.decorate;

import lombok.NoArgsConstructor;

/**
 * 摩卡
 */
@NoArgsConstructor
public class Soy extends Condiment {

    Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescript() {
        return beverage.getDescript() + ",Soy";
    }

    @Override
    public double cost() {
        return .5 + beverage.cost();
    }
}
