package leetcode.Solutions_0101_0200.s0136_single_number;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Array #Bit_Manipulation
// #LeetCode_75_Bit_Manipulation #Data_Structure_II_Day_1_Array
// #Algorithm_I_Day_14_Bit_Manipulation #Udemy_Integers #Top_Interview_150_Bit_Manipulation
// #Big_O_Time_O(N)_Space_O(1) #2024_11_13_Time_1_ms_(99.86%)_Space_46_MB_(49.33%)

public class Single_Number {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
    // Test Case 1: Small standard array configuration
    // 2 ^ 2 ^ 1 = 0 ^ 1 = 1
    int[] nums1 = {2, 2, 1};
    int result1 = new Single_Number().singleNumber(nums1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 1

    // Test Case 2: Longer scattered array layout
    // 4 ^ 1 ^ 2 ^ 1 ^ 2 = 4 ^ (1 ^ 1) ^ (2 ^ 2) = 4 ^ 0 ^ 0 = 4
    int[] nums2 = {4, 1, 2, 1, 2};
    int result2 = new Single_Number().singleNumber(nums2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 4

    // Test Case 3: Single element base case configuration
    int[] nums3 = {7};
    int result3 = new Single_Number().singleNumber(nums3);
    System.out.println("Test 3 Result (Single): " + result3);
    // Expected Output: 7
}

}
