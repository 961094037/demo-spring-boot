package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum SuitPatterns {

    tonghuashun(9, "同花顺"),
    sitiiao(8, "四条"),
    hulu(7, "葫芦"),
    tonghua(6, "同花"),
    shunzi(5, "顺子"),
    santiao(4, "三条"),
    liangdui(3, "两对"),
    dandui(2, "单对"),
    sanpai(1, "散牌");

    private int value;
    private String message;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
