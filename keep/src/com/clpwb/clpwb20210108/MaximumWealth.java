package com.clpwb.clpwb20210108;

/**
 * @description: 给你一个 m x n 的整数网格 accounts ，
 * 其中 accounts[i][j] 是第 i位客户在第 j 家银行托管的资产数量。
 * 返回最富有客户所拥有的 资产总量 。
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 *
 * @author:zysaaa
 * @date: 2021/1/8 19:05
 */
public class MaximumWealth {

    public static void main(String[] args) {
        int a[][]={{1,2,3},{3,2,1}};
        System.out.println(maximumWealth(a));  // 6
    }

    public static int maximumWealth(int[][] accounts) {
        if (accounts == null || accounts.length == 0) {
            return 0;
        }
        int length1 = accounts.length;
        int length2 = accounts[0].length;
        int max = 0;
        for (int i = 0; i < length1; i++) {
            int tmp = 0;
            for (int j = 0; j < length2; j++) {
                tmp += accounts[i][j];
            }
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;

    }
}
