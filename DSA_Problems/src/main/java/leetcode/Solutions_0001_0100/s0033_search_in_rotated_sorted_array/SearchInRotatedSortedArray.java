package leetcode.Solutions_0001_0100.s0033_search_in_rotated_sorted_array;

import java.util.Arrays;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Binary_Search
// #Algorithm_II_Day_1_Binary_Search #Binary_Search_I_Day_11 #Level_2_Day_8_Binary_Search
// #Udemy_Binary_Search #Top_Interview_150_Binary_Search #Big_O_Time_O(log_n)_Space_O(1)
// #2024_11_10_Time_0_ms_(100.00%)_Space_42.2_MB_(21.10%)

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int mid;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            mid = ((hi - lo) >> 1) + lo;
            if (target == nums[mid]) {
                return mid;
            }
            // if this is true, then the possible rotation can only be in the second half
            if (nums[lo] <= nums[mid]) {
                // the target is in the first half only if it's
                if (nums[lo] <= target && target <= nums[mid]) {
                    // included
                    hi = mid - 1;
                } else {
                    // between nums[lo] and nums[mid]
                    lo = mid + 1;
                }
                // otherwise, the possible rotation can only be in the first half
            } else if (nums[mid] <= target && target <= nums[hi]) {
                // the target is in the second half only if it's included
                lo = mid + 1;
            } else {
                // between nums[hi] and nums[mid]
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
         // Test Case 1: Standard Rotated Array - Target Exists
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1 + 
                           " -> Index: " + search(nums1, target1) + " (Expected: 4)");

        // Test Case 2: Standard Rotated Array - Target Does Not Exist
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2 + 
                           " -> Index: " + search(nums2, target2) + " (Expected: -1)");

        // Test Case 3: Single Element Array - Target Exists
        int[] nums3 = {1};
        int target3 = 1;
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3 + 
                           " -> Index: " + search(nums3, target3) + " (Expected: 0)");

        // Test Case 4: Single Element Array - Target Does Not Exist
        int[] nums4 = {1};
        int target4 = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4 + 
                           " -> Index: " + search(nums4, target4) + " (Expected: -1)");

        // Test Case 5: Normal Sorted Array (No Rotation) - Target Exists
        int[] nums5 = {1, 3, 5, 7, 9};
        int target5 = 7;
        System.out.println("Input: nums = " + Arrays.toString(nums5) + ", target = " + target5 + 
                           " -> Index: " + search(nums5, target5) + " (Expected: 3)");

        // Test Case 6: Target is at the exact boundaries (Rotation Pivot Point)
        int[] nums6 = {5, 1, 3};
        int target6 = 5;
        System.out.println("Input: nums = " + Arrays.toString(nums6) + ", target = " + target6 + 
                           " -> Index: " + search(nums6, target6) + " (Expected: 0)");
    }
}
