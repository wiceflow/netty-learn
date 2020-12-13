package com.wiceflow.note.learn.util;

import java.util.Arrays;

/**
 * @author BF
 * @date 2020/12/8 17:15
 * <p>
 * byte 工具类
 */
public class ByteUtil {

    /**
     * 将byte数组转换为16进制字符串
     *
     * @param bytes [byte[]] byte数组
     * @return 字符串
     * <p>
     * 0xFF 去除复数，相当于去除符号位
     */
    public static String bytesToHexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bytes.length);
        String sTemp;
        for (byte aByte : bytes) {
            sTemp = Integer.toHexString(0xFF & aByte);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将 byte 数组特定位置转成 short
     *
     * @param array [byte[]] byte 数据
     * @param start [int] 起始位置
     * @return short
     */
    public static short getShort(byte[] array, int start) {
        if (start + 2 > array.length) {
            throw new IllegalArgumentException();
        }
        return (short) ((array[start++] & 0xFF << 8) | (array[start] & 0xFF));
    }

    /**
     * 将 byte 数组特定位置转成 int
     *
     * @param array [byte[]] byte 数据
     * @param start [int] 起始位置
     * @return int
     */
    public static int getInt(byte[] array, int start) {
        if (start + 4 > array.length) {
            throw new IllegalArgumentException();
        }
        return (array[start++] & 0xFF << 24) | (array[start++] & 0xFF << 16) | (array[start++] & 0xFF << 8) | (array[start] & 0xFF);
    }

    /**
     * 把 byte 转为字符串的bit
     *
     * @param b [byte] byte 字节
     * @return 返回字符串形式的二进制数
     */
    public static String byteToBit(byte b) {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b) & 0x1);
    }

    /**
     * 将 byte 转成 bit 数组
     *
     * @param b [byte] byte 字节
     * @return 因为 bit 只有 0 和 1 ，所以用 int[] 数组返回
     */
    public static int[] byteToBitIntArray(byte b) {
        int[] resultArray = new int[8];
        int index = 0;
        for (int i = 7; i >= 0; i--) {
            resultArray[index] = (b >> i & 0x1);
            index++;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int test = 3;

        byte b = (byte) test;
        System.out.println(b);
        System.out.println(byteToBit(b));
        System.out.println(Arrays.toString(byteToBitIntArray(b)));
    }
}
