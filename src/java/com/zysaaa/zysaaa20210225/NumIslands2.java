package com.zysaaa.zysaaa20210225;

/**
 * @description: https://leetcode-cn.com/problems/number-of-islands/
 * @author:zysaaa
 * @date: 2021/3/15 22:03
 */
public class NumIslands2 {

    public int numIslands(char[][] grid) {
        int islandNum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }


    private void dfs(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);

    }
}
