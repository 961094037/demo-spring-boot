package com.example.demo;

import cn.hutool.core.util.RandomUtil;
import com.sun.corba.se.impl.ior.POAObjectKeyTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
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
        Date date = new Date();
        AtomicInteger allTime = new AtomicInteger(0);
        AtomicInteger time1 = new AtomicInteger(0);
        AtomicInteger time2 = new AtomicInteger(0);
        int times = checkPoker.getTime()/checkPoker.getThreadTime();
        CountDownLatch countDownLatch = new CountDownLatch(checkPoker.getThreadTime());
        for (int q=0; q<checkPoker.getThreadTime(); q++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i<times; i++){
                        List<Integer> have = new LinkedList<>();
                        have.add( (checkPoker.getPoker1().get(0).getValue()-2)*4+checkPoker.getPoker1().get(0).getFlowerColor());
                        have.add( (checkPoker.getPoker1().get(1).getValue()-2)*4+checkPoker.getPoker1().get(1).getFlowerColor());
                        have.add( (checkPoker.getPoker2().get(0).getValue()-2)*4+checkPoker.getPoker1().get(0).getFlowerColor());
                        have.add( (checkPoker.getPoker2().get(1).getValue()-2)*4+checkPoker.getPoker2().get(1).getFlowerColor());
                        for (int m=0; m < 5;){
                            int p = RandomUtil.randomInt(0,51);
                            if (have.contains(p)){
                                continue;
                            }else {
                                have.add(p);
                                m++;
                            }
                        }
                        List<Poker> pokerList1 = new LinkedList<>(checkPoker.getPoker1());
                        List<Poker> pokerList2 = new LinkedList<>(checkPoker.getPoker2());
                        for (int k=4; k < 9;k++){
                            Poker poker = new Poker(have.get(k));
                            pokerList1.add(poker);
                            pokerList2.add(poker);
                        }
                        Pokers max1 = getMaxPokers(pokerList1);
                        Pokers max2 = getMaxPokers(pokerList2);
                        allTime.getAndIncrement();
                        if (max1.compare(max2) > 0){
                            time1.getAndIncrement();
                        }else if (max1.compare(max2) < 0){
                            time2.getAndIncrement();
                        }else {
                            time1.getAndIncrement();
                            time2.getAndIncrement();
                        }

                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReturnOdds returnOdds = new ReturnOdds();
        returnOdds.setOdds1(time1.floatValue()/allTime.floatValue());
        returnOdds.setOdds2(time2.floatValue()/allTime.floatValue());
        returnOdds.setTime(System.currentTimeMillis() - date.getTime());
        return returnOdds;
    }

}
