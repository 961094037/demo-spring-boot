package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Observable;
import java.util.Observer;

@Service
public class AObserver implements Observer {


    @Override
    public void update(Observable o, Object arg) {

    }
}
