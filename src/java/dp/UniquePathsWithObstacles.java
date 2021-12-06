package dp;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length ; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == -1) {
                break;
            }
            obstacleGrid[0][i] = 1;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == -1) {
                break;
            }
            obstacleGrid[i][0] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length ; j++) {
                if (obstacleGrid[i][j] != -1) {
                    if (obstacleGrid[i - 1][j] != -1) {
                        obstacleGrid[i][j] += obstacleGrid[i-1][j];
                    }
                    if (obstacleGrid[i][j - 1] != -1) {
                        obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                    }
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    // from website --better
    /*public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int steps[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0]==1){break;}
            steps[i][0]=1;
        }
        for(int j=0;j<obstacleGrid[0].length;j++){
            if(obstacleGrid[0][j]==1){break;}
            steps[0][j]=1;

        }
        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++){
                steps[i][j]=obstacleGrid[i][j]==1?0:steps[i-1][j]+steps[i][j-1];
            }
        }
        return steps[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }*/
}
