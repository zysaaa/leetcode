package again.leetcode.dfs;

/**
 * @description: https://leetcode-cn.com/problems/number-of-islands/
 * @author: zysaaa
 * @date: 2021/10/25 11:24
 */
public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;

    }

    public void dfs(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'X';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }
}
