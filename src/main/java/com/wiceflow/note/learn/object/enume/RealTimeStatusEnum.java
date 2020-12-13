package com.wiceflow.note.learn.object.enume;

/**
 * @author BF
 * @date 2020/12/10 10:37
 * <p>
 * 30-31 字节 状态枚举
 */
public enum RealTimeStatusEnum implements AbstractEnums {

    /**
     * 正在开门
     */
    THE_DOOR_IS_OPENING("正在开门", 0),
    /**
     * 开到位
     */
    OPENED("开到位", 1),
    /**
     * 正在关门
     */
    THE_DOOR_IS_CLOSING("正在关门", 2),
    /**
     * 关到位
     */
    CLOSED("关到位", 3),
    /**
     * 隔离
     */
    QUARANTINE("隔离", 4),
    /**
     * 紧急解锁
     */
    EMERGENCY_UNLOCKING("紧急解锁", 5),
    /**
     * 被对位隔离
     */
    ISOLATED_BY_CONTRAPTION("被对位隔离", 6);

    RealTimeStatusEnum(String name, int bitPosition) {
        this.name = name;
        this.bitPosition = bitPosition;
    }

    /**
     * 状态名称
     */
    private String name;
    /**
     * bit 下标
     */
    private int bitPosition;

    @Override
    public String getName(Integer bitPosition) {
        for (RealTimeStatusEnum status : RealTimeStatusEnum.values()) {
            if (status.getBitPosition() == bitPosition) {
                return status.getName();
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
