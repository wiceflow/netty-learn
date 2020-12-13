package com.wiceflow.note.learn.object.enume;

import com.wiceflow.note.learn.util.ConstantUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BF
 * @date 2020/12/9 16:51
 * <p>
 * 二十六字节枚举  -> 故障类型
 */
public enum TwentySixFaultEnum implements AbstractEnums {
    /**
     * 检测到障碍物
     */
    OBSTRUCTION_DETECTED("检测到障碍物", 0),
    /**
     * 关门障碍物超限
     */
    DOOR_CLOSING_OBSTACLE_OVERRUN("关门障碍物超限", 1),
    /**
     * 开门障碍物超限
     */
    DOOR_OPENING_OBSTACLE_OVERRUN("开门障碍物超限", 2),
    /**
     * 电机驱动故障
     */
    MOTOR_DRIVE_FAILURE("电机驱动故障", 3),
    /**
     * 电机反馈故障
     */
    MOTOR_FEEDBACK_FAULT("电机反馈故障", 4),
    /**
     * 锁到位故障
     */
    LOCK_IN_PLACE_FAULT("锁到位故障", 5),
    /**
     * 关到位故障
     */
    FAILURE_OF_CLOSING_IN_PLACE("关到位故障", 6),
    /**
     * 安全回路故障
     */
    SAFETY_LOOP_FAULT("安全回路故障", 7);

    /**
     * 故障名称
     */
    private String name;
    /**
     * bit 下标
     */
    private int bitPosition;

    TwentySixFaultEnum(String name, int bitPosition) {
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
        for (TwentySixFaultEnum fault : TwentySixFaultEnum.values()) {
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
