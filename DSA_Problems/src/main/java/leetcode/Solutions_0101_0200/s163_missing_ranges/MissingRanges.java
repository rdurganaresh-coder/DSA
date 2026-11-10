package leetcode.Solutions_0101_0200.s163_missing_ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long prev = (long)lower - 1;
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            long curr = (i < n) ? nums[i] : (long)upper + 1;
            if (curr - prev == 2) {
                result.add(String.valueOf(prev + 1));
            } else if (curr - prev > 2) {
                result.add((prev + 1) + "->" + (curr - 1));
            }
            prev = curr;
        }
        return result;
    }

    public static void main(String[] args) {
        MissingRanges solver = new MissingRanges();
        int passed = 0;
        int failed = 0;

        // 1. Standard Case with Mixed Formats (Single values and range arrows)
        if (assertTest("Standard case", 
                solver.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99),
                Arrays.asList("2", "4->49", "51->74", "76->99"))) passed++; else failed++;

        // 2. Empty Array (Entire lower-upper range is missing)
        if (assertTest("Empty array", 
                solver.findMissingRanges(new int[]{}, 1, 1),
                Arrays.asList("1"))) passed++; else failed++;
        
        if (assertTest("Empty array large range", 
                solver.findMissingRanges(new int[]{}, -3, -1),
                Arrays.asList("-3->-1"))) passed++; else failed++;

        // 3. Complete Array (No missing ranges)
        if (assertTest("No missing ranges", 
                solver.findMissingRanges(new int[]{1, 2, 3}, 1, 3),
                Arrays.asList())) passed++; else failed++;

        // 4. Boundary Overflows (Verifies your long casting logic for Integer.MIN_VALUE / MAX_VALUE)
        if (assertTest("Integer MAX boundary", 
                solver.findMissingRanges(new int[]{2147483647}, 2147483646, 2147483647),
                Arrays.asList("2147483646"))) passed++; else failed++;

        if (assertTest("Integer MIN boundary", 
                solver.findMissingRanges(new int[]{-2147483648}, -2147483648, -2147483646),
                Arrays.asList("-2147483647->-2147483646"))) passed++; else failed++;

        // 5. Lower / Upper Out of Array Bounds
        if (assertTest("Lower and upper beyond array bounds", 
                solver.findMissingRanges(new int[]{3, 5}, 1, 7),
                Arrays.asList("1->2", "4", "6->7"))) passed++; else failed++;

        // Summary
        System.out.println("\n-----------------------------------");
        System.out.println("Test Results: " + passed + " Passed, " + failed + " Failed.");
        System.out.println("-----------------------------------");
    }

    private static boolean assertTest(String testName, List<String> actual, List<String> expected) {
        if (actual.equals(expected)) {
            System.out.println("[PASS] " + testName);
            return true;
        } else {
            System.err.println("[FAIL] " + testName);
            System.err.println("       Expected: " + expected);
            System.err.println("       Actual:   " + actual);
            return false;
        }
    }

}
