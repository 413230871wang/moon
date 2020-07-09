package com.moon.architecture.distributed.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.data.Stat;

public class MasterSelecter {
    private static CuratorFramework client = CuratorFrameworkFactory.builder().retryPolicy(new RetryNTimes(5,5000)).sessionTimeoutMs(5000).connectString("49.235.199.135:2181").build();
    private static Stat stat = new Stat();
    private static String math_path = "/lay/master";

    static{
        client.start();
    }

    public static void main(String[] args) throws InterruptedException {
        LeaderSelector leaderSelector = new LeaderSelector(client, math_path, new LeaderSelectorListenerAdapter() {
            @Override
            public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
                System.out.println("成为master");
                System.out.println(curatorFramework.getState());
                System.out.println("选举结束");
            }
        });
        leaderSelector.autoRequeue();
        leaderSelector.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
