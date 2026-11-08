package leetcode.Solutions_0001_0100.s0046_permutations;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Backtracking
// #Algorithm_I_Day_11_Recursion_Backtracking #Level_2_Day_20_Brute_Force/Backtracking
// #Udemy_Backtracking/Recursion #Top_Interview_150_Backtracking #Big_O_Time_O(n*n!)_Space_O(n+n!)
// #2024_11_10_Time_1_ms_(94.08%)_Space_45.1_MB_(6.84%)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> finalResult = new ArrayList<>();
        permuteRecur(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
        return finalResult;
    }

    private void permuteRecur(
            int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {
        if (currResult.size() == nums.length) {
            finalResult.add(new ArrayList<>(currResult));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            currResult.add(nums[i]);
            used[i] = true;
            permuteRecur(nums, finalResult, currResult, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations solver = new Permutations();

        // Test Case 1: Standard LeetCode Example 1 (3 unique elements)
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solver.permute(nums1);
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output (" + result1.size() + " permutations):");
        result1.forEach(System.out::println);
        System.out.println();

        // Test Case 2: Standard LeetCode Example 2 (2 elements)
        int[] nums2 = {0, 1};
        List<List<Integer>> result2 = solver.permute(nums2);
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output (" + result2.size() + " permutations):");
        result2.forEach(System.out::println);
        System.out.println();

        // Test Case 3: Single Element Edge Case
        int[] nums3 = {1};
        List<List<Integer>> result3 = solver.permute(nums3);
        System.out.println("Test Case 3 Input: " + Arrays.toString(nums3));
        System.out.println("Output (" + result3.size() + " permutations):");
        result3.forEach(System.out::println);
    }
}
