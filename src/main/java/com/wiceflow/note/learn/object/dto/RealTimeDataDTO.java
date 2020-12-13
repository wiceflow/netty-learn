package com.wiceflow.note.learn.object.dto;

import lombok.Data;

import java.util.List;

/**
 * @author BF
 * @date 2020/12/9 19:30
 * <p>
 * 实时数据 DTO
 */
@Data
public class RealTimeDataDTO {
    /** 电流  1=0.01A，范围0-3000，数值0-30A */
    private Double current;
    /** 电机行程  1=0.5%，范围0-200，数值0-100% */
    private Double motorStroke;
    /** 电机速度  1=0.2cm/s，范围0-255，数值0-51cm/s */
    private Double motorSpeed;
    /** IO 数据 是个 String List IO 数据暂不解析 */
    private List<String> ioList;
    /** 故障类型，是个 String List */
    private List<String> faultList;
    /** 状态，是个 String List */
    private List<String> statusList;
}
