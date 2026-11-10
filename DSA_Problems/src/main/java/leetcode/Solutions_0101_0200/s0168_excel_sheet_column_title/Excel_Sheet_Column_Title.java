package leetcode.Solutions_0101_0200.s0168_excel_sheet_column_title;

// #Easy #String #Math #2022_06_25_Time_0_ms_(100.00%)_Space_41.3_MB_(58.37%)

public class Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remainder = n % 26;
            if (remainder == 0) {
                remainder += 26;
            }
            if (n >= remainder) {
                n -= remainder;
                sb.append((char) (remainder + 64));
            }
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Excel_Sheet_Column_Title solver = new Excel_Sheet_Column_Title();
        int passed = 0;
        int failed = 0;

        // 1. Single Letter Boundaries
        if (assertTest("First column (A)", solver.convertToTitle(1).equals("A"))) passed++; else failed++;
        if (assertTest("Last single-letter column (Z)", solver.convertToTitle(26).equals("Z"))) passed++; else failed++;

        // 2. Multi-letter Transitions
        if (assertTest("Transition to AA", solver.convertToTitle(27).equals("AA"))) passed++; else failed++;
        if (assertTest("Transition to AB", solver.convertToTitle(28).equals("AB"))) passed++; else failed++;
        if (assertTest("Exact Z boundary (AZ)", solver.convertToTitle(52).equals("AZ"))) passed++; else failed++;

        // 3. Multi-letter Combinations (Standard Cases)
        if (assertTest("Standard case (ZY)", solver.convertToTitle(701).equals("ZY"))) passed++; else failed++;
        if (assertTest("Three-letter transition (AAA)", solver.convertToTitle(703).equals("AAA"))) passed++; else failed++;
        if (assertTest("Standard deep case (FXSHRXW)", solver.convertToTitle(2147483647).equals("FXSHRXW"))) passed++; else failed++;

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
