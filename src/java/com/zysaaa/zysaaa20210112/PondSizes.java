package com.zysaaa.zysaaa20210112;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 *
 * @author:zysaaa
 * @date: 2021/1/12 20:08
 */
public class PondSizes {

    public static void main(String[] args) {

        System.out.println(pondSizes(new int[][]{{0,2,1,0},{0,1,0,1},{0,1,0,1},{0,1,0,1}}));

    }

    public static int[] pondSizes(int[][] land) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    list.add(dfs(land, i, j));
                }

            }
        }

        list.sort(Comparator.comparingInt(o -> o));
        int[] result = new int[list.size()];
        int idx = 0;
        for (Integer integer : list) {
            result[idx++] = integer;
        }
        return result;
    }


    private static int dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[i].length || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        int count = 1;
        count += dfs(land, i, j-1);
        count += dfs(land, i, j+1);
        count += dfs(land, i+1, j);
        count += dfs(land, i-1, j);
        count += dfs(land, i+1, j+1);
        count += dfs(land, i-1, j-1);
        count += dfs(land, i+1, j-1);
        count += dfs(land, i-1, j+1);
        return count;
    }

}
