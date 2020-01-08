package org.hmily.rpc.loadbalance;

import java.util.List;
import java.util.Random;

public class RandomLoadBalance extends AbstractLoadBalance{


    public String doSelect(List<String> serviceRepos) {
        Random random = new Random();
        int length = serviceRepos.size();
        return serviceRepos.get(random.nextInt(length));
    }
}
