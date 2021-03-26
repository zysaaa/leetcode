package com.zysaaa.zysaaa20210225;

import java.util.Arrays;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/3/26 19:26
 */
public class DuiPaixu {


    public void sortArray(int[] ints) {
        // 构造大顶堆
        // 从第一个非叶子节点开始
        int parent = ints.length / 2 - 1;
        for (int i = parent; i >= 0; i--) {
            heapify(ints, ints.length, i);
        }
        for (int i = ints.length - 1; i >= 0; i--) {
            swap(ints, i, 0);
            heapify(ints, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] ints = {3, 4, 5, 9, 1};
        new DuiPaixu().sortArray(ints);
        System.out.println(Arrays.toString(ints));
    }


    public void heapify(int[] ints, int n, int index) {
        if (index > n - 1) {
            return;
        }
        int c1 = 2 * index + 1;
        int c2 = 2 * index + 2;
        int max = index;
        if (c1 <= n - 1 && ints[c1] > ints[max]) {
            max = c1;
        }
        if (c2 <= n - 1 && ints[c2] > ints[max]) {
            max = c2;
        }
        if (max != index) {
            swap(ints, index, max);
            heapify(ints, n, max);
        }
    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }
}
