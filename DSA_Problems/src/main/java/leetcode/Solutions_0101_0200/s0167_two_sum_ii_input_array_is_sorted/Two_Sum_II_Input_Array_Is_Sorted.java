package leetcode.Solutions_0101_0200.s0167_two_sum_ii_input_array_is_sorted;

import java.util.Arrays;

// #Medium #Array #Binary_Search #Two_Pointers #Algorithm_I_Day_3_Two_Pointers
// #Binary_Search_I_Day_7 #Top_Interview_150_Two_Pointers
// #2025_03_09_Time_2_ms_(92.62%)_Space_47.15_MB_(64.95%)

public class Two_Sum_II_Input_Array_Is_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Two_Sum_II_Input_Array_Is_Sorted solver = new Two_Sum_II_Input_Array_Is_Sorted();
        int passed = 0;
        int failed = 0;

        // 1. Standard Case (Elements at the ends / middle)
        if (assertTest("Standard case", 
                solver.twoSum(new int[]{2, 7, 11, 15}, 9), 
                new int[]{1, 2})) passed++; else failed++;

        // 2. Minimum length array (exactly 2 elements)
        if (assertTest("Two elements array", 
                solver.twoSum(new int[]{2, 3, 4}, 6), 
                new int[]{1, 3})) passed++; else failed++;

        // 3. Negative numbers included
        if (assertTest("Negative numbers", 
                solver.twoSum(new int[]{-1, 0}, -1), 
                new int[]{1, 2})) passed++; else failed++;

        // 4. Duplicate numbers that add up to target
        if (assertTest("Duplicate numbers", 
                solver.twoSum(new int[]{5, 25, 75, 75}, 150), 
                new int[]{3, 4})) passed++; else failed++;

        // 5. Large targets using max array boundaries
        if (assertTest("Boundaries convergence", 
                solver.twoSum(new int[]{1, 2, 3, 4, 10, 20, 30}, 40), 
                new int[]{5, 7})) passed++; else failed++;

        // Summary
        System.out.println("\n-----------------------------------");
        System.out.println("Test Results: " + passed + " Passed, " + failed + " Failed.");
        System.out.println("-----------------------------------");
    }

    private static boolean assertTest(String testName, int[] actual, int[] expected) {
        if (Arrays.equals(actual, expected)) {
            System.out.println("[PASS] " + testName);
            return true;
        } else {
            System.err.println("[FAIL] " + testName);
            System.err.println("       Expected: " + Arrays.toString(expected));
            System.err.println("       Actual:   " + Arrays.toString(actual));
            return false;
        }
    }
}
