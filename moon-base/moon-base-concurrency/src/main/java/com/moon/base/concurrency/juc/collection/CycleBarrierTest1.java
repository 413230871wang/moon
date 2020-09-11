package com.moon.base.concurrency.juc.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/8/13 3:51 下午
 */
@Slf4j
public class CycleBarrierTest1 {
    private static CyclicBarrier barrier = new CyclicBarrier(2);

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println(threadNum+"is ready");
        barrier.await();
        System.out.println(threadNum+"is continue");
    }
}

