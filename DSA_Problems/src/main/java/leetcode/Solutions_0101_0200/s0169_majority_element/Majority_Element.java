package leetcode.Solutions_0101_0200.s0169_majority_element;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Array #Hash_Table #Sorting #Counting
// #Divide_and_Conquer #Data_Structure_II_Day_1_Array #Udemy_Famous_Algorithm
// #Top_Interview_150_Array/String #Big_O_Time_O(n)_Space_O(1)
// #2024_11_15_Time_1_ms_(99.89%)_Space_52.8_MB_(64.33%)

public class Majority_Element {
    public int majorityElement(int[] arr) {
        int count = 1;
        int majority = arr[0];
        // For Potential Majority Element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == majority) {
                count++;
            } else {
                if (count > 1) {
                    count--;
                } else {
                    majority = arr[i];
                }
            }
        }
        // For Confirmation
        count = 0;
        for (int j : arr) {
            if (j == majority) {
                count++;
            }
        }
        if (count >= (arr.length / 2) + 1) {
            return majority;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Majority_Element solver = new Majority_Element();
        int passed = 0;
        int failed = 0;

        // 1. Single Element Array (Always the majority)
        if (assertTest("Single element array", solver.majorityElement(new int[]{5}) == 5)) passed++; else failed++;

        // 2. Standard Odd Length Majority
        if (assertTest("Odd length array majority", solver.majorityElement(new int[]{3, 2, 3}) == 3)) passed++; else failed++;

        // 3. Standard Even Length Majority
        if (assertTest("Even length array majority", solver.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}) == 2)) passed++; else failed++;

        // 4. No Majority Element Present (All unique or distributed)
        if (assertTest("No majority present", solver.majorityElement(new int[]{1, 2, 3, 4}) == -1)) passed++; else failed++;

        // 5. Perfect Split / Tie (Requires strictly greater than n/2, so should return -1)
        if (assertTest("Perfect split tie", solver.majorityElement(new int[]{1, 1, 2, 2}) == -1)) passed++; else failed++;

        // 6. All Elements Identical
        if (assertTest("All elements identical", solver.majorityElement(new int[]{7, 7, 7, 7, 7}) == 7)) passed++; else failed++;

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
