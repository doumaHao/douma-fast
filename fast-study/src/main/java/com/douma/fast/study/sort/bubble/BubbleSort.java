package com.douma.fast.study.sort.bubble;

import com.douma.fast.study.sort.ArrayReplace;

/**
 * @description: 冒泡排序
 * @author: Douma | Hao xijun
 * @date: 2019/1/28 13:50
 */
public class BubbleSort {


    public static void main(String[] args) {

        ArrayReplace arrayReplace = new ArrayReplace();

        Integer[] ins = new Integer[]{10, 7, 8, 9, 6, 3, 4, 5, 2, 1};

        for (int i = 0; i < ins.length; i++) {
            int thiz = i;
            int thizMax = ins[thiz];
            for (int j = 0; j < ins.length - i; j++) {
                if (ins[j] < thizMax) {
                    ins = arrayReplace.replace(ins, thiz, j);
                } else {
                    thiz = j;
                    thizMax = ins[thiz];
                }
            }
        }

        for (Integer in : ins) {
            System.out.print(in);
            System.out.print(" , ");
        }

    }

}
