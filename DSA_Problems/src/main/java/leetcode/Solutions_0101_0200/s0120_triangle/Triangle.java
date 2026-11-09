package leetcode.Solutions_0101_0200.s0120_triangle;

import java.util.ArrayList;

// #Medium #Array #Dynamic_Programming #Algorithm_I_Day_12_Dynamic_Programming
// #Dynamic_Programming_I_Day_13 #Udemy_Dynamic_Programming #Top_Interview_150_Multidimensional_DP
// #2025_03_06_Time_1_ms_(99.79%)_Space_44.45_MB_(35.64%)

import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int[] temp : dp) {
            Arrays.fill(temp, -10001);
        }
        return dfs(triangle, dp, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int[][] dp, int row, int col) {
        if (row >= triangle.size()) {
            return 0;
        }
        if (dp[row][col] != -10001) {
            return dp[row][col];
        }
        int sum =
                triangle.get(row).get(col)
                        + Math.min(
                                dfs(triangle, dp, row + 1, col),
                                dfs(triangle, dp, row + 1, col + 1));
        dp[row][col] = sum;
        return sum;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard multi-row triangle with mixed positive numbers
    // Path: 2 -> 3 -> 5 -> 1 = 11
    List<List<Integer>> triangle1 = new ArrayList<>();
    triangle1.add(List.of(2));
    triangle1.add(List.of(3, 4));
    triangle1.add(List.of(6, 5, 7));
    triangle1.add(List.of(4, 1, 8, 3));
    
    int result1 = new Triangle().minimumTotal(triangle1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 11

    // Test Case 2: Triangle containing negative path nodes
    // Path: -1 -> -3 = -4
    List<List<Integer>> triangle2 = new ArrayList<>();
    triangle2.add(List.of(-1));
    triangle2.add(List.of(-2, -3));
    
    int result2 = new Triangle().minimumTotal(triangle2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: -4

    // Test Case 3: Single element base case configuration
    List<List<Integer>> triangle3 = new ArrayList<>();
    triangle3.add(List.of(-10));
    
    int result3 = new Triangle().minimumTotal(triangle3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: -10

    // Test Case 4: Empty triangle edge case input
    List<List<Integer>> triangle4 = new ArrayList<>();
    int result4 = new Triangle().minimumTotal(triangle4);
    System.out.println("Test 4 Result (Empty): " + result4);
    // Expected Output: 0
}
}
