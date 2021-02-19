package com.zysaaa.zysaaa20210219;

/**
 * @description: https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @author:zysaaa
 * @date: 2021/2/19 20:04
 */
public class FindNumberIn2DArray {

    public static void main(String[] args) {
        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(new int[][] {{1,1}}, 2));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while (i < n && j > -1) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }


}
