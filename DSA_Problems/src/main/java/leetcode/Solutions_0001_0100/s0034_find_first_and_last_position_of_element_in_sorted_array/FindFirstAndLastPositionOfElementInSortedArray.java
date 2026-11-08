package leetcode.Solutions_0001_0100.s0034_find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Binary_Search
// #Algorithm_II_Day_1_Binary_Search #Binary_Search_I_Day_5 #Top_Interview_150_Binary_Search
// #Big_O_Time_O(log_n)_Space_O(1) #2024_11_10_Time_0_ms_(100.00%)_Space_45.7_MB_(82.78%)

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = helper(nums, target, false);
        ans[1] = helper(nums, target, true);
        return ans;
    }

    private static int helper(int[] nums, int target, boolean equals) {
        int l = 0;
        int r = nums.length - 1;
        int result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                result = mid;
            }
            if (nums[mid] < target || (nums[mid] == target && equals)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Target appears multiple times (Standard Case)
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1 + 
                           " -> Range: " + Arrays.toString(searchRange(nums1, target1)) + " (Expected: [3, 4])");

        // Test Case 2: Target does not exist in the array
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2 + 
                           " -> Range: " + Arrays.toString(searchRange(nums2, target2)) + " (Expected: [-1, -1])");

        // Test Case 3: Empty Array Edge Case
        int[] nums3 = {};
        int target3 = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3 + 
                           " -> Range: " + Arrays.toString(searchRange(nums3, target3)) + " (Expected: [-1, -1])");

        // Test Case 4: Target spans across the entire array
        int[] nums4 = {2, 2, 2, 2, 2};
        int target4 = 2;
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4 + 
                           " -> Range: " + Arrays.toString(searchRange(nums4, target4)) + " (Expected: [0, 4])");

        // Test Case 5: Single element array - Target exists
        int[] nums5 = {1};
        int target5 = 1;
        System.out.println("Input: nums = " + Arrays.toString(nums5) + ", target = " + target5 + 
                           " -> Range: " + Arrays.toString(searchRange(nums5, target5)) + " (Expected: [0, 0])");
    }
}
