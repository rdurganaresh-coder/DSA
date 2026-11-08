package leetcode.Solutions_0001_0100.s0047_permutations_ii;

// #Medium #Array #Backtracking #Algorithm_II_Day_10_Recursion_Backtracking
// #2023_08_11_Time_1_ms_(99.86%)_Space_44.4_MB_(45.65%)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    private List<List<Integer>> ans;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        permute(nums, 0);
        return ans;
    }

    private void permute(int[] nums, int p) {
        if (p >= nums.length - 1) {
            List<Integer> t = new ArrayList<>(nums.length);
            for (int n : nums) {
                t.add(n);
            }
            ans.add(t);
            return;
        }
        permute(nums, p + 1);
        boolean[] used = new boolean[30];
        for (int i = p + 1; i < nums.length; i++) {
            if (nums[i] != nums[p] && !used[10 + nums[i]]) {
                used[10 + nums[i]] = true;
                swap(nums, p, i);
                permute(nums, p + 1);
                swap(nums, p, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        PermutationsII solver = new PermutationsII();

        // Test Case 1: Standard LeetCode Example (Contains duplicates)
        int[] nums1 = {1, 1, 2};
        List<List<Integer>> result1 = solver.permuteUnique(nums1);
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output Unique Permutations (" + result1.size() + "):");
        result1.forEach(System.out::println);
        System.out.println("Expected Unique Configurations: [,,]");
        System.out.println();

        // Test Case 2: Array with unique elements
        int[] nums2 = {1, 2, 3};
        List<List<Integer>> result2 = solver.permuteUnique(nums2);
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output Unique Permutations (" + result2.size() + "):");
        result2.forEach(System.out::println);
        System.out.println();

        // Test Case 3: All elements are identical duplicates
        int[] nums3 = {2, 2, 2};
        List<List<Integer>> result3 = solver.permuteUnique(nums3);
        System.out.println("Test Case 3 Input: " + Arrays.toString(nums3));
        System.out.println("Output Unique Permutations (" + result3.size() + "):");
        result3.forEach(System.out::println);
        System.out.println("Expected Unique Configurations: []");
    }
}
