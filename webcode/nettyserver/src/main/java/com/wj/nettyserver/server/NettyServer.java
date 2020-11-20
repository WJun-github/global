package com.wj.nettyserver.server;

import com.wj.nettyserver.handler.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/11 0011
 * @description
 */
@Slf4j
public class NettyServer {

  public void start() throws InterruptedException {
    log.info("Server Up Success...");
    ServerBootstrap server = new ServerBootstrap();
    // 用来处理accept事件
    EventLoopGroup parent = new NioEventLoopGroup();
    // 用来处理通道的读写事件
    EventLoopGroup child = new NioEventLoopGroup();
    server.group(parent, child);
    // 定义客户端连接等待队列最大长度
    server.option(ChannelOption.SO_BACKLOG, 128);
    server.channel(NioServerSocketChannel.class);
    server.childHandler(
        new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel sc) throws Exception {
            // 指定解码器
            sc.pipeline()
                .addLast(
                    new DelimiterBasedFrameDecoder(
                        Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
            sc.pipeline().addLast(new NettyServerHandler());
          }
        });
    ChannelFuture future = server.bind(8080).sync();
    if (future.isSuccess()) {
      future.channel().closeFuture().sync();
    } else {
      parent.shutdownGracefully().sync();
    }
  }
}
