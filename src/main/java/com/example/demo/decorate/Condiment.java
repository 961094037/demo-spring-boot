package com.example.demo.decorate;

/**
*  调料基类
*/
public abstract class Condiment extends Beverage{

    public Beverage beverage;

    public abstract String getDescript();
}
