package leetcode.Solutions_0001_0100.s0041_first_missing_positive;

import java.util.Arrays;

// #Hard #Top_100_Liked_Questions #Top_Interview_Questions #Array #Hash_Table #Udemy_Arrays
// #Big_O_Time_O(n)_Space_O(n) #2024_11_10_Time_1_ms_(100.00%)_Space_57.5_MB_(31.18%)

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive solver = new FirstMissingPositive();

        // Test Case 1: Standard LeetCode Example 1
        int[] nums1 = {1, 2, 0};
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Output: " + solver.firstMissingPositive(nums1) + " (Expected: 3)");

        // Test Case 2: Standard LeetCode Example 2 (Unsorted with negatives)
        int[] nums2 = {3, 4, -1, 1};
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Output: " + solver.firstMissingPositive(nums2) + " (Expected: 2)");

        // Test Case 3: Standard LeetCode Example 3 (Sequential elements)
        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("Input: " + Arrays.toString(nums3) + " -> Output: " + solver.firstMissingPositive(nums3) + " (Expected: 1)");

        // Test Case 4: Continuous series from 1 to N
        int[] nums4 = {1, 2, 3, 4};
        System.out.println("Input: " + Arrays.toString(nums4) + " -> Output: " + solver.firstMissingPositive(nums4) + " (Expected: 5)");

        // Test Case 5: Single element duplicate / edge case
        int[] nums5 = {1, 1};
        System.out.println("Input: " + Arrays.toString(nums5) + " -> Output: " + solver.firstMissingPositive(nums5) + " (Expected: 2)");
    }
}
