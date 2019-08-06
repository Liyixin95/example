package netty;

import common.Initializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * NettyInitializer
 *
 * @author liyixin
 * @date 2019/8/5
 */
public class NettyInitializer implements Initializer {
    @Override
    public void init() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap bootStrap = new ServerBootstrap();
            bootStrap.group(group, group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new HttpServerCodec());
                        }
                    });

            Channel channel = bootStrap.bind(80).sync().channel();
            channel.closeFuture().sync();
        } catch (Exception e) {
            group.shutdownGracefully();
            e.printStackTrace();
        }

    }
}
