package leetcode.Solutions_0101_0200.s0164_maximum_gap;

// #Medium #Array #Sorting #Bucket_Sort #Radix_Sort
// #2022_06_25_Time_48_ms_(53.59%)_Space_84.1_MB_(20.66%)

import java.util.Arrays;

public class Maximum_Gap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int ret = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i + 1] - nums[i]) > ret) {
                ret = (nums[i + 1] - nums[i]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Maximum_Gap solver = new Maximum_Gap();
        int passed = 0;
        int failed = 0;

        // 1. Array with less than 2 elements (Boundary Constraint)
        if (assertTest("Empty array", solver.maximumGap(new int[]{}) == 0)) passed++; else failed++;
        if (assertTest("Single element array", solver.maximumGap(new int[]{10}) == 0)) passed++; else failed++;

        // 2. Standard unsorted array case
        if (assertTest("Standard unsorted array", solver.maximumGap(new int[]{3, 6, 9, 1}) == 3)) passed++; else failed++;

        // 3. Array with all identical elements (Gap should be 0)
        if (assertTest("All identical elements", solver.maximumGap(new int[]{5, 5, 5, 5}) == 0)) passed++; else failed++;

        // 4. Two element array
        if (assertTest("Two elements", solver.maximumGap(new int[]{1, 10}) == 9)) passed++; else failed++;

        // 5. Sorted sequence where max gap is at the beginning
        if (assertTest("Gap at the start", solver.maximumGap(new int[]{1, 10, 11, 12}) == 9)) passed++; else failed++;

        // 6. Sorted sequence where max gap is at the end
        if (assertTest("Gap at the end", solver.maximumGap(new int[]{1, 2, 3, 12}) == 9)) passed++; else failed++;

        // Summary
        System.out.println("\n-----------------------------------");
        System.out.println("Test Results: " + passed + " Passed, " + failed + " Failed.");
        System.out.println("-----------------------------------");
    }

    private static boolean assertTest(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
            return true;
        } else {
            System.err.println("[FAIL] " + testName);
            return false;
        }
    }
}
