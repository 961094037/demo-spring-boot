package com.example.demo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class ThreadPool {

    @Bean("pool")
    public ThreadPoolExecutor getPool() {
        ThreadFactory name = new ThreadFactoryBuilder()
                .setNameFormat("Thread-pool-%d").build();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 9, 60L,
//                TimeUnit.SECONDS, new LinkedBlockingDeque<>(1024), name);
//        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(8, 16, 60L,
//                TimeUnit.SECONDS, new LinkedBlockingDeque<>(1024), name);
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(16, 16, 60L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(1024), name);
//        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool();
//        Executors.newSingleThreadExecutor();
//        Executors.newScheduledThreadPool();
        return threadPoolExecutor3;
    }
}
