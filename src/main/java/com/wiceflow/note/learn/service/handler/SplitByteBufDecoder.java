package com.wiceflow.note.learn.service.handler;

import com.wiceflow.note.learn.object.dto.ProtocolDataDTO;
import com.wiceflow.note.learn.util.ByteUtil;
import com.wiceflow.note.learn.util.DecoderUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author BF
 * @date 2020/12/8 15:54
 * <p>
 * 拆分协议解析器 -> 将协议 拆开 [包头、实时数据、统计数据]  并校验数据长度是否正确
 */
@Slf4j
public class SplitByteBufDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {

        if (msg == null) {
            return;
        }
        // 将 byteBuf 的下标重置为 0
        msg.readerIndex(0);
        // 获取写入大小
        int length = msg.writerIndex();
        if (length == 0) {
            log.error("decode -> split byteBuf handler receive a length is zero byteBuf msg.");
            return;
        }
        byte[] msgArray = new byte[length];
        short dataPackLength = ByteUtil.getShort(msgArray, 0);
        // 将字节复制到数组中
        msg.getBytes(0, msgArray);
        if (!DecoderUtil.checkDataComplete(dataPackLength, msgArray)) {
            log.error("decode -> split byteBuf handler receive data length defect,should get length is :{} ,actual length is :{}", dataPackLength, msgArray.length);
            return;
        }
        ProtocolDataDTO protocolDataDTO = new ProtocolDataDTO();
        protocolDataDTO.setHeaderBuf(msg.readSlice(16));
        protocolDataDTO.setRealBuf(msg.readSlice(320));
        // 如果大于这个数则代表有统计数据  TODO 魔法值，引入配置
        if (dataPackLength > 336) {
            protocolDataDTO.setStatisticsBuf(msg.readSlice(dataPackLength));
        }
        log.debug("decode -> split ByteBuf handler split buf success. {}", dataPackLength > 336 ? "this data contain statistics data" : "this data does not contain statistics data");
        out.add(protocolDataDTO);
    }
}
