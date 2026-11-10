package leetcode.Solutions_0101_0200.s161_one_edit_distance;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) return isOneEditDistance(t, s);
        if (n - m > 1) return false;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n)
                    return s.substring(i+1).equals(t.substring(i+1));
                else
                    return s.substring(i).equals(t.substring(i+1));
            }
        }
        return n - m == 1;
    }

    public static void main(String[] args) {
        OneEditDistance solver = new OneEditDistance();
        int passed = 0;
        int failed = 0;

        // 1. Identical Strings (Distance = 0, should be false)
        if (assertTest("Identical strings", !solver.isOneEditDistance("abc", "abc"))) passed++; else failed++;
        if (assertTest("Empty strings", !solver.isOneEditDistance("", ""))) passed++; else failed++;

        // 2. One Replace Distance (should be true)
        if (assertTest("Replace middle", solver.isOneEditDistance("abc", "adc"))) passed++; else failed++;
        if (assertTest("Replace end", solver.isOneEditDistance("abc", "abz"))) passed++; else failed++;
        if (assertTest("Replace start", solver.isOneEditDistance("abc", "xbc"))) passed++; else failed++;

        // 3. One Insert Distance (should be true)
        if (assertTest("Insert middle", solver.isOneEditDistance("abc", "abdc"))) passed++; else failed++;
        if (assertTest("Insert start", solver.isOneEditDistance("abc", "zabc"))) passed++; else failed++;
        if (assertTest("Insert end", solver.isOneEditDistance("abc", "abcd"))) passed++; else failed++;

        // 4. One Delete Distance (should be true)
        if (assertTest("Delete middle", solver.isOneEditDistance("abdc", "abc"))) passed++; else failed++;
        if (assertTest("Delete start", solver.isOneEditDistance("zabc", "abc"))) passed++; else failed++;
        if (assertTest("Delete end", solver.isOneEditDistance("abcd", "abc"))) passed++; else failed++;

        // 5. Empty String Transitions
        if (assertTest("Empty vs length 1", solver.isOneEditDistance("", "a"))) passed++; else failed++;
        if (assertTest("Length 1 vs empty", solver.isOneEditDistance("a", ""))) passed++; else failed++;
        if (assertTest("Empty vs length 2 (false)", !solver.isOneEditDistance("", "ab"))) passed++; else failed++;

        // 6. Large Length Differences (should be false)
        if (assertTest("Length diff > 1 (S longer)", !solver.isOneEditDistance("abcde", "abc"))) passed++; else failed++;
        if (assertTest("Length diff > 1 (T longer)", !solver.isOneEditDistance("abc", "abcde"))) passed++; else failed++;

        // 7. Multiple Edits (should be false)
        if (assertTest("Multiple replacements", !solver.isOneEditDistance("abc", "xyz"))) passed++; else failed++;
        if (assertTest("Two replacements", !solver.isOneEditDistance("abc", "axz"))) passed++; else failed++;

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

