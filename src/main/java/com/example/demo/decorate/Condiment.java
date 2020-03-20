package com.example.demo.decorate;

/**
*  调料基类
*/
public abstract class Condiment extends Beverage{

    protected Beverage beverage;

    public abstract String getDescript();
}
