package org.hmily.rpc.loadbalance;

import java.util.List;

public abstract class AbstractLoadBalance implements LoadBalance {

    public String doBalance(List<String> serviceRepos){
        if (serviceRepos ==null){
            return null;
        }
        if (serviceRepos.size() == 1){
            return serviceRepos.get(0);
        }
        return doSelect(serviceRepos);
    }

    public abstract String doSelect(List<String> serviceRepos);
}
