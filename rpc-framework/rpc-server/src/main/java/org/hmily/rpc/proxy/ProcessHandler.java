package org.hmily.rpc.proxy;

import org.hmily.rpc.dto.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class ProcessHandler implements Runnable{

    private Socket socket;

    private Object service;

    public ProcessHandler(Socket socket,Object service) {
        this.socket = socket;
        this.service =service;
    }

    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            Object result = invoke(rpcRequest);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 反射调用
        Object[] args = rpcRequest.getParameters();
        Class[] types = new Class[args.length];
        for (int i = 0;i<args.length;i++){
            types[i] = args[i].getClass();
        }
        Class clz = Class.forName(rpcRequest.getClassName());
        Method method = clz.getMethod(rpcRequest.getMethodName(),types);
        Object result = method.invoke(service,args);
        return result;
    }
}
