package org.hmily.rpc.strategy;

import java.util.List;

public interface LoadBalanceStrategy {

    String selectHost(List<String> serviceRepos);

}
