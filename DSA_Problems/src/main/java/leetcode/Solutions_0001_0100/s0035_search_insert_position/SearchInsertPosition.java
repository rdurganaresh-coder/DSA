package leetcode.Solutions_0001_0100.s0035_search_insert_position;

import java.util.Arrays;

// #Easy #Top_100_Liked_Questions #Array #Binary_Search #Algorithm_I_Day_1_Binary_Search
// #Binary_Search_I_Day_2 #Top_Interview_150_Binary_Search #Big_O_Time_O(log_n)_Space_O(1)
// #2024_11_10_Time_0_ms_(100.00%)_Space_43_MB_(40.42%)

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        // Test Case 1: Target is found exactly in the middle of the array
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1 + 
                           " -> Index: " + searchInsert(nums1, target1) + " (Expected: 2)");

        // Test Case 2: Target is missing and belongs in the middle
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2 + 
                           " -> Index: " + searchInsert(nums2, target2) + " (Expected: 1)");

        // Test Case 3: Target is missing and belongs at the absolute end
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3 + 
                           " -> Index: " + searchInsert(nums3, target3) + " (Expected: 4)");

        // Test Case 4: Target is missing and belongs at the absolute beginning
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4 + 
                           " -> Index: " + searchInsert(nums4, target4) + " (Expected: 0)");

        // Test Case 5: Single element array - Target matches element
        int[] nums5 = {1};
        int target5 = 1;
        System.out.println("Input: nums = " + Arrays.toString(nums5) + ", target = " + target5 + 
                           " -> Index: " + searchInsert(nums5, target5) + " (Expected: 0)");
    }
}
