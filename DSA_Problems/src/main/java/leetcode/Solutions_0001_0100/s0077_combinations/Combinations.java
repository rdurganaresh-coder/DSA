package leetcode.Solutions_0001_0100.s0077_combinations;

// #Medium #Backtracking #Algorithm_I_Day_11_Recursion_Backtracking #Top_Interview_150_Backtracking
// #2025_03_05_Time_15_ms_(92.38%)_Space_92.30_MB_(94.55%)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("java:S1149")
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        // Boundary case
        if (n > 20 || k < 1 || k > n) {
            return ans;
        }
        backtrack(ans, n, k, 1, new ArrayDeque<>());
        return ans;
    }

    private void backtrack(
            List<List<Integer>> ans, int n, int k, int s, ArrayDeque<Integer> stack) {
        // Base case
        // If k becomes 0
        if (k == 0) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        // Start with s till n-k+1
        for (int i = s; i <= (n - k) + 1; i++) {
            stack.push(i);
            // Update start for recursion and decrease k by 1
            backtrack(ans, n, k - 1, i + 1, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
    // Test Case 1: Standard small input (n = 4, k = 2)
    // Expected combinations:, [1,3], [1,4], [2,3], [2,4], [3,4]
    List<List<Integer>> result1 = new Combinations().combine(4, 2);
    System.out.println("Test 1 (n=4, k=2) Count: " + result1.size());
    System.out.println("Test 1 Result: " + result1);
    System.out.println();

    // Test Case 2: Minimal single-element choice (n = 1, k = 1)
    // Expected combinations: [1]
    List<List<Integer>> result2 = new Combinations().combine(1, 1);
    System.out.println("Test 2 (n=1, k=1) Count: " + result2.size());
    System.out.println("Test 2 Result: " + result2);
    System.out.println();

    // Test Case 3: Choosing all available numbers (n = 3, k = 3)
    // Expected combinations: [1,2,3]
    List<List<Integer>> result3 = new Combinations().combine(3, 3);
    System.out.println("Test 3 (n=3, k=3) Count: " + result3.size());
    System.out.println("Test 3 Result: " + result3);
    System.out.println();

    // Test Case 4: Invalid constraint case where k > n (Should output empty list [])
    List<List<Integer>> result4 = new Combinations().combine(2, 3);
    System.out.println("Test 4 (n=2, k=3) Count: " + result4.size());
    System.out.println("Test 4 Result: " + result4);
}
}
