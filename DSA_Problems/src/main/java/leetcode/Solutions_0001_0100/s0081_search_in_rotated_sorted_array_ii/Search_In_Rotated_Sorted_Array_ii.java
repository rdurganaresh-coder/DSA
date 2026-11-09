package leetcode.Solutions_0001_0100.s0081_search_in_rotated_sorted_array_ii;

// #Medium #Array #Binary_Search #Binary_Search_II_Day_12
// #2022_06_20_Time_1_ms_(82.83%)_Space_43.7_MB_(51.03%)

public class Search_In_Rotated_Sorted_Array_ii {
    public boolean search(int[] nums, int target) {
        return binary(nums, 0, nums.length - 1, target);
    }

    private boolean binary(int[] a, int i, int j, int t) {
        if (i > j) {
            return false;
        }
        int mid = (i + j) / 2;
        if (a[mid] == t) {
            return true;
        }
        boolean c1 = binary(a, i, mid - 1, t);
        boolean c2 = binary(a, mid + 1, j, t);
        return c1 || c2;
    }

    public static void main(String[] args) {
    // Test Case 1: Target exists in an array with duplicates (Should output true)
    int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
    boolean result1 = new Search_In_Rotated_Sorted_Array_ii().search(nums1, 0);
    System.out.println("Test 1 (Target 0): " + result1);

    // Test Case 2: Target does not exist in the array (Should output false)
    int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
    boolean result2 = new Search_In_Rotated_Sorted_Array_ii().search(nums2, 3);
    System.out.println("Test 2 (Target 3): " + result2);

    // Test Case 3: Tricky case where edges match the middle element (Should output true)
    int[] nums3 = {1, 0, 1, 1, 1};
    boolean result3 = new Search_In_Rotated_Sorted_Array_ii().search(nums3, 0);
    System.out.println("Test 3 (Target 0): " + result3);

    // Test Case 4: Empty input array edge case (Should output false)
    int[] nums4 = {};
    boolean result4 = new Search_In_Rotated_Sorted_Array_ii().search(nums4, 5);
    System.out.println("Test 4 (Target 5): " + result4);
}
}
