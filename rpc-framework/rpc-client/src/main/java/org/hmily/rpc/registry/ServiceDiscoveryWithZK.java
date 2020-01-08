package org.hmily.rpc.registry;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.hmily.rpc.loadbalance.LoadBalance;
import org.hmily.rpc.loadbalance.RandomLoadBalance;
import org.hmily.rpc.strategy.LoadBalanceStrategy;
import org.hmily.rpc.strategy.LoadBalanceStrategyImpl;
import java.util.List;

public class ServiceDiscoveryWithZK implements ServiceDiscovery{

    private final String CONNECT_STR = "127.0.0.1:2181";

    CuratorFramework curatorFramework = null;

    List<String> serviceRepos = null;

    {
        curatorFramework = CuratorFrameworkFactory.builder().connectString(CONNECT_STR).sessionTimeoutMs(5000).
                retryPolicy(new ExponentialBackoffRetry(1000,3))
                .namespace("registry")
                .build();
        curatorFramework.start();
    }

    public String discovery(String serviceName) {
        String path = "/" + serviceName;
        try {
            serviceRepos =curatorFramework.getChildren().forPath(path);
            registryWatch(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoadBalanceStrategy loadBalanceStrategy = new LoadBalanceStrategyImpl(new RandomLoadBalance());
        return loadBalanceStrategy.selectHost(serviceRepos);
    }

    private void registryWatch(final String path) throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework,path,true);
        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                serviceRepos = curatorFramework.getChildren().forPath(path);
            }
        };
        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);
        pathChildrenCache.start(PathChildrenCache.StartMode.NORMAL);
    }
}
