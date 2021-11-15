package again.leetcode.数组;

import java.util.Arrays;

/**
 * @description: https://leetcode-cn.com/problems/find-lucky-integer-in-an-array/
 * @author: zysaaa
 * @date: 2021/11/4 20:59
 */
public class FindLucky {

    public int findLucky(int[] arr) {

        int[] array = new int[501];

        for (int i : arr) {
            array[i]++;
        }

        for (int i = 500; i > 0; i--) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;

    }


    public int findLucky2(int[] arr) {

        Arrays.sort(arr);
        int cur = 0, count = -1;
        for (int i = arr.length - 1; i >= 0; i--) {

            if (cur != arr[i]) {
                if (count == cur) {
                    return count;
                }
                cur = arr[i];
                count = 1;
            } else {
                count++;
            }
        }

        return count == cur ? count : -1;
    }
}
