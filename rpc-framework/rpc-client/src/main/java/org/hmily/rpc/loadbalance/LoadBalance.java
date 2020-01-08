package org.hmily.rpc.loadbalance;

import java.util.List;

public interface LoadBalance {


    String doBalance(List<String> serviceRepos);

}
