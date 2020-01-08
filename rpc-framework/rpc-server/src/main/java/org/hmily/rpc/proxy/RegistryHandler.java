package org.hmily.rpc.proxy;

import org.hmily.rpc.zookeeper.RegistryCenter;
import org.hmily.rpc.zookeeper.RegistryCenterWithZK;

import java.io.File;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistryHandler {

    ArrayList<String> classNames  =  new ArrayList<String>();

    public static Map<String,Object> REGISTRY_MAP = new HashMap<String,Object>();

    RegistryCenter registryCenter = new RegistryCenterWithZK();

    public RegistryHandler(int port,String names) {
        doScanner(names);
        doRegistry(port);
    }

    private void doScanner(String names) {
        String[] nameArr = names.split("\\|");
        for (String name:nameArr){
            classNames.add(name);
        }
    }


    private void doRegistry(int port){
        if (classNames.isEmpty()){
            return;
        }
        for (String className:classNames){
            try {
                Class<?> clz = Class.forName(className);
                Class<?> i = clz.getInterfaces()[0];
                String serviceName = i.getName();
                REGISTRY_MAP.put(serviceName,clz.newInstance());
                String serviceAddress = getServiceAddress() + ":" + port;
                registryCenter.registry(serviceName,serviceAddress);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getServiceAddress(){
        String serviceAddress = null;
        try {
            InetAddress address = InetAddress.getLocalHost();
            serviceAddress = address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return serviceAddress;
    }


}
