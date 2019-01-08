package com.douma.fast.util.sort;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2019/1/8 20:10
 */
public class Sort {

    public int[] replace(int[] ins, int index1, int index2){
        if(index1 == index2){
            return ins;
        }
        ins[index1] = ins[index1] + ins[index2];
        ins[index2] = ins[index1] - ins[index2];
        ins[index1] = ins[index1] - ins[index2];
        return ins;
    }

}
