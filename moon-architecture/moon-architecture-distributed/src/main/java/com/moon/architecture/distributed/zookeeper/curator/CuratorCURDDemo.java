package com.moon.architecture.distributed.zookeeper.curator;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * TODO
 * 
 * @author TobiasCui
 * @date 2018年12月12日 上午10:46:24
 * 
 */
public class CuratorCURDDemo {
	private static final String ZK_ADRESS = "49.235.199.135:2181";
	private static final String ZK_PATH = "/zktest";
//	private static CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADRESS, new RetryNTimes(10, 5000));
	private static ExecutorService executorService = Executors.newFixedThreadPool(2);
	private static CuratorFramework client = CuratorFrameworkFactory.builder().connectString(ZK_ADRESS).sessionTimeoutMs(5000).retryPolicy(new RetryNTimes(10,5000)).build();
	static {
		client.start();
		System.out.println("客户端连接zk成功");
	}

	public static void main(String[] args) throws Exception {
		String testNodePath = ZK_PATH + "/test1/test2";
		String forPath = createNode(testNodePath, "123", CreateMode.EPHEMERAL);
		System.out.println(forPath);

		String forPath4;
		String data = getData(testNodePath);
		System.out.println(data);
		List<String> forPath2 = client.getChildren().forPath("/");
		String forPath3 = new String(client.getData().forPath("/"));
		Stat forPath5 = client.setData().forPath(ZK_PATH, "1".getBytes());
		client.delete().forPath(testNodePath);
		List<String> forPath6 = client.getChildren().forPath(ZK_PATH + "/test1");
		for (String string : forPath6) {
			System.out.println(string);
		}
	}

	/**
	 * 创建节点
	 * 
	 * @author TobiasCui
	 * @date 2018年12月12日 上午11:11:47
	 * 
	 * @param path
	 *            路径
	 * @param data
	 *            字符串数据
	 * @param createMode
	 *            CreateMode.PERSISTENT-持久节点（默认）
	 *            CreateMode.PERSISTENT_SEQUENTIAL-持久有序节点
	 *            CreateMode.EPHEMERAL-临时节点
	 *            CreateMode.EPHEMERAL_SEQUENTIAL-临时有序节点
	 * @return
	 * @throws Exception
	 */
	private static String createNode(String path, String data, CreateMode createMode) throws Exception {
		Stat stat = client.checkExists().forPath(path);
		if (stat != null) {
			return path;
		}

		if (createMode == null) {
			createMode = CreateMode.PERSISTENT;
		}
		String forPath = client.create().creatingParentContainersIfNeeded().withMode(createMode).forPath(path, data.getBytes());
		return forPath;
	}

	/**
	 * 获取数据
	 * 
	 * @author TobiasCui
	 * @date 2018年12月12日 上午11:18:34
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	private static String getData(String path) throws Exception {
		Stat stat = client.checkExists().forPath(path);
		if (stat == null) {
			return null;
		}
		String data = new String(client.getData().forPath(path));
//		client.getData().storingStatIn(stat).forPath(path);
		return data;
	}

	private static void createNodeSych(String path) throws Exception{
		client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
			@Override
			public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
				System.out.println("event[code:"+curatorEvent.getResultCode()+",type:"+curatorEvent.getType()+"]");
				System.out.println("Thread of processResult:"+Thread.currentThread().getName());
			}
		},executorService).forPath(path,"init".getBytes());

	}

	private static void userNodeCache(String path) throws Exception {
		final NodeCache cache = new NodeCache(client,path,false);
		cache.start(true);
		cache.getListenable().addListener(new NodeCacheListener() {
			@Override
			public void nodeChanged() throws Exception {
				System.out.println(new String(cache.getCurrentData().getData()));
			}
		});

	}

	private static void userChildNodeCache(String path) throws Exception {
		final PathChildrenCache cache = new PathChildrenCache(client,path,false,false,Executors.newFixedThreadPool(2));
		cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
		cache.getListenable().addListener(new PathChildrenCacheListener() {
			@Override
			public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {

			}
		});

	}
}
