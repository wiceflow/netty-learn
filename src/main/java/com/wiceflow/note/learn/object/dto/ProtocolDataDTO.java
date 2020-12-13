package com.wiceflow.note.learn.object.dto;


import io.netty.buffer.ByteBuf;
import lombok.Data;


/**
 * @author BF
 * @date 2020/12/10 15:49
 */
@Data
public class ProtocolDataDTO {

    /**
     * 头部 buf 16 字节
     */
    private ByteBuf headerBuf;
    /**
     * 实时数据 buf 320 字节
     */
    private ByteBuf realBuf;
    /**
     * 统计数据 buf 32 字节 不一定会有
     */
    private ByteBuf statisticsBuf;
}