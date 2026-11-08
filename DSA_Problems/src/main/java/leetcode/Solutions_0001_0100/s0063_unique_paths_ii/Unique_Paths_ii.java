package leetcode.Solutions_0001_0100.s0063_unique_paths_ii;

// #Medium #Array #Dynamic_Programming #Matrix #Dynamic_Programming_I_Day_15
// #Top_Interview_150_Multidimensional_DP #2025_03_04_Time_0_ms_(100.00%)_Space_41.62_MB_(79.66%)

public class Unique_Paths_ii {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // if start point has obstacle, there's no path
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                obstacleGrid[0][j] = 0;
            } else {
                obstacleGrid[0][j] = obstacleGrid[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
    // Test Case 1: Standard grid with a central obstacle
    int[][] grid1 = {
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
    };
    int result1 = new Unique_Paths_ii().uniquePathsWithObstacles(grid1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 2

    // Test Case 2: Obstacle blocking the starting cell
    int[][] grid2 = {
        {1, 0},
        {0, 0}
    };
    int result2 = new Unique_Paths_ii().uniquePathsWithObstacles(grid2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 0

    // Test Case 3: Obstacle blocking an entire border edge row/column
    int[][] grid3 = {
        {0, 1},
        {0, 0}
    };
    int result3 = new Unique_Paths_ii().uniquePathsWithObstacles(grid3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: 1

    // Test Case 4: Minimal single-cell grid without obstacle
    int[][] grid4 = {
        {0}
    };
    int result4 = new Unique_Paths_ii().uniquePathsWithObstacles(grid4);
    System.out.println("Test 4 Result: " + result4);
    // Expected Output: 1
}
}
