package com.zysaaa.zysaaa20210225;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/3/15 20:57
 */
public class Paixu {


    private static void insertSort(int[] a) {

        int i, j, insertNote;// 要插入的数据
        for (i = 1; i < a.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertNote = a[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && insertNote < a[j]) {
                a[j + 1] = a[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            a[j + 1] = insertNote;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
    }


    private static void copy(int[] a) {

        for (int i = 1; i < a.length; i++) {

            int target = a[1];
            int j = i - 1;
            while (j > -1 && a[j] > target) {
                a[j + 1] = a[j];
                j --;
            }
            a[j + 1] = target;

        }

    }
}
