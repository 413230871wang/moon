package com.moon.architecture.distributed.zookeeper.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CreatNodeDemo2 implements Watcher{
	private static final String CONNECTION = "49.235.199.135:2181";
	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	private static ZooKeeper zookeeper;
	private static Stat stat = new Stat();

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		zookeeper = new ZooKeeper(CONNECTION, 5000, new CreatNodeDemo2());
		countDownLatch.await();
		System.out.println(zookeeper.getState());
		String path1 = zookeeper.create("/202006112121-ephe","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
		System.out.println("success create znode:"+path1);
		String path2 = zookeeper.create("/202006112121-ephe","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println("success create znode:"+path2);
	}

	@Override
	public void process(WatchedEvent watchedEvent) {
		System.out.println("Receive watched event:"+watchedEvent);
		if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
			countDownLatch.countDown();
		}
	}
}
