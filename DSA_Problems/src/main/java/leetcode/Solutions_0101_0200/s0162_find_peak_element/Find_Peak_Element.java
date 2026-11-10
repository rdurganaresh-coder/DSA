package leetcode.Solutions_0101_0200.s0162_find_peak_element;

// #Medium #Top_Interview_Questions #Array #Binary_Search #LeetCode_75_Binary_Search
// #Algorithm_II_Day_2_Binary_Search #Binary_Search_II_Day_12 #Top_Interview_150_Binary_Search
// #2025_03_06_Time_0_ms_(100.00%)_Space_42.78_MB_(21.39%)

public class Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            // This is done because start and end might be big numbers, so it might exceed the
            // integer limit.
            int mid = start + ((end - start) / 2);
            if (nums[mid + 1] > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Find_Peak_Element solver = new Find_Peak_Element();
        int passed = 0;
        int failed = 0;

        // 1. Single Element Array (Peak is at index 0)
        if (assertTest("Single element array", solver.findPeakElement(new int[]{1}) == 0)) passed++; else failed++;

        // 2. Strictly Increasing Array (Peak is at the last index)
        if (assertTest("Strictly increasing", solver.findPeakElement(new int[]{1, 2, 3, 4, 5}) == 4)) passed++; else failed++;

        // 3. Strictly Decreasing Array (Peak is at the first index)
        if (assertTest("Strictly decreasing", solver.findPeakElement(new int[]{5, 4, 3, 2, 1}) == 0)) passed++; else failed++;

        // 4. Standard Peak in the Middle
        if (assertTest("Peak in the middle", solver.findPeakElement(new int[]{1, 2, 3, 1}) == 2)) passed++; else failed++;

        // 5. Multiple Peaks (Any valid peak index is correct: index 1 or index 5)
        int multiplePeaksResult = solver.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        if (assertTest("Multiple peaks option", multiplePeaksResult == 1 || multiplePeaksResult == 5)) passed++; else failed++;

        // 6. Two Elements Array - Peak at Start
        if (assertTest("Two elements - peak at start", solver.findPeakElement(new int[]{2, 1}) == 0)) passed++; else failed++;

        // 7. Two Elements Array - Peak at End
        if (assertTest("Two elements - peak at end", solver.findPeakElement(new int[]{1, 2}) == 1)) passed++; else failed++;

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
