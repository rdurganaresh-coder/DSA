package leetcode.Solutions_0101_0200.s0165_compare_version_numbers;

// #Medium #String #Two_Pointers #2022_06_25_Time_1_ms_(88.88%)_Space_41.8_MB_(66.14%)

public class Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        // acquire first number
        int numA = 0;
        int i;
        for (i = 0; i < version1.length(); i++) {
            char c = version1.charAt(i);
            if (c == '.') {
                break;
            } else {
                numA = numA * 10 + (c - 48);
            }
        }
        // acquire second number
        int numB = 0;
        int j;
        for (j = 0; j < version2.length(); j++) {
            char c = version2.charAt(j);
            if (c == '.') {
                break;
            } else {
                numB = numB * 10 + (c - 48);
            }
        }
        // compare
        if (numA > numB) {
            return 1;
        } else if (numA < numB) {
            return -1;
        } else {
            // equal
            String v1 = "";
            String v2 = "";
            if (i != version1.length()) {
                v1 = version1.substring(i + 1);
            }
            if (j != version2.length()) {
                v2 = version2.substring(j + 1);
            }
            // if both versions end here, they are equal
            if (v1.equals("") && v2.equals("")) {
                return 0;
            } else {
                return compareVersion(v1, v2);
            }
        }
    }

    public static void main(String[] args) {
        Compare_Version_Numbers solver = new Compare_Version_Numbers();
        int passed = 0;
        int failed = 0;

        // 1. Equal versions with identical format
        if (assertTest("Identical versions", solver.compareVersion("1.01", "1.01") == 0)) passed++; else failed++;

        // 2. Ignore leading zeros in revisions
        if (assertTest("Leading zeros equality", solver.compareVersion("1.01", "1.1") == 0)) passed++; else failed++;
        if (assertTest("Multiple leading zeros", solver.compareVersion("1.0001", "1.1") == 0)) passed++; else failed++;

        // 3. Different number of revisions (Treat missing revisions as 0)
        if (assertTest("Missing revisions treated as zero", solver.compareVersion("1.0", "1.0.0.0") == 0)) passed++; else failed++;

        // 4. Version 1 is smaller
        if (assertTest("Version 1 smaller (Simple)", solver.compareVersion("0.1", "1.1") == -1)) passed++; else failed++;
        if (assertTest("Version 1 smaller (Deep revision)", solver.compareVersion("1.0.1", "1.1") == -1)) passed++; else failed++;

        // 5. Version 1 is larger
        if (assertTest("Version 1 larger (Simple)", solver.compareVersion("7.5.2.4", "7.5.3") == -1)) passed++; else failed++;
        if (assertTest("Version 1 larger (Multi-digit)", solver.compareVersion("1.10", "1.2") == 1)) passed++; else failed++;

        // 6. Multi-digit integer revisions
        if (assertTest("Multi-digit revision block", solver.compareVersion("12.34", "12.35") == -1)) passed++; else failed++;

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
