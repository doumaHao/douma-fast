package com.douma.fast.util.sort;

/**
 * @description: 选择排序
 * @author: Douma | Hao xijun
 * @date: 2019/1/8 19:32
 */
public class SelectSort {

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] ins = new int[]{4, 3, 2, 1};

        selectSort.sort(ins);

        for (int in : ins) {
            System.out.print(in + "  ");
        }

    }

    /**
     * 1，从第一个元素开始到最后一个元素为止找到最小的元素
     * 2，将该元素和第一个元素互换位置
     * 3，从第二个元素开始到最后一个元素为止找到最小的元素
     * 4，将该元素和第二个元素互换位置
     * 5，重复到最后
     * 6，最终实现选择排序
     *
     * @param ins
     * @return
     */
    public int[] sort(int[] ins) {
        int index = 1;
        while (ins.length > index) {
            ins = sortStartWith(ins, index);
            index++;
        }
        return ins;
    }

    private int[] sortStartWith(int[] ins, int start) {
        int min = ins[start - 1];
        int minIndex = start-1;
        int index = start;
        while (index <= ins.length) {
            if(ins[index-1] < min){
                minIndex = index-1;
                min = ins[index-1];
            }
            index++;
        }
        ins[start - 1] = ins[start - 1] + ins[minIndex];
        ins[minIndex] = ins[start - 1] - ins[minIndex];
        ins[start - 1] = ins[start - 1] - ins[minIndex];

        return ins;
    }

}
