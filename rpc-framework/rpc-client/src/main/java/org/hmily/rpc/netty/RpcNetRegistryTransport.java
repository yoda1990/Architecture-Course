package org.hmily.rpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.hmily.rpc.protocol.InvokerProtocol;
import org.hmily.rpc.registry.ServiceDiscovery;

public class RpcNetRegistryTransport {

    private ServiceDiscovery discovery;

    public RpcNetRegistryTransport(ServiceDiscovery discovery) {
        this.discovery = discovery;
    }

    public Object send(InvokerProtocol invokerProtocol) {

        Object result = null;
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        final RpcResultHandler resultHandler = new RpcResultHandler();
        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(resultHandler);
                }
            });

            // Start the client.
            String serviceAddress = discovery.discovery(invokerProtocol.getClassName());
            String[] addr = serviceAddress.split(":");
            ChannelFuture f = b.connect(addr[0], Integer.parseInt(addr[1])).sync(); // (5)
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
            result = resultHandler.getResponse();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
        return result;
    }

}
