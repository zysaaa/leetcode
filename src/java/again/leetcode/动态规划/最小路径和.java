package again.leetcode.动态规划;

public class 最小路径和 {

    public static void main(String[] args) {
        System.out.println(new 最小路径和().minPathSum(new int[][] {{1,3,1}, {1,5,1}, {4,2,1}}));
    }

    // use dp
    public int minPathSum(int[][] grid) {


        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }

        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] = grid[0][j] + grid[0][j - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];

    }



    // dfs timeout
    /*public int minPathSum() {
        int[][] grid = new int[][] {{1,2,3}, {4,5,6}};
        return dfs(grid, 0 ,0);
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if ((i == grid.length - 1) && j < grid[0].length - 1) {
            return grid[i][j] + dfs(grid,i, j+1);
        } else if (j == grid[0].length - 1 && i < grid.length - 1) {
            return grid[i][j] + dfs(grid,i + 1, j);
        } else {
            return grid[i][j] + Math.min(dfs(grid, i + 1, j), dfs(grid, i, j+ 1));
        }
    }*/
}
