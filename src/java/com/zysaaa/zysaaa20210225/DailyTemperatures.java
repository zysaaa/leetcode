package com.zysaaa.zysaaa20210225;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/daily-temperatures/
 * @author:zysaaa
 * @date: 2021/3/11 20:39
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }

    public int[] dailyTemperatures(int[] T) {
        if (T == null) {
            return null;
        }
        int[] result = new int[T.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {

            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                while (!stack.isEmpty()) {
                    if (T[i] > T[stack.peek()]) {
                        Integer pop = stack.pop();
                        result[pop] = i - pop;
                    } else {
                        break;
                    }
                }
            }
            stack.push(i);


        }
        return result;

    }
}
