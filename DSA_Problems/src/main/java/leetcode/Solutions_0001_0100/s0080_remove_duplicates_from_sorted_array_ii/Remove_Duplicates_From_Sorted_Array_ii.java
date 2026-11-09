package leetcode.Solutions_0001_0100.s0080_remove_duplicates_from_sorted_array_ii;

import java.util.Arrays;

// #Medium #Array #Two_Pointers #Udemy_Arrays #Top_Interview_150_Array/String
// #2025_03_05_Time_0_ms_(100.00%)_Space_46.59_MB_(39.01%)

public class Remove_Duplicates_From_Sorted_Array_ii {
    public int removeDuplicates(int[] nums) {
        // Fix: Short-circuit guard to prevent out-of-bounds crash on empty arrays
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int k = 0;
        int count = 0;
        while (i < nums.length - 1) {
            ++count;
            if (count <= 2) {
                nums[k++] = nums[i];
            }
            if (nums[i] != nums[i + 1]) {
                count = 0;
                i++;
                continue;
            }
            i++;
        }
        ++count;
        if (count <= 2) {
            nums[k++] = nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard sorted array with multiple duplicates exceeding 2
    int[] nums1 = {1, 1, 1, 2, 2, 3};
    int k1 = new Remove_Duplicates_From_Sorted_Array_ii().removeDuplicates(nums1);
    System.out.println("Test 1 - K: " + k1 + ", Array: " + Arrays.toString(Arrays.copyOf(nums1, k1)));
    // Expected Output: K: 5, Array: [1, 1, 2, 2, 3]

    // Test Case 2: Array with a longer sequence of identical elements
    int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
    int k2 = new Remove_Duplicates_From_Sorted_Array_ii().removeDuplicates(nums2);
    System.out.println("Test 2 - K: " + k2 + ", Array: " + Arrays.toString(Arrays.copyOf(nums2, k2)));
    // Expected Output: K: 7, Array: [0, 0, 1, 1, 2, 3, 3]

    // Test Case 3: Empty input array edge case
    int[] nums3 = {};
    int k3 = new Remove_Duplicates_From_Sorted_Array_ii().removeDuplicates(nums3);
    System.out.println("Test 3 - K: " + k3 + ", Array: " + Arrays.toString(Arrays.copyOf(nums3, k3)));
    // Expected Output: K: 0, Array: []

    // Test Case 4: Array containing elements that all appear exactly once
    int[] nums4 = {1, 2, 3};
    int k4 = new Remove_Duplicates_From_Sorted_Array_ii().removeDuplicates(nums4);
    System.out.println("Test 4 - K: " + k4 + ", Array: " + Arrays.toString(Arrays.copyOf(nums4, k4)));
    // Expected Output: K: 3, Array: [1, 2, 3]
}
}
