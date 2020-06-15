package com.moon.architecture.distributed.zookeeper.zkclient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

public class ZkClientDemo {
    private static final String CONNECTION = "49.235.199.135:2181";

    public static void main(String[] args) throws InterruptedException {
        ZkClient zkClient = new ZkClient(CONNECTION,50000);
        List<String> list = zkClient.getChildren("/");
        System.out.println(list);
        zkClient.subscribeChildChanges("/", new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println(s+"'s child changed,currentChilds:"+list);
            }
        });
        zkClient.createPersistent("/lay");
        zkClient.subscribeDataChanges("/", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println(s+"'s new Data:"+o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(s+"'s Data delete");
            }
        });
        Thread.sleep(Integer.MAX_VALUE);
    }
}
