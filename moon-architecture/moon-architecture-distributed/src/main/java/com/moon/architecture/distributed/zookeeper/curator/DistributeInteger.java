package com.moon.architecture.distributed.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.data.Stat;

public class DistributeInteger {
    private static CuratorFramework client = CuratorFrameworkFactory.builder().retryPolicy(new RetryNTimes(5,5000)).sessionTimeoutMs(5000).connectString("49.235.199.135:2181").build();
    private static Stat stat = new Stat();
    private static String math_path = "/lock";

    static{
        client.start();
    }

    public static void main(String[] args) throws Exception {
        DistributedAtomicInteger autoIntger = new DistributedAtomicInteger(client,math_path,new RetryNTimes(3,1000));
        AtomicValue<Integer> atomicValue = autoIntger.add(8);
        System.out.println(atomicValue);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
