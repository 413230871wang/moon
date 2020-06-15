package com.moon.architecture.distributed.zookeeper.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CreatNodeDemo1 implements Watcher{
	private static final String CONNECTION = "49.235.199.135:2181";
	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	private static ZooKeeper zookeeper;
	private static Stat stat = new Stat();

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		zookeeper = new ZooKeeper(CONNECTION, 5000, new CreatNodeDemo1());
		countDownLatch.await();
		System.out.println(zookeeper.getState());

		long sessionId = zookeeper.getSessionId();
		byte[] passwd = zookeeper.getSessionPasswd();

		zookeeper = new ZooKeeper(CONNECTION,5000,new CreatNodeDemo1(),sessionId,passwd);
		Thread.sleep(Integer.MAX_VALUE);
	}

	@Override
	public void process(WatchedEvent watchedEvent) {
		System.out.println("Receive watched event:"+watchedEvent);
		if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
			countDownLatch.countDown();
		}
	}
}
