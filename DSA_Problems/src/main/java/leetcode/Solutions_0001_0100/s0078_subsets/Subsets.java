package leetcode.Solutions_0001_0100.s0078_subsets;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Bit_Manipulation #Backtracking
// #Algorithm_II_Day_9_Recursion_Backtracking #Udemy_Backtracking/Recursion
// #Big_O_Time_O(2^n)_Space_O(n*2^n) #2024_11_11_Time_0_ms_(100.00%)_Space_43_MB_(12.48%)

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("java:S5413")
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, new ArrayList<>(), res, 0);
        return res;
    }

    private void solve(int[] nums, List<Integer> temp, List<List<Integer>> res, int start) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            solve(nums, temp, res, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
    // Test Case 1: Standard input with three distinct values
    // Expected total elements: 2^3 = 8 subsets
    int[] nums1 = {1, 2, 3};
    List<List<Integer>> result1 = new Subsets().subsets(nums1);
    System.out.println("Test 1 Total Subsets: " + result1.size());
    System.out.println("Test 1 Result: " + result1);
    System.out.println();

    // Test Case 2: Single element array base case
    // Expected total elements: 2^1 = 2 subsets ([], [0])
    int[] nums2 = {0};
    List<List<Integer>> result2 = new Subsets().subsets(nums2);
    System.out.println("Test 2 Total Subsets: " + result2.size());
    System.out.println("Test 2 Result: " + result2);
    System.out.println();

    // Test Case 3: Empty input array edge case
    // Expected total elements: 2^0 = 1 subset ([])
    int[] nums3 = {};
    List<List<Integer>> result3 = new Subsets().subsets(nums3);
    System.out.println("Test 3 Total Subsets: " + result3.size());
    System.out.println("Test 3 Result: " + result3);
}
}
