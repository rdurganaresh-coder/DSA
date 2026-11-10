package leetcode.Solutions_0101_0200.s170_two_sum_III;


import java.util.*;
public class TwoSumIII {

    private Map<Integer, Integer> counts;

    public TwoSumIII() {
        counts = new HashMap<>();
    }

    public void add(int number) {
        counts.put(number, counts.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (int num : counts.keySet()) {
            int complement = value - num;
            if (complement == num) {
                if (counts.get(num) > 1) return true;
            } else {
                if (counts.containsKey(complement)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int passed = 0;
        int failed = 0;

        // 1. Standard Case (Elements added sequentially)
        TwoSumIII suite1 = new TwoSumIII();
        suite1.add(1);
        suite1.add(3);
        suite1.add(5);
        if (assertTest("Standard find true (4)", suite1.find(4))) passed++; else failed++;
        if (assertTest("Standard find false (7)", !suite1.find(7))) passed++; else failed++;

        // 2. Duplicate Elements Case (Testing frequency map fallback logic)
        TwoSumIII suite2 = new TwoSumIII();
        suite2.add(3);
        suite2.add(1);
        suite2.add(3);
        if (assertTest("Duplicate complement true (6)", suite2.find(6))) passed++; else failed++;
        if (assertTest("Single distinct complement false (2)", !suite2.find(2))) passed++; else failed++;

        // 3. Negative Numbers and Zero Boundaries
        TwoSumIII suite3 = new TwoSumIII();
        suite3.add(-1);
        suite3.add(0);
        suite3.add(1);
        if (assertTest("Negative sum true (-1)", suite3.find(-1))) passed++; else failed++;
        if (assertTest("Zero sum true (0)", suite3.find(0))) passed++; else failed++;
        if (assertTest("Missing negative target false (-5)", !suite3.find(-5))) passed++; else failed++;

        // 4. Empty Structure State
        TwoSumIII suite4 = new TwoSumIII();
        if (assertTest("Empty structure find false (0)", !suite4.find(0))) passed++; else failed++;

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
