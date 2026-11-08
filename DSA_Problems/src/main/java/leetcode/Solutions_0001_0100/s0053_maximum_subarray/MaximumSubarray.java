package leetcode.Solutions_0001_0100.s0053_maximum_subarray;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Dynamic_Programming
// #Divide_and_Conquer #Data_Structure_I_Day_1_Array #Dynamic_Programming_I_Day_5
// #Udemy_Famous_Algorithm #Top_Interview_150_Kadane's_Algorithm #Big_O_Time_O(n)_Space_O(1)
// #2024_11_11_Time_1_ms_(99.32%)_Space_56.9_MB_(54.82%)

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            // calculating sub-array sum
            sum += num;
            maxi = Math.max(sum, maxi);
            if (sum < 0) {
                // there is no point to carry a -ve subarray sum. hence setting to 0
                sum = 0;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard mixed array (Should output 6 from [.4, -1, 2, 1])
    int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int result1 = new MaximumSubarray().maxSubArray(nums1);
    System.out.println("Test 1 Result: " + result1);

    // Test Case 2: Single element array (Should output 1)
    int[] nums2 = {1};
    int result2 = new MaximumSubarray().maxSubArray(nums2);
    System.out.println("Test 2 Result: " + result2);

    // Test Case 3: All positive numbers (Should output 23 by adding all elements)
    int[] nums3 = {5, 4, -1, 7, 8};
    int result3 = new MaximumSubarray().maxSubArray(nums3);
    System.out.println("Test 3 Result: " + result3);

    // Test Case 4: All negative numbers (Should output -1, the largest single element)
    int[] nums4 = {-5, -4, -1, -7, -8};
    int result4 = new MaximumSubarray().maxSubArray(nums4);
    System.out.println("Test 4 Result: " + result4);
 }
}
