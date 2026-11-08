package leetcode.Solutions_0001_0100.s0042_trapping_rain_water;

import java.util.Arrays;

;

// #Hard #Top_100_Liked_Questions #Top_Interview_Questions #Array #Dynamic_Programming #Two_Pointers
// #Stack #Monotonic_Stack #Dynamic_Programming_I_Day_9 #Udemy_Two_Pointers
// #Top_Interview_150_Array/String #Big_O_Time_O(n)_Space_O(1)
// #2024_11_10_Time_0_ms_(100.00%)_Space_46.2_MB_(57.86%)

public class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        int lowerWall = 0;
        while (l < r) {
            int lVal = height[l];
            int rVal = height[r];
            // If left is smaller than right ptr, make the lower wall the bigger of lVal and its
            // current size
            if (lVal < rVal) {
                // If lVal has gone up, move the lowerWall upp
                lowerWall = Math.max(lVal, lowerWall);
                // Add the water level at current point
                // Calculate this by taking the current value and subtracting it from the lower wall
                // size
                // We know that this is the lower wall because we've already determined that lVal <
                // rVal
                res += lowerWall - lVal;
                // Move left ptr along
                l++;
            } else {
                // Do the same thing, except now we know that the lowerWall is the right side.
                lowerWall = Math.max(rVal, lowerWall);
                res += lowerWall - rVal;
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater solver = new TrappingRainWater();

        // Test Case 1: Standard LeetCode Example 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Input: " + Arrays.toString(height1) + 
                           " -> Trapped Water: " + solver.trap(height1) + " (Expected: 6)");

        // Test Case 2: Standard LeetCode Example 2 (Steep walls)
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Input: " + Arrays.toString(height2) + 
                           " -> Trapped Water: " + solver.trap(height2) + " (Expected: 9)");

        // Test Case 3: Empty / Flat Terrain
        int[] height3 = {0, 0, 0, 0};
        System.out.println("Input: " + Arrays.toString(height3) + 
                           " -> Trapped Water: " + solver.trap(height3) + " (Expected: 0)");

        // Test Case 4: No elevation drop to trap water (Descending structure)
        int[] height4 = {3, 2, 1, 0};
        System.out.println("Input: " + Arrays.toString(height4) + 
                           " -> Trapped Water: " + solver.trap(height4) + " (Expected: 0)");

        // Test Case 5: Single large pit in the middle
        int[] height5 = {3, 0, 3};
        System.out.println("Input: " + Arrays.toString(height5) + 
                           " -> Trapped Water: " + solver.trap(height5) + " (Expected: 3)");
    }
}
