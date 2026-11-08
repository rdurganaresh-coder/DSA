package leetcode.Solutions_0001_0100.s0040_combination_sum_ii;

// #Medium #Array #Backtracking #Algorithm_II_Day_10_Recursion_Backtracking
// #2023_08_09_Time_2_ms_(99.75%)_Space_43.9_MB_(10.59%)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sums = new ArrayList<>();
        // optimize
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, sums, new LinkedList<>());
        return sums;
    }

    private void combinationSum(
            int[] candidates,
            int target,
            int start,
            List<List<Integer>> sums,
            LinkedList<Integer> sum) {
        if (target == 0) {
            // make a deep copy of the current combination
            sums.add(new ArrayList<>(sum));
            return;
        }
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            // If candidate[i] equals candidate[i-1], then solutions for i is subset of
            // solution of i-1
            if (i == start || (i > start && candidates[i] != candidates[i - 1])) {
                sum.addLast(candidates[i]);
                // call on 'i+1' (not i) to avoid duplicate usage of same element
                combinationSum(candidates, target - candidates[i], i + 1, sums, sum);
                sum.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII solver = new CombinationSumII();

        // Test Case 1: Standard LeetCode Example 1 (Contains duplicates in elements)
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        List<List<Integer>> result1 = solver.combinationSum2(candidates1, target1);
        System.out.println("Test Case 1 Candidates: " + Arrays.toString(candidates1) + ", Target: " + target1);
        System.out.println("Output: ");
        result1.forEach(System.out::println);
        System.out.println("Expected:, [1, 2, 5], [1, 7], [2, 6]");
        System.out.println();

        // Test Case 2: Standard LeetCode Example 2
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        List<List<Integer>> result2 = solver.combinationSum2(candidates2, target2);
        System.out.println("Test Case 2 Candidates: " + Arrays.toString(candidates2) + ", Target: " + target2);
        System.out.println("Output: ");
        result2.forEach(System.out::println);
        System.out.println("Expected:, [5]");
        System.out.println();

        // Test Case 3: Target cannot be matched
        int[] candidates3 = {2, 3, 5};
        int target3 = 4;
        List<List<Integer>> result3 = solver.combinationSum2(candidates3, target3);
        System.out.println("Test Case 3 Candidates: " + Arrays.toString(candidates3) + ", Target: " + target3);
        System.out.println("Output: ");
        result3.forEach(System.out::println);
        System.out.println("Expected: [] (Empty List)");
    }
}
