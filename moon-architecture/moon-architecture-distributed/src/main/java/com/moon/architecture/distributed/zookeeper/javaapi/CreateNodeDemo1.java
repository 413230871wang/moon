package com.moon.architecture.distributed.zookeeper.javaapi;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class CreateNodeDemo1 implements Watcher{
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String CONNECTION = "49.235.199.135:2181";
    private static ZooKeeper zookeeper;

    public static void main(String[] args) throws Exception{
        zookeeper = new ZooKeeper(CONNECTION, 5000, new CreateNodeDemo1());
        try {
            countDownLatch.await();
        }catch (InterruptedException e){

        }
        long sessionId = zookeeper.getSessionId();
        byte[] password = zookeeper.getSessionPasswd();

//        zookeeper = new ZooKeeper(CONNECTION, 5000, new CreateNodeDemo1(),1l,"test".getBytes());
        zookeeper = new ZooKeeper(CONNECTION, 5000, new CreateNodeDemo1(),sessionId,password);
        Thread.sleep(Integer.MAX_VALUE);
    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event:"+watchedEvent);
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            countDownLatch.countDown();
        }
    }
}
