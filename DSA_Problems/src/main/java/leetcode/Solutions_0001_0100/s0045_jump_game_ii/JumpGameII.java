package leetcode.Solutions_0001_0100.s0045_jump_game_ii;

import java.util.Arrays;

// #Medium #Top_100_Liked_Questions #Array #Dynamic_Programming #Greedy
// #Algorithm_II_Day_13_Dynamic_Programming #Dynamic_Programming_I_Day_4
// #Top_Interview_150_Array/String #Big_O_Time_O(n)_Space_O(1)
// #2024_11_10_Time_0_ms_(100.00%)_Space_45_MB_(64.44%)

public class JumpGameII {
    private int getMax(int[] nums, int l, int r) {
        int max = -1;
        int curr;
        for (int i = l; i <= r; i++) {
            curr = i + nums[i];
            max = Math.max(max, curr);
        }
        return max;
    }

    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int jumps = 0;
        while (r < nums.length - 1) {
            int prev = r;
            r = getMax(nums, l, r);
            l = prev + 1;
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII solver = new JumpGameII();

        // Test Case 1: Standard LeetCode Example 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Input: " + Arrays.toString(nums1) + 
                           " -> Min Jumps: " + solver.jump(nums1) + " (Expected: 2)");

        // Test Case 2: Standard LeetCode Example 2
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Input: " + Arrays.toString(nums2) + 
                           " -> Min Jumps: " + solver.jump(nums2) + " (Expected: 2)");

        // Test Case 3: Already at the end / Single element array
        int[] nums3 = {0};
        System.out.println("Input: " + Arrays.toString(nums3) + 
                           " -> Min Jumps: " + solver.jump(nums3) + " (Expected: 0)");

        // Test Case 4: Large jumps available immediately
        int[] nums4 = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        System.out.println("Input: " + Arrays.toString(nums4) + 
                           " -> Min Jumps: " + solver.jump(nums4) + " (Expected: 3)");

        // Test Case 5: Linear progressive jumps (1 step at a time)
        int[] nums5 = {1, 1, 1, 1};
        System.out.println("Input: " + Arrays.toString(nums5) + 
                           " -> Min Jumps: " + solver.jump(nums5) + " (Expected: 3)");
    }
}
