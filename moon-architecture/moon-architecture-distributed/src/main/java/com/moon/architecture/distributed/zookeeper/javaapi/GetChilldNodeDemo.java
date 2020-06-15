package com.moon.architecture.distributed.zookeeper.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class GetChilldNodeDemo implements Watcher{
	private static final String CONNECTION = "49.235.199.135:2181";
	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	private static ZooKeeper zookeeper;
	private static Stat stat = new Stat();

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		zookeeper = new ZooKeeper(CONNECTION, 5000, new GetChilldNodeDemo());
		countDownLatch.await();
		System.out.println(zookeeper.getState());

		zookeeper.getChildren("/lay",true,new IChildren2Callback(),"");
		zookeeper.create("/lay/lay5","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
		Thread.sleep(Integer.MAX_VALUE);
	}

	@Override
	public void process(WatchedEvent watchedEvent) {
		System.out.println("Receive watched event:"+watchedEvent);
		if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
			countDownLatch.countDown();
			if(Event.EventType.NodeChildrenChanged==watchedEvent.getType()){
				try {
					System.out.println("childChange:"+zookeeper.getChildren(watchedEvent.getPath(),true));
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class IChildren2Callback implements AsyncCallback.Children2Callback{


	@Override
	public void processResult(int i, String s, Object o, List<String> list, Stat stat) {
		System.out.println("childs:"+list);
	}
}
