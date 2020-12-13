package com.wiceflow.note.learn.object.enume;

import com.wiceflow.note.learn.util.ConstantUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BF
 * @date 2020/12/10 10:45
 */
public interface AbstractEnums {

    /**
     * 根据下标获取名称
     *
     * @param bitPosition [Integer] Integer 数组的下标
     * @return 枚举名称
     */
    String getName(Integer bitPosition);


    /**
     * 获取故障类型列表
     *
     * @param bitArray [int[]] 27 字节的 bit 所表示二进制数组
     * @return 故障数组，可以为空
     */
    default List<String> getTypeByIntArray(int[] bitArray) {
        List<String> result = new ArrayList<>(ConstantUtil.BIT_LENGTH);
        if (bitArray.length != ConstantUtil.BIT_LENGTH) {
            return result;
        }
        for (int i = bitArray.length - 1; i >= 0; i--) {
            if (bitArray[i] == ConstantUtil.POSITIVE_POTENTIAL) {
                String name = getName(i);
                result.add(name);
            }
        }
        return result;
    }
}
