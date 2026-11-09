package leetcode.Solutions_0101_0200.s0137_single_number_ii;

// #Medium #Array #Bit_Manipulation #Top_Interview_150_Bit_Manipulation
// #2025_03_06_Time_0_ms_(100.00%)_Space_45.39_MB_(79.09%)

public class Single_Number_ii {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & (~twos);
            twos = (twos ^ num) & (~ones);
        }
        return ones;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard small array layout with triplets
    // 2 appears three times, 3 appears once.
    int[] nums1 = {2, 2, 3, 2};
    int result1 = new Single_Number_ii().singleNumber(nums1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 3

    // Test Case 2: Longer scattered array layout
    // 0 appears three times, 1 appears three times, 99 appears once.
    int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
    int result2 = new Single_Number_ii().singleNumber(nums2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 99

    // Test Case 3: Single element base case configuration
    int[] nums3 = {7};
    int result3 = new Single_Number_ii().singleNumber(nums3);
    System.out.println("Test 3 Result (Single): " + result3);
    // Expected Output: 7

    // Test Case 4: Array containing negative numbers
    // -2 appears three times, -4 appears once.
    int[] nums4 = {-2, -2, 1, 1, -2, 1, -4};
    int result4 = new Single_Number_ii().singleNumber(nums4);
    System.out.println("Test 4 Result (Negatives): " + result4);
    // Expected Output: -4
}

}
