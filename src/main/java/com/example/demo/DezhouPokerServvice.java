package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DezhouPokerServvice {

    public Pokers getMaxPokers(List<Poker> pokerList){
        Pokers max = null;
        int i = 0, k;
        for (; i < 6; i++) {
            for (k = i + 1; k < 7; k++) {
                List<Poker> newPokers = new LinkedList<>();
                for (int m=0;m<7;m++){
                    if (m != i && m != k){
                        newPokers.add(pokerList.get(m));
                    }
                }
                Pokers pokers = new Pokers(newPokers);
                if (max != null){
                    if (pokers.compare(max) > 0){
                        max = pokers;
                    }
                }else {
                    max = pokers;
                }
            }
        }
        return max;
    }


    public ReturnOdds CheckPoker(CheckPoker checkPoker){
        AtomicInteger allTime = new AtomicInteger(0);
        AtomicInteger time1 = new AtomicInteger(0);
        AtomicInteger time2 = new AtomicInteger(0);
        for (int i = 0; i<10; i++){
//            Random
        }


        return null;
    }

}
