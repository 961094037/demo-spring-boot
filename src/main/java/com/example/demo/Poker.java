package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Poker {

    /** 2-14  2-A */
    private int value;

    //花色
    private int flowerColor;

    public Poker(int num){
        this.flowerColor = num%4;
        this.value = (num - flowerColor)/4 + 2;
    }
}
