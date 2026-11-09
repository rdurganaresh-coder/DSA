package leetcode.Solutions_0101_0200.s0154_find_minimum_in_rotated_sorted_array_ii;

// #Hard #Array #Binary_Search #Binary_Search_II_Day_13
// #2022_06_25_Time_1_ms_(77.09%)_Space_44.6_MB_(7.09%)

public class Find_Minimum_In_Rotated_Sorted_Array_ii {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return find(0, nums.length - 1, nums);
    }

    private int find(int left, int right, int[] nums) {
        if (left + 1 >= right) {
            return Math.min(nums[left], nums[right]);
        }
        int mid = left + (right - left) / 2;
        if (nums[left] == nums[right] && nums[left] == nums[mid]) {
            return Math.min(find(left, mid, nums), find(mid, right, nums));
        }
        if (nums[left] >= nums[right]) {
            if (nums[mid] >= nums[left]) {
                return find(mid, right, nums);
            } else {
                return find(left, mid, nums);
            }
        } else {
            return find(left, mid, nums);
        }
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Find_Minimum_In_Rotated_Sorted_Array_ii solver = new Find_Minimum_In_Rotated_Sorted_Array_ii();

        System.out.println("--- Running Find Minimum In Rotated Sorted Array II Tests ---\n");

        // Test Case 1: Standard Rotated Array with Duplicates
        // Input: -> Minimum is 0
        System.out.print("Test 1 (Basic Duplicates): ");
        int[] nums1 = {1, 3, 5};
        System.out.println("Expected: 1 -> Actual: " + solver.findMin(nums1));

        // Test Case 2: Multi-Duplicate Inflection Point
        // Input: -> Minimum is 0
        System.out.print("Test 2 (Inflection Duplicates): ");
        int[] nums2 = {2, 2, 2, 0, 1};
        System.out.println("Expected: 0 -> Actual: " + solver.findMin(nums2));

        // Test Case 3: Tricky Equal Boundaries (Worst Case Branch)
        // Input: -> Minimum is 1
        System.out.print("Test 3 (Equal Boundaries):    ");
        int[] nums3 = {1, 3, 1, 1, 1};
        System.out.println("Expected: 1 -> Actual: " + solver.findMin(nums3));

        // Test Case 4: Another Equal Boundary Variant
        // Input: -> Minimum is 1
        System.out.print("Test 4 (Shifted Boundary):    ");
        int[] nums4 = {1, 1, 1, 3, 1};
        System.out.println("Expected: 1 -> Actual: " + solver.findMin(nums4));

        // Test Case 5: Single Element
        System.out.print("Test 5 (Single Element):      ");
        int[] nums5 = {42};
        System.out.println("Expected: 42 -> Actual: " + solver.findMin(nums5));
    }
}
