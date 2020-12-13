package com.wiceflow.note.learn.util;

/**
 * @author BF
 * @date 2020/12/8 17:22
 * <p>
 * 解析工具类
 */
public class DecoderUtil {

    /**
     * 校验数据是否接收完整
     *
     * @param dataPackLength [short] 包头内存放的数据长度
     * @param bytes          [byte[]] byte 数组 源数据
     * @return true 代表数据接收正常
     */
    public static boolean checkDataComplete(short dataPackLength, byte[] bytes) {
        // 获取包头的数据长度信息
        return dataPackLength == bytes.length;
    }
}
