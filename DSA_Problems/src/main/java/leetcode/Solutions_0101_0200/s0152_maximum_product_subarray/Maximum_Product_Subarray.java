package leetcode.Solutions_0101_0200.s0152_maximum_product_subarray;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Dynamic_Programming
// #Dynamic_Programming_I_Day_6 #Level_2_Day_13_Dynamic_Programming #Udemy_Dynamic_Programming
// #Big_O_Time_O(N)_Space_O(1) #2024_11_15_Time_1_ms_(92.74%)_Space_45_MB_(23.41%)

public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int overAllMaxProd = Integer.MIN_VALUE;
        int n = nums.length;
        int start = 1;
        int end = 1;
        for (int i = 0; i < n; i++) {
            if (start == 0) {
                start = 1;
            }
            if (end == 0) {
                end = 1;
            }
            start = start * nums[i];
            end = end * nums[n - i - 1];
            overAllMaxProd = Math.max(overAllMaxProd, Math.max(start, end));
        }
        return overAllMaxProd;
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Maximum_Product_Subarray solver = new Maximum_Product_Subarray();

        System.out.println("--- Running Maximum Product Subarray Tests ---\n");

        // Test Case 1: Standard case with a mix of positive and negative numbers
        // Input: [2, 3, -2, 4] -> Subarray [2, 3] gives max product 6
        System.out.print("Test 1 (Standard Mixed): ");
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Expected: 6 -> Actual: " + solver.maxProduct(nums1));

        // Test Case 2: Array containing a zero
        // Input: [-2, 0, -1] -> Subarray [0] gives max product 0
        System.out.print("Test 2 (Contains Zero): ");
        int[] nums2 = {-2, 0, -1};
        System.out.println("Expected: 0 -> Actual: " + solver.maxProduct(nums2));

        // Test Case 3: Even number of negative numbers (cancels out)
        // Input: [-2, 3, -4] -> Subarray [-2, 3, -4] gives max product 24
        System.out.print("Test 3 (Even Negatives): ");
        int[] nums3 = {-2, 3, -4};
        System.out.println("Expected: 24 -> Actual: " + solver.maxProduct(nums3));

        // Test Case 4: Single negative number
        // Input: [-3] -> Max product is -3
        System.out.print("Test 4 (Single Element): ");
        int[] nums4 = {-3};
        System.out.println("Expected: -3 -> Actual: " + solver.maxProduct(nums4));

        // Test Case 5: All negative numbers (Odd count)
        // Input: [-2, -3, -4] -> Subarray [-3, -4] or [-2, -3] gives max product 12
        System.out.print("Test 5 (Odd Negatives):  ");
        int[] nums5 = {-2, -3, -4};
        System.out.println("Expected: 12 -> Actual: " + solver.maxProduct(nums5));
    }
}
