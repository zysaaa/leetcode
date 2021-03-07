package com.zysaaa.zysaaa20210225;

/**
 * @description: https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 *
 * 动态规划，跟之前那题很像。
 *
 * @author:zysaaa
 * @date: 2021/3/6 14:24
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int result = 0;
        int tmp = prices[0];
        for (int price : prices) {
            if (price > tmp) {
                result = Math.max((price - tmp), result);
            } else {
                tmp = price;
            }
        }
        return result;
    }
}
