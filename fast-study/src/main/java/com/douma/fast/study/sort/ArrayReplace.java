package com.douma.fast.study.sort;

/**
 * @description: 数据中两个数据相互交换
 * @author: Douma | Hao xijun
 * @date: 2019/1/28 13:53
 */
public class ArrayReplace {

    /**
     * 将数组中指定位置的2个元素交换后返回交换后的数组
     *
     * @param array
     * @param index1
     * @param index2
     * @return
     */
    public Integer[] replace(Integer[] array, int index1, int index2) {
        if (array == null) {
            throw new IllegalArgumentException("array is null");
        }
        if (array.length < index1 || array.length < index2) {
            throw new IllegalArgumentException("index1 or index2 is longer than array's length");
        }
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return array;
    }

}
