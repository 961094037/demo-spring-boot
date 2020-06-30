package com.example.demo.decorate;

/**
*  饮料基类
*/
public abstract class Beverage {

    public String  descript = "unKnow beverage";

    public String getDescript(){
        return descript;
    }

    public abstract double cost();
}
