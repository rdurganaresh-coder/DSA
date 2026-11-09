package leetcode.Solutions_0101_0200.s0153_find_minimum_in_rotated_sorted_array;

// #Medium #Top_100_Liked_Questions #Array #Binary_Search #Algorithm_II_Day_2_Binary_Search
// #Binary_Search_I_Day_12 #Udemy_Binary_Search #Top_Interview_150_Binary_Search
// #Big_O_Time_O(log_N)_Space_O(log_N) #2024_11_15_Time_0_ms_(100.00%)_Space_42.1_MB_(33.31%)

public class Find_Minimum_In_Rotated_Sorted_Array {
    private int findMinUtil(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = (l + r) / 2;
        if (mid == l && nums[mid] < nums[r]) {
            return nums[l];
        }
        if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
            return nums[mid];
        }
        if (nums[mid] < nums[l]) {
            return findMinUtil(nums, l, mid - 1);
        } else if (nums[mid] > nums[r]) {
            return findMinUtil(nums, mid + 1, r);
        }
        return findMinUtil(nums, l, mid - 1);
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        return findMinUtil(nums, l, r);
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Find_Minimum_In_Rotated_Sorted_Array solver = new Find_Minimum_In_Rotated_Sorted_Array();

        System.out.println("--- Running Find Minimum In Rotated Sorted Array Tests ---\n");

        // Test Case 1: Standard Rotated Array
        // Input: [3, 4, 5, 1, 2] -> The minimum is 1
        System.out.print("Test 1 (Standard Rotation): ");
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Expected: 1 -> Actual: " + solver.findMin(nums1));

        // Test Case 2: Multi-Rotated Array
        // Input: [4, 5, 6, 7, 0, 1, 2] -> The minimum is 0
        System.out.print("Test 2 (Deep Rotation):     ");
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Expected: 0 -> Actual: " + solver.findMin(nums2));

        // Test Case 3: Completely Sorted / Not Rotated (0 rotations)
        // Input: [11, 13, 15, 17] -> The minimum is 11
        System.out.print("Test 3 (No Rotation):       ");
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Expected: 11 -> Actual: " + solver.findMin(nums3));

        // Test Case 4: Single Element Array
        // Input: [42] -> The minimum is 42
        System.out.print("Test 4 (Single Element):    ");
        int[] nums4 = {42};
        System.out.println("Expected: 42 -> Actual: " + solver.findMin(nums4));

        // Test Case 5: Two Elements Rotated
        // Input: [2, 1] -> The minimum is 1
        System.out.print("Test 5 (Two Elements):      ");
        int[] nums5 = {2, 1};
        System.out.println("Expected: 1 -> Actual: " + solver.findMin(nums5));
    }
}
