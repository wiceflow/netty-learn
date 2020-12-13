package com.wiceflow.note.learn.object.enume;

import com.wiceflow.note.learn.util.ConstantUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BF
 * @date 2020/12/9 20:07
 * <p>
 * 二十七字节枚举  -> 故障类型
 */
public enum TwentySevenFaultEnum implements AbstractEnums{

    /**
     * EDCU其他内部故障
     */
    EDCU_OTHER_INTERNAL_FAULTS("EDCU其他内部故障", 7),
    /**
     * EDCU输出存在故障
     */
    EDCU_THE_OUTPUT_IS_FAULTY("EDCU输出存在故障", 6),
    /**
     * 关门失败
     */
    CLOSING_THE_DOOR_FAILED("关门失败", 1),
    /**
     * 开门失败
     */
    FAILED_TO_OPEN_THE_DOOR("开门失败", 0);


    /**
     * 故障名称
     */
    private String name;
    /**
     * bit 下标
     */
    private int bitPosition;

    TwentySevenFaultEnum(String name, int bitPosition) {
        this.name = name;
        this.bitPosition = bitPosition;
    }

    /**
     * 根据下标获取故障名称
     *
     * @param bitPosition [Integer] Integer 数组的下标
     * @return 故障名称
     */
    @Override
    public String getName(Integer bitPosition) {
        for (TwentySevenFaultEnum fault : TwentySevenFaultEnum.values()) {
            if (fault.getBitPosition() == bitPosition) {
                return fault.getName();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBitPosition() {
        return bitPosition;
    }

    public void setBitPosition(int bitPosition) {
        this.bitPosition = bitPosition;
    }
}
