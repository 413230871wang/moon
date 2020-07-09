package com.moon.architecture.distributed.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.data.Stat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class MultilyLock {
    private static CuratorFramework client = CuratorFrameworkFactory.builder().retryPolicy(new RetryNTimes(5,5000)).sessionTimeoutMs(5000).connectString("49.235.199.135:2181").build();
    private static Stat stat = new Stat();
    private static String math_path = "/lock";

    static{
        client.start();
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final InterProcessMutex lock = new InterProcessMutex(client,math_path);
        for(int i = 0;i<=10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        lock.acquire();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd|SSS");
                    String orderNo = sdf.format(date);
                    System.out.println("订单号是："+orderNo);
                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            countDownLatch.countDown();
        }
        Thread.sleep(Integer.MAX_VALUE);
    }
}
