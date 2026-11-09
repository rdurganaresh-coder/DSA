package leetcode.Solutions_0001_0100.s0075_sort_colors;

import java.util.Arrays;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Sorting #Two_Pointers
// #Data_Structure_II_Day_2_Array #Udemy_Arrays #Big_O_Time_O(n)_Space_O(1)
// #2024_11_11_Time_0_ms_(100.00%)_Space_41.5_MB_(91.22%)

public class Sort_Colors {
    public void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[zeroes++] = 0;
            } else if (nums[i] == 1) {
                ones++;
            }
        }
        for (int j = zeroes; j < zeroes + ones; j++) {
            nums[j] = 1;
        }
        for (int k = zeroes + ones; k < nums.length; k++) {
            nums[k] = 2;
        }
    }

    public static void main(String[] args) {
    // Test Case 1: Standard mixed array with 0s, 1s, and 2s
    int[] nums1 = {2, 0, 2, 1, 1, 0};
    new Sort_Colors().sortColors(nums1);
    System.out.println("Test 1 Result: " + Arrays.toString(nums1));
    // Expected Output: [0, 0, 1, 1, 2, 2]

    // Test Case 2: Array with only two distinct elements
    int[] nums2 = {2, 0, 1};
    new Sort_Colors().sortColors(nums2);
    System.out.println("Test 2 Result: " + Arrays.toString(nums2));
    // Expected Output: [0, 1, 2]

    // Test Case 3: Array that is already fully sorted
    int[] nums3 = {0, 0, 1, 2, 2};
    new Sort_Colors().sortColors(nums3);
    System.out.println("Test 3 Result: " + Arrays.toString(nums3));
    // Expected Output: [0, 0, 1, 2, 2]

    // Test Case 4: Single element base case
    int[] nums4 = {0};
    new Sort_Colors().sortColors(nums4);
    System.out.println("Test 4 Result: " + Arrays.toString(nums4));
    // Expected Output: [0]
}
}
