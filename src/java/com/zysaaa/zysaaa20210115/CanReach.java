package com.zysaaa.zysaaa20210115;

/**
 * @description: 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *

 * @author:zysaaa
 * @date: 2021/1/15 19:04
 */
public class CanReach {


    public static void main(String[] args) {
        System.out.println(canReach(new int[] {3,0,2,1,2}, 2));
    }

    public static boolean canReach(int[] arr, int start) {
        if (start < 0 || start > arr.length - 1 || arr[start] == -1) {
            return false;
        }
        int tmp = arr[start];
        arr[start] = -1;
        return tmp == 0 || canReach(arr, start + tmp) || canReach(arr, start - tmp);
    }
}
