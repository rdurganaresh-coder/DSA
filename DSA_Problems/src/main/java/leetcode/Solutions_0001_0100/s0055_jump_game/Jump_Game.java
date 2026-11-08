package leetcode.Solutions_0001_0100.s0055_jump_game;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Dynamic_Programming #Greedy
// #Algorithm_II_Day_12_Dynamic_Programming #Dynamic_Programming_I_Day_4 #Udemy_Arrays
// #Top_Interview_150_Array/String #Big_O_Time_O(n)_Space_O(1)
// #2024_11_11_Time_1_ms_(100.00%)_Space_45.6_MB_(44.48%)

public class Jump_Game {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int fin = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if ((nums[i] + i) >= fin) {
                fin = i;
            }
        }
        return fin == 0;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard reachable array (Should output true)
    int[] nums1 = {2, 3, 1, 1, 4};
    boolean result1 = new Jump_Game().canJump(nums1);
    System.out.println("Test 1 Result: " + result1);

    // Test Case 2: Trap array with a 0 block (Should output false)
    int[] nums2 = {3, 2, 1, 0, 4};
    boolean result2 = new Jump_Game().canJump(nums2);
    System.out.println("Test 2 Result: " + result2);

    // Test Case 3: Single element array edge case (Should output true)
    int[] nums3 = {0};
    boolean result3 = new Jump_Game().canJump(nums3);
    System.out.println("Test 3 Result: " + result3);

    // Test Case 4: Array starting with 0 but multiple elements (Should output false)
    int[] nums4 = {0, 2, 3};
    boolean result4 = new Jump_Game().canJump(nums4);
    System.out.println("Test 4 Result: " + result4);
}
}
