package org.hmily.rpc.strategy;

import org.hmily.rpc.loadbalance.LoadBalance;

import java.util.List;

public class LoadBalanceStrategyImpl implements LoadBalanceStrategy{

    private LoadBalance loadBalance;

    public LoadBalanceStrategyImpl(LoadBalance loadBalance) {
        this.loadBalance = loadBalance;
    }

    public String selectHost(List<String> serviceRepos) {
        String serviceAddress = loadBalance.doBalance(serviceRepos);
        return serviceAddress;
    }
}
