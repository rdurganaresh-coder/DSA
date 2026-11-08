package leetcode.Solutions_0001_0100.s0062_unique_paths;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Dynamic_Programming #Math
// #Combinatorics #LeetCode_75_DP/Multidimensional #Algorithm_II_Day_13_Dynamic_Programming
// #Dynamic_Programming_I_Day_15 #Level_1_Day_11_Dynamic_Programming
// #Big_O_Time_O(m*n)_Space_O(m*n) #2024_11_11_Time_0_ms_(100.00%)_Space_40.7_MB_(12.56%)

public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
    // Test Case 1: Standard small grid (3x7 grid)
    int result1 = new Unique_Paths().uniquePaths(3, 7);
    System.out.println("Test 1 Result (3x7): " + result1);
    // Expected Output: 28

    // Test Case 2: Minimal standard grid (3x2 grid)
    int result2 = new Unique_Paths().uniquePaths(3, 2);
    System.out.println("Test 2 Result (3x2): " + result2);
    // Expected Output: 3

    // Test Case 3: Single cell base case (1x1 grid)
    int result3 = new Unique_Paths().uniquePaths(1, 1);
    System.out.println("Test 3 Result (1x1): " + result3);
    // Expected Output: 1

    // Test Case 4: Long single row strip grid (1x10 grid)
    int result4 = new Unique_Paths().uniquePaths(1, 10);
    System.out.println("Test 4 Result (1x10): " + result4);
    // Expected Output: 1
}
}
