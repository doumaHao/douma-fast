package com.douma.fast.util.sort;

/**
 * @description: 冒泡排序
 * @author: Douma | Hao xijun
 * @date: 2019/1/4 10:29
 */
public class BubbleSort extends Sort{

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] ins = new int[]{5, 4, 3, 2, 1};

        bubbleSort.sort(ins);

        for (int in : ins) {
            System.out.print(in + "  ");
        }

    }

    /**
     * 1，比较第一个元素和第二个元素，将大的元素放到右边
     * 2，再比较第二个元素和第三个元素，将大的元素放到右边
     * 3，一直重复，直到第N-1个元素和第N个元素比较之后，最右边元素肯定是最大元素
     * 4，重复1-3步骤，但是最终是到N-2个元素到N-1个元素
     * 5，最终实现冒泡排序
     *
     * @param ins
     * @return
     */
    public int[] sort(int[] ins) {
        int index = 1;
        while (ins.length > index) {
            ins = sortEndWith(ins, index);
            index++;
        }
        return ins;
    }

    private int[] sortEndWith(int[] ins, int end) {
        int index = 0;
        while (index < ins.length - end) {
            if (ins[index] >= ins[index + 1]) {
                ins = replace(ins, index, index+1);
            }
            index++;
        }
        return ins;
    }

}
