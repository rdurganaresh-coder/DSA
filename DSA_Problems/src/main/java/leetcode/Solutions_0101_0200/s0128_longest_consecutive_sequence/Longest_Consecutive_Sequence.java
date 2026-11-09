package leetcode.Solutions_0101_0200.s0128_longest_consecutive_sequence;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Hash_Table #Union_Find
// #Top_Interview_150_Hashmap #Big_O_Time_O(N_log_N)_Space_O(1)
// #2024_11_13_Time_14_ms_(98.89%)_Space_57.1_MB_(77.61%)

import java.util.Arrays;

@SuppressWarnings("java:S135")
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int thsMax = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                thsMax += 1;
                continue;
            }
            if (nums[i + 1] == nums[i]) {
                continue;
            }
            // Start of a new Sequene
            max = Math.max(max, thsMax);
            thsMax = 1;
        }
        return Math.max(max, thsMax);
    }

    public static void main(String[] args) {
    // Test Case 1: Standard unsorted array with scattered sequence elements
    // Consecutive sequence elements: [1, 2, 3, 4] -> Max Length: 4
    int[] nums1 = {100, 4, 200, 1, 3, 2};
    int result1 = new Longest_Consecutive_Sequence().longestConsecutive(nums1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 4

    // Test Case 2: Array containing duplicate consecutive values
    // Consecutive sequence elements: [0, 1, 2, 3, 4, 5, 6, 7, 8] -> Max Length: 9
    int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    int result2 = new Longest_Consecutive_Sequence().longestConsecutive(nums2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 9

    // Test Case 3: Empty input array edge case configuration
    int[] nums3 = {};
    int result3 = new Longest_Consecutive_Sequence().longestConsecutive(nums3);
    System.out.println("Test 3 Result (Empty): " + result3);
    // Expected Output: 0

    // Test Case 4: Single element array base configuration
    int[] nums4 = {9};
    int result4 = new Longest_Consecutive_Sequence().longestConsecutive(nums4);
    System.out.println("Test 4 Result (Single element): " + result4);
    // Expected Output: 1
}
}
