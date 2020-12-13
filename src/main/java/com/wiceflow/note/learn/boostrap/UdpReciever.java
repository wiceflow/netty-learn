package com.wiceflow.note.learn.boostrap;

import com.wiceflow.note.learn.service.handler.SecondHandler;
import com.wiceflow.note.learn.service.handler.ThreeHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @author BF
 * @date 2020/12/13
 * <p>
 * 模拟 Udp 客户端
 */
public class UdpReciever {
    /**
     * Reciever的端口
     */
    private static int R_PORT = 2222;

    public static void main(String[] args) {
        //1.NioEventLoopGroup是执行者
        NioEventLoopGroup group = new NioEventLoopGroup();
        System.out.println("NioEventLoopGroup in main :" + group);
        //2.启动器
        Bootstrap bootstrap = new Bootstrap();
        //3.配置启动器
        //3.1指定group
        bootstrap.group(group)
                //3.2指定channel
                .channel(NioDatagramChannel.class)
                //3.3指定为广播模式
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new ChannelInitializer<NioDatagramChannel>() {
                    @Override
                    protected void initChannel(NioDatagramChannel nioDatagramChannel) throws Exception {
                        //3.4在pipeline中加入解码器
                        nioDatagramChannel.pipeline().addLast(new MyUdpDecoder());
                        nioDatagramChannel.pipeline().addLast(new SecondHandler());
                        nioDatagramChannel.pipeline().addLast(new ThreeHandler());

                    }
                });
        try {
            //4.bind到指定端口，并返回一个channel，该端口就是监听UDP报文的端口
            Channel channel = bootstrap.bind(R_PORT).sync().channel();
            //5.等待channel的close
            channel.closeFuture().sync();
            //6.关闭group
            group.shutdownGracefully();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyUdpDecoder extends MessageToMessageDecoder<DatagramPacket> {
        @Override
        protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) throws Exception {
            ByteBuf buf = datagramPacket.content();
            String msg = buf.toString(CharsetUtil.UTF_8);
            list.add("UdpReciever :" + msg);
            list.add("Udp test success one");
        }
    }
}
