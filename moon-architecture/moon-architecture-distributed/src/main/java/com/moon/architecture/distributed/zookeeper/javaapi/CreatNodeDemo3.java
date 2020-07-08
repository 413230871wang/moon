package com.moon.architecture.distributed.zookeeper.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CreatNodeDemo3 implements Watcher{
	private static final String CONNECTION = "49.235.199.135:2181";
	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	private static ZooKeeper zookeeper;
	private static Stat stat = new Stat();

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		zookeeper = new ZooKeeper(CONNECTION, 5000, new CreatNodeDemo3());
		countDownLatch.await();
		System.out.println(zookeeper.getState());
		zookeeper.exists("/lay1",true);
		zookeeper.create("/lay1","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
		zookeeper.setData("/lay1","123".getBytes(),-1);
		zookeeper.create("/lay1/c1","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
		zookeeper.delete("/lay1/c1",-1);
		zookeeper.delete("/lay1",-1);
		Thread.sleep(Integer.MAX_VALUE);
	}

	@Override
	public void process(WatchedEvent watchedEvent) {
		try{
			if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
				if(Event.EventType.None == watchedEvent.getType() && null==watchedEvent.getPath()){
					countDownLatch.countDown();
				}else if(Event.EventType.NodeCreated == watchedEvent.getType()){
					System.out.println("Node("+watchedEvent.getPath()+")Created");
					stat = zookeeper.exists(watchedEvent.getPath(),true);
					System.out.println("Created Version="+stat.getVersion());
				}else if(Event.EventType.NodeDeleted == watchedEvent.getType()){
					System.out.println("Node("+watchedEvent.getPath()+")Deleted");
					stat = zookeeper.exists(watchedEvent.getPath(),true);
					System.out.println("Deleted Version="+stat.getVersion());
				}else if(Event.EventType.NodeDataChanged == watchedEvent.getType()){
					System.out.println("Node("+watchedEvent.getPath()+")Created");
					stat = zookeeper.exists(watchedEvent.getPath(),true);
					System.out.println("Change Version="+stat.getVersion());
				}
			}
		}catch (Exception e){

		}
	}
}
