package dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/pond-sizes-lcci/
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class PondSizes {

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    list.add(dfs(land, i, j));
                }
            }
        }
        list.sort(Integer::compareTo);
        int[] result = new int[list.size()];
        int idx = 0;
        for (Integer integer : list) {
            result[idx++] = integer;
        }
        return result;
    }

    public int dfs(int[][] land, int i, int j) {
        if (i < 0 || j < 0 || i == land.length || j == land[0].length || land[i][j] != 0) {
            return 0;
        }
        int cur = 1;
        land[i][j] = -1;
        cur += dfs(land, i + 1, j + 1);
        cur += dfs(land, i + 1, j - 1);
        cur += dfs(land, i + 1, j);
        cur += dfs(land, i, j + 1);
        cur += dfs(land, i, j - 1);
        cur += dfs(land, i - 1, j - 1);
        cur += dfs(land, i - 1, j + 1);
        cur += dfs(land, i - 1, j);
        return cur;
    }
}
