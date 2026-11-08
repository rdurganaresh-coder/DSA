package leetcode.Solutions_0001_0100.s0064_minimum_path_sum;

// #Medium #Top_100_Liked_Questions #Array #Dynamic_Programming #Matrix
// #Dynamic_Programming_I_Day_16 #Udemy_Dynamic_Programming #Top_Interview_150_Multidimensional_DP
// #Big_O_Time_O(m*n)_Space_O(m*n) #2024_11_11_Time_1_ms_(99.73%)_Space_47.5_MB_(44.29%)

public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }
        int[][] dm = new int[grid.length][grid[0].length];
        int s = 0;
        for (int r = grid.length - 1; r >= 0; r--) {
            dm[r][grid[0].length - 1] = grid[r][grid[0].length - 1] + s;
            s += grid[r][grid[0].length - 1];
        }
        s = 0;
        for (int c = grid[0].length - 1; c >= 0; c--) {
            dm[grid.length - 1][c] = grid[grid.length - 1][c] + s;
            s += grid[grid.length - 1][c];
        }
        return recur(grid, dm, 0, 0);
    }

    private int recur(int[][] grid, int[][] dm, int r, int c) {
        if (dm[r][c] == 0 && r != grid.length - 1 && c != grid[0].length - 1) {
            dm[r][c] = grid[r][c] + Math.min(recur(grid, dm, r + 1, c), recur(grid, dm, r, c + 1));
        }
        return dm[r][c];
    }

    public static void main(String[] args) {
    // Test Case 1: Standard multi-row, multi-column grid
    // Path: 1 -> 3 -> 1 -> 1 -> 1 = 7
    int[][] grid1 = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };
    int result1 = new Minimum_Path_Sum().minPathSum(grid1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 7

    // Test Case 2: Standard small rectangular grid
    // Path: 1 -> 2 -> 3 = 6
    int[][] grid2 = {
        {1, 2, 3},
        {4, 5, 6}
    };
    int result2 = new Minimum_Path_Sum().minPathSum(grid2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 6

    // Test Case 3: Single cell base case matrix
    int[][] grid3 = {
        {5}
    };
    int result3 = new Minimum_Path_Sum().minPathSum(grid3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: 5

    // Test Case 4: Single row vector array
    int[][] grid4 = {
        {1, 2, 3, 4}
    };
    int result4 = new Minimum_Path_Sum().minPathSum(grid4);
    System.out.println("Test 4 Result: " + result4);
    // Expected Output: 10
}
}
