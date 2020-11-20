package com.wj.nettyserver.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.springframework.stereotype.Component;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/11 0011
 * @description
 */
@Component
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    if (msg instanceof ByteBuf) {
      ByteBuf receive = (ByteBuf) msg;
      System.out.println("Server Receive: " + receive.toString(CharsetUtil.UTF_8));

      //告诉客户端已经收到消息
        String result="Send To Client: I Receive Your Message\\r\\n";
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeBytes(result.getBytes());
        ctx.channel().writeAndFlush(buffer);
        System.out.println("-----------");



    }
  }
}
