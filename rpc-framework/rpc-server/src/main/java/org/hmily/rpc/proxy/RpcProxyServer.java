package org.hmily.rpc.proxy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(Object o,int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessHandler(socket,o));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
