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
        int max = 0;
        int now = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > now) {
                max = Math.max(max, prices[i] - now);
            } else {
                now = prices[i];
            }
        }
        return max;
    }
}
