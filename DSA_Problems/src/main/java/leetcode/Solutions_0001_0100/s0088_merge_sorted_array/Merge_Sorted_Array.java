package leetcode.Solutions_0001_0100.s0088_merge_sorted_array;

import java.util.Arrays;

// #Easy #Top_Interview_Questions #Array #Sorting #Two_Pointers #Data_Structure_I_Day_2_Array
// #Top_Interview_150_Array/String #2025_03_05_Time_0_ms_(100.00%)_Space_42.40_MB_(26.50%)

public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = nums1.length - 1;
        int p2 = n - 1;
        while (p2 >= 0) {
            if (i >= 0 && nums1[i] > nums2[p2]) {
                nums1[j--] = nums1[i--];
            } else {
                nums1[j--] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
    // Test Case 1: Standard mixed merge with room at the end of nums1
    int[] nums1_1 = {1, 2, 3, 0, 0, 0};
    int m1 = 3;
    int[] nums1_2 = {2, 5, 6};
    int n1 = 3;
    new Merge_Sorted_Array().merge(nums1_1, m1, nums1_2, n1);
    System.out.println("Test 1 Result: " + Arrays.toString(nums1_1));
    // Expected Output: [1, 2, 2, 3, 5, 6]

    // Test Case 2: nums2 contains elements all smaller than nums1 elements
    int[] nums2_1 = {4, 5, 6, 0, 0, 0};
    int m2 = 3;
    int[] nums2_2 = {1, 2, 3};
    int n2 = 3;
    new Merge_Sorted_Array().merge(nums2_1, m2, nums2_2, n2);
    System.out.println("Test 2 Result: " + Arrays.toString(nums2_1));
    // Expected Output: [1, 2, 3, 4, 5, 6]

    // Test Case 3: nums1 is effectively empty (m = 0)
    int[] nums3_1 = {0};
    int m3 = 0;
    int[] nums3_2 = {1};
    int n3 = 1;
    new Merge_Sorted_Array().merge(nums3_1, m3, nums3_2, n3);
    System.out.println("Test 3 Result: " + Arrays.toString(nums3_1));
    // Expected Output: [1]

    // Test Case 4: nums2 is completely empty (n = 0)
    int[] nums4_1 = {1};
    int m4 = 1;
    int[] nums4_2 = {};
    int n4 = 0;
    new Merge_Sorted_Array().merge(nums4_1, m4, nums4_2, n4);
    System.out.println("Test 4 Result: " + Arrays.toString(nums4_1));
    // Expected Output: [1]
}
}
