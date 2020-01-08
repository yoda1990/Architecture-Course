package org.hmily.rpc.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class RegistryCenterWithZK implements RegistryCenter{


    private final String CONNECT_STR = "127.0.0.1:2181";

    CuratorFramework curatorFramework = null;

    {
        curatorFramework = CuratorFrameworkFactory.builder().connectString(CONNECT_STR).sessionTimeoutMs(5000).
                retryPolicy(new ExponentialBackoffRetry(1000,3))
                .namespace("registry")
                .build();
        curatorFramework.start();
    }


    public void registry(String serviceName, String serviceAddress) {
        String servicePath = "/" + serviceName;
        try {
            // 判断节点是否存在
            if (curatorFramework.checkExists().forPath(servicePath) == null){
                curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(servicePath);
            }
            // serviceAddress ip:port
            String addressPath = servicePath +"/"+serviceAddress;
            curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath(addressPath);
            System.out.println(serviceName+ "：" +serviceAddress +"  服务注册成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
