package zysaaa20210218;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description: https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * @author:zysaaa
 * @date: 2021/2/18 20:35
 */
public class MinIncrementForUnique {
    public static void main(String[] args) {
        System.out.println(new MinIncrementForUnique().minIncrementForUnique(new int[] {8,8,8}));
    }
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                A[i] ++;
                result++;
            } else if (A[i] < A[i - 1]) {
                int tmp = A[i - 1] - A[i];
                A[i] += (tmp+1);
                result += (tmp+1);

            }
        }
        return result;
    }

}
