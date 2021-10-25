package again.leetcode.数组;

/**
 * @description: https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author: zysaaa
 * @date: 2021/10/24 20:11
 */
public class 二维数组中查找目标值 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;


        while (left <= right) {

            int mid =( right - left / 2) + left;
            int val = matrix[mid / n][mid % n];
            if (val == target) {
                return true;
            } else if (val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;


    }
}
