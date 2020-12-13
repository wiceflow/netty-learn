package com.wiceflow.note.learn.object.dto;

import lombok.Data;

/**
 * @author BF
 * @date 2020/12/10 11:28
 * <p>
 * 开关门统计数据
 * 是否有统计数据 0 -> 无数据、1 -> 有开门完成数据、2 -> 有关门完成数据
 */
@Data
public class StatisticsDataDTO {

    /**
     * 开门还是关门 1 开门、2 关门
     */
    private Integer doorStatus;
    /** 上一次开门时间（1=1ms，范围0-10000，数值0-10000ms） */
    private Integer lastOpeningTime;
    /** 总开门次数 */
    private Long allOpenCount;
    /** 平均电流（1=0.01A，范围0-3000，数值0-30A）这里解析成具体的多少 A */
    private Integer averageCurrent;
    /** 峰值电流（1=0.01A，范围0-3000，数值0-30A）这里解析成具体的多少 A */
    private Integer peakCurrent;
    /** 开门时最大开度（1=0.1%，范围0-1000，数值0-100%）开度只会在开门的时候才有数据 */
    private Integer bigAperture;
    /** 开门后停止开度（1=0.1%，范围0-1000，数值0-100%）开度只会在开门的时候才有数据 */
    private Integer stopAperture;
    /** 解锁时间的亚健康程度（0-5，0健康，1-5亚健康程度） */
    private Integer unlockTimeSubHealth;
    /** 解锁电流最大值的亚健康程度（0-5，0健康，1-5亚健康程度） */
    private Integer unlockTheMaximumCurrentSubHealth;
    /** 塞拉电流最大值的亚健康程度（0-5，0健康，1-5亚健康程度） */
    private Integer selaCurrentMaximumSubHealth;
    /** 塞拉电流均值的亚健康程度（0-5，0健康，1-5亚健康程度） */
    private Integer serraCurrentMeanSubHealth;
    /** 塞拉电流方差的亚健康程度（0-5，0健康，1-5亚健康程度） */
    private Integer serraCurrentVarianceSubHealth;
    /** 平移电流最大值的亚健康程度（0-5，0健康，1-5亚健康程度） */
    private Integer maximumTranslationCurrentSubHealth;
    /** 平移电流均值的亚健康程度（0-5，0健康，1-5亚健康程度） */
    private Integer translationalCurrentMeanValueSubHealth;
    /** 平移电流方差的亚健康程度（0-5，0健康，1-5亚健康程度） */
    private Integer translationalCurrentVarianceSubHealth;

}
