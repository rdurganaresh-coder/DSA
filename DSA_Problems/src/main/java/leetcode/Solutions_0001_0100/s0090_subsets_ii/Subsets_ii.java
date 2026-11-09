package leetcode.Solutions_0001_0100.s0090_subsets_ii;

// #Medium #Array #Bit_Manipulation #Backtracking #Algorithm_II_Day_9_Recursion_Backtracking
// #2022_06_20_Time_2_ms_(82.94%)_Space_43.5_MB_(77.86%)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("java:S5413")
public class Subsets_ii {
    List<List<Integer>> allComb = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0);
        allComb.add(new ArrayList<>());
        return allComb;
    }

    private void dfs(int start) {
        if (start > nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            comb.add(nums[i]);
            allComb.add(new ArrayList<>(comb));
            dfs(i + 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
    // Test Case 1: Standard input array containing duplicates
    // Expected Output: Extracted subset entries without duplicates
    int[] nums1 = {1, 2, 2};
    List<List<Integer>> result1 = new Subsets_ii().subsetsWithDup(nums1);
    System.out.println("Test 1 Result: " + result1);
    System.out.println();

    // Test Case 2: Minimal array with single element base value
    int[] nums2 = {0};
    List<List<Integer>> result2 = new Subsets_ii().subsetsWithDup(nums2);
    System.out.println("Test 2 Result: " + result2);
    System.out.println();

    // Test Case 3: Empty input array edge case
    int[] nums3 = {};
    List<List<Integer>> result3 = new Subsets_ii().subsetsWithDup(nums3);
    System.out.println("Test 3 Result: " + result3);
    System.out.println();

    // Test Case 4: Unsorted sequence containing multiple scattered duplicate layers
    int[] nums4 = {4, 4, 1, 4};
    List<List<Integer>> result4 = new Subsets_ii().subsetsWithDup(nums4);
    System.out.println("Test 4 Result: " + result4);
}
}
