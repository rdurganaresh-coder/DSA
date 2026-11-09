package leetcode.Solutions_0001_0100.s0097_interleaving_string;

// #Medium #String #Dynamic_Programming #Top_Interview_150_Multidimensional_DP
// #2025_03_05_Time_0_ms_(100.00%)_Space_42.24_MB_(22.76%)

public class Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())) {
            return false;
        }
        Boolean[][] cache = new Boolean[s1.length() + 1][s2.length() + 1];
        return isInterleave(s1, s2, s3, 0, 0, 0, cache);
    }

    public boolean isInterleave(
            String s1, String s2, String s3, int i1, int i2, int i3, Boolean[][] cache) {
        if (cache[i1][i2] != null) {
            return cache[i1][i2];
        }
        if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length()) {
            return true;
        }
        boolean result = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            result = isInterleave(s1, s2, s3, i1 + 1, i2, i3 + 1, cache);
        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            result = result || isInterleave(s1, s2, s3, i1, i2 + 1, i3 + 1, cache);
        }
        cache[i1][i2] = result;
        return result;
    }

    public static void main(String[] args) {
    // Test Case 1: Valid interleaving path (Should output true)
    // s3 splits letters from s1 and s2 cleanly while preserving relative order
    String s1_1 = "aabcc";
    String s1_2 = "dbbca";
    String s1_3 = "aadbbcbcac";
    boolean result1 = new Interleaving_String().isInterleave(s1_1, s1_2, s1_3);
    System.out.println("Test 1 Result: " + result1);

    // Test Case 2: Invalid interleaving path due to character mismatch (Should output false)
    String s2_1 = "aabcc";
    String s2_2 = "dbbca";
    String s2_3 = "aadbbbaccc";
    boolean result2 = new Interleaving_String().isInterleave(s2_1, s2_2, s2_3);
    System.out.println("Test 2 Result: " + result2);

    // Test Case 3: Empty string base configurations (Should output true)
    String s3_1 = "";
    String s3_2 = "";
    String s3_3 = "";
    boolean result3 = new Interleaving_String().isInterleave(s3_1, s3_2, s3_3);
    System.out.println("Test 3 Result (All Empty): " + result3);

    // Test Case 4: Length validation short-circuit case (Should output false)
    String s4_1 = "a";
    String s4_2 = "b";
    String s4_3 = "a";
    boolean result4 = new Interleaving_String().isInterleave(s4_1, s4_2, s4_3);
    System.out.println("Test 4 Result (Mismatched Lengths): " + result4);
}
}
