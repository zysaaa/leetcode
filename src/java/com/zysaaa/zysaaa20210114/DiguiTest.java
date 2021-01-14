package com.zysaaa.zysaaa20210114;

import java.util.Arrays;

/**
 * @description: 递归递归递归
 * @author:zysaaa
 * @date: 2021/1/14 21:19
 */
public class DiguiTest {

    public static void main(String[] args) {
        int[] ints = {1, 32, 423, 42};
        bubbleSort(ints, ints.length - 1);
        System.out.println(Arrays.toString(ints));

    }

    // 冒泡排序 ---递归
    public static void bubbleSort(int[] arrays, int R) {
        if (0 == R) {
            return;
        }
        int maxInd = 0;
        for (int i = 1; i <= R; i++) {
            if (arrays[i] > arrays[maxInd]) {
                maxInd = i;
            }
            int tmp = arrays[maxInd];
            arrays[maxInd] = arrays[R];
            arrays[R] = tmp;
            System.out.println(Arrays.toString(arrays));
            bubbleSort(arrays, R - 1);
        }
    }


}
