package leetcode.Solutions_0001_0100.s0039_combination_sum;

// #Medium #Top_100_Liked_Questions #Array #Backtracking #Algorithm_II_Day_10_Recursion_Backtracking
// #Level_2_Day_20_Brute_Force/Backtracking #Udemy_Backtracking/Recursion
// #Top_Interview_150_Backtracking #Big_O_Time_O(2^n)_Space_O(n+2^n)
// #2024_11_10_Time_1_ms_(99.99%)_Space_44.5_MB_(51.73%)

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] coins, int amount) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        combinationSumRec(coins.length, coins, amount, subList, ans);
        return ans;
    }

    private void combinationSumRec(
            int n, int[] coins, int amount, List<Integer> subList, List<List<Integer>> ans) {
        if (amount == 0 || n == 0) {
            if (amount == 0) {
                List<Integer> base = new ArrayList<>(subList);
                ans.add(base);
            }
            return;
        }
        if (amount - coins[n - 1] >= 0) {
            subList.add(coins[n - 1]);
            combinationSumRec(n, coins, amount - coins[n - 1], subList, ans);
            subList.remove(subList.size() - 1);
        }
        combinationSumRec(n - 1, coins, amount, subList, ans);
    }

    public static void main(String[] args) {
        CombinationSum solver = new CombinationSum();

        // Test Case 1: Standard LeetCode Example 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> result1 = solver.combinationSum(candidates1, target1);
        System.out.println("Test Case 1 Candidates:, Target: 7");
        System.out.print("Output: ");
        result1.forEach(System.out::println);
        System.out.println("Expected: [[7], [3, 2, 2]] (Order may vary depending on recursion)");
        System.out.println();

        // Test Case 2: Standard LeetCode Example 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> result2 = solver.combinationSum(candidates2, target2);
        System.out.println("Test Case 2 Candidates:, Target: 8");
        System.out.print("Output: ");
        result2.forEach(System.out::println);
        System.out.println("Expected: [[5, 3], [3, 3, 2], [2, 2, 2, 2]]");
        System.out.println();

        // Test Case 3: Target cannot be formed
        int[] candidates3 = {2};
        int target3 = 1;
        List<List<Integer>> result3 = solver.combinationSum(candidates3, target3);
        System.out.println("Test Case 3 Candidates:, Target: 1");
        System.out.print("Output: ");
        result3.forEach(System.out::println);
        System.out.println("Expected: [] (Empty list)");
    }
}
