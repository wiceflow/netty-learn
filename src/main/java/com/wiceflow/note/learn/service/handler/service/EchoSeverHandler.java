package com.wiceflow.note.learn.service.handler.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

/**
 * @author BF
 * @date 2020/12/13
 * <p>
 * 服务端 handle
 */
public class EchoSeverHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        // 读取收到的数据
        ByteBuf buf =  datagramPacket.copy().content();
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, CharsetUtil.UTF_8);
        System.out.println("【NOTE】>>>>>> 收到客户端的数据：" + body);

        // 回复一条信息给客户端
        channelHandlerContext.writeAndFlush(new DatagramPacket(
                Unpooled.copiedBuffer("Hello，我是Server，我的时间戳是" + System.currentTimeMillis()
                        , CharsetUtil.UTF_8)
                , datagramPacket.sender())).sync();
    }
}
