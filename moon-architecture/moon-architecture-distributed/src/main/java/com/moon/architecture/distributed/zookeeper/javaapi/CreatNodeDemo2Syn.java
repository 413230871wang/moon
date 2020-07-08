package com.moon.architecture.distributed.zookeeper.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CreatNodeDemo2Syn implements Watcher{
	private static final String CONNECTION = "49.235.199.135:2181";
	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	private static ZooKeeper zookeeper;
	private static Stat stat = new Stat();

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		zookeeper = new ZooKeeper(CONNECTION, 5000, new CreatNodeDemo2Syn());
		countDownLatch.await();
		System.out.println(zookeeper.getState());
		zookeeper.create("/202006112121-ephe","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL,new IStringCallback(),"I am context");
		zookeeper.create("/202006112121-ephe","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL,new IStringCallback(),"I am context");
		zookeeper.create("/202006112121-ephe","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL,new IStringCallback(),"I am context");
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
class IStringCallback implements AsyncCallback.StringCallback{

	@Override
	public void processResult(int i, String s, Object o, String s1) {
		System.out.println("Create path result:["+i+","+s+","+o+",real path name:"+s1);
	}
}
