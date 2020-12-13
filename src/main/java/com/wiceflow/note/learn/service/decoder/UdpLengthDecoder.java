package com.wiceflow.note.learn.service.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author BF
 * @date 2020/12/4 11:32
 * <p>
 * udp 拆包解包，一次性发过来的可能是很多个 udp 包，这个是限定长度把他拆成一个一个的包
 */
public class UdpLengthDecoder {

    public static void main(String[] args) {
        LengthFieldBasedFrameDecoder lengthFieldBasedFrameDecoder = new LengthFieldBasedFrameDecoder(368, 0, 2);

    }
}
