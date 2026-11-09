package leetcode.Solutions_0001_0100.s0087_scramble_string;

// #Hard #String #Dynamic_Programming #2022_06_20_Time_16_ms_(70.62%)_Space_43.8_MB_(77.39%)

public class Scramble_String {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    if (len == 1) {
                        dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int k = 1; k < len && !dp[i][j][len]; k++) {
                            dp[i][j][len] =
                                    (dp[i][j][k] && dp[i + k][j + k][len - k])
                                            || (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }

    public static void main(String[] args) {
    // Test Case 1: Valid scramble string transformation with a swap (Should output true)
    // "great" -> "rgeat" (swapping "g" and "r") -> "rgtae" (swapping "at" to "ta") -> "rgtae"
    String s1_1 = "great";
    String s1_2 = "rgeat";
    boolean result1 = new Scramble_String().isScramble(s1_1, s1_2);
    System.out.println("Test 1 Result: " + result1);

    // Test Case 2: Invalid transformation with character frequency mismatch (Should output false)
    String s2_1 = "abcde";
    String s2_2 = "caebd";
    boolean result2 = new Scramble_String().isScramble(s2_1, s2_2);
    System.out.println("Test 2 Result: " + result2);

    // Test Case 3: Identical single-character base strings (Should output true)
    String s3_1 = "a";
    String s3_2 = "a";
    boolean result3 = new Scramble_String().isScramble(s3_1, s3_2);
    System.out.println("Test 3 Result: " + result3);

    // Test Case 4: Mismatched single-character base strings (Should output false)
    String s4_1 = "a";
    String s4_2 = "b";
    boolean result4 = new Scramble_String().isScramble(s4_1, s4_2);
    System.out.println("Test 4 Result: " + result4);
}
}
