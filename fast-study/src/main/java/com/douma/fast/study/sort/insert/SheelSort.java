package com.douma.fast.study.sort.insert;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2019/2/14 16:01
 */
public class SheelSort {

    public static void main(String[] args) {
        int[] ins = new int[]{10, 7, 8, 9, 6, 3, 4, 5, 2, 1};
        SheelSort sheelSort = new SheelSort();
        sheelSort.sort(ins);

        for (Integer in : ins) {
            System.out.print(in);
            System.out.print(" , ");
        }
    }

    public void sort(int[] a) {
        //单独把数组长度拿出来，提高效率
        int len = a.length;
        while (len != 0) {
            len = len / 2;
            //分组
            for (int i = 0; i < len; i++) {
                //元素从第二个开始
                for (int j = i + len; j < a.length; j += len) {
                    //k为有序序列最后一位的位数
                    int k = j - len;
                    //要插入的元素
                    int temp = a[j];
                    //从后往前遍历
                    while (k >= 0 && temp < a[k]) {
                        a[k + len] = a[k];
                        //向后移动len位
                        k -= len;
                    }
                    a[k + len] = temp;
                }
            }
        }
    }

}
