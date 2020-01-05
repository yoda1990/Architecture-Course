package org.hmily.rpc.registry;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.hmily.rpc.protocol.InvokerProtocol;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegistryHandler extends ChannelInboundHandlerAdapter {

    ArrayList<String> classNames  =  new ArrayList<String>();
    Map<String,Object> registryMap = new HashMap<String,Object>();

    public RegistryHandler() {
        doScanner("org.hmily.rpc.api");
        doRegistry();
    }

    private void doScanner(String packageName) {
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("//.",""));
        File classPath =new File(url.getFile()) ;
        for (File file:classPath.listFiles()){
            if (file.isDirectory()){
                doScanner(packageName+"."+file.getName());
            }else {
                classNames.add(packageName+"."+ file.getName().replace(".class",""));
            }
        }
    }

    private void doRegistry(){
        if (classNames.isEmpty()){
            return;
        }
        for (String className:classNames){
            try {
                Class<?> clz = Class.forName(className);
                Class<?> i = clz.getInterfaces()[0];
                String serviceName = i.getName();
                registryMap.put(serviceName,clz.newInstance());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Object result = new Object();
        InvokerProtocol invokerProtocol = (InvokerProtocol) msg;
        if (registryMap.containsKey(invokerProtocol.getClassName())){
            Object service = registryMap.get(invokerProtocol.getClassName());
            Method method = service.getClass().getMethod(invokerProtocol.getMethodName(),invokerProtocol.getParamters());
            result = method.invoke(service,invokerProtocol.getValues());
        }
        ctx.write(result);
        ctx.flush();
        ctx.close();
    }




    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Registry Exception !!!!");
    }
}
