package com.douma.fast.study.sort.insert;

/**
 * @description: 直接插入排序
 * @author: Douma | Hao xijun
 * @date: 2019/2/14 14:15
 */
public class DirectInsertSort {

    public static void main(String[] args) {
        int[] ins = new int[]{10, 7, 8, 9, 6, 3, 4, 5, 2, 1};
        DirectInsertSort directInsertSort = new DirectInsertSort();
        directInsertSort.sort(ins);

        for (Integer in : ins) {
            System.out.print(in);
            System.out.print(" , ");
        }
    }

    /**
     * 1, 从第二个数开始，选中第二个数字插入到前面的有序队列中（第一个数只有一个数，天然就是有序的）
     * 2, 选中的数字 和 前面的有序队列 从尾巴开始对比 如果对比数比选中数大 则对比数往后移动一位，
     * 3, 再继续对比 一直到对比完成
     *
     * @param a
     */
    public void sort(int[] a) {
        //单独把数组长度拿出来，提高效率
        int len = a.length;
        //要插入的数
        int insertNum;
        //因为第一次不用，所以从1开始
        for (int i = 1; i < len; i++) {
            insertNum = a[i];
            //序列元素个数
            int j = i - 1;
            //从后往前循环，将大于insertNum的数向后移动
            while (j >= 0 && a[j] > insertNum) {
                //元素向后移动
                a[j + 1] = a[j];
                j--;
            }
            //找到位置，插入当前元素
            a[j + 1] = insertNum;
        }
    }

}
