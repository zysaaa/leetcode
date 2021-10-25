package again.leetcode.dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/pond-sizes-lcci/
 * @author: zysaaa
 * @date: 2021/10/25 11:35
 */
public class 水域大小 {

    public int[] pondSizes(int[][] land) {

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {

                if (land[i][j] == 0) {
                    resultList.add(dfs(land, i, j));
                }
            }
        }
        resultList.sort(Comparator.comparingInt(o -> o));
        int[] result = new int[resultList.size()];
        int idx = 0;
        for (Integer integer : resultList) {
            result[idx++] = integer;
        }
        return result;
    }


    public int dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[i].length || land[i][j] != 0) {
            return 0;
        }
        int count = 1;
        land[i][j] = -1;
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
