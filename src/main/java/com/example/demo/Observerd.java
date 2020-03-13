package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Observable;


public class Observerd extends Observable {

    private void update(){
        notifyAll();
    }



}
