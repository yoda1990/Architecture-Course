package org.hmily.rpc.zookeeper;

public interface RegistryCenter {


    /**
     * 注册服务
     * @param serviceName
     * @param serviceAddress
     */
    void registry(String  serviceName,String serviceAddress);


}
