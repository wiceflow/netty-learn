package com.wiceflow.note.learn.object.dto;

import lombok.Data;

/**
 * @author BF
 * @date 2020/12/8 19:53
 * <p>
 * 包头
 */
@Data
public class HeaderDTO {

    /** 数据包总长度 */
    private Integer dataLength;
    /** 小版本号 */
    private String smallVersion;
    /** 大版本号 */
    private String bigVersion;
    /** 城市缩写1：’N’ */
    private String cityFirst;
    /** 城市缩写2：’B’ */
    private String cityLast;
    /** 线路号：5 */
    private Integer lineNo;
    /** 列车号：1 */
    private Integer trainNo;
    /** 车厢号：1~8 */
    private Integer carriageNo;
    /** 车门号：1~10 */
    private Integer carDoorNo;
    /** 年 */
    private Integer year;
    /** 月 */
    private Integer month;
    /** 日 */
    private Integer day;
    /** 时 */
    private Integer hour;
    /** 分 */
    private Integer minute;
    /** 秒 */
    private Integer second;
}
