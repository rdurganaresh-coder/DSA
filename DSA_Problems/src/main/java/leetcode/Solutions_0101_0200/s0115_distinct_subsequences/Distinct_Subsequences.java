package leetcode.Solutions_0101_0200.s0115_distinct_subsequences;

// #Hard #String #Dynamic_Programming #2022_06_23_Time_2_ms_(100.00%)_Space_40.2_MB_(99.14%)

public class Distinct_Subsequences {
    public int numDistinct(String text, String text2) {
        if (text.length() < text2.length()) {
            return 0;
        }
        if (text.length() == text2.length()) {
            return (text.equals(text2) ? 1 : 0);
        }
        int move = text.length() - text2.length() + 2;
        // Only finite number of character in s can occupy first position in T. Same applies for
        // every character in T.
        int[] dp = new int[move];
        int j = 1;
        int k = 1;
        for (int i = 0; i < text2.length(); i++) {
            boolean firstMatch = true;
            for (; j < move; j++) {
                if (text2.charAt(i) == text.charAt(i + j - 1)) {
                    if (firstMatch) {
                        // Keep track of first match. To avoid useless comparisons on next
                        // iteration.
                        k = j;
                        firstMatch = false;
                    }
                    if (i == 0) {
                        dp[j] = 1;
                    }
                    dp[j] += dp[j - 1];
                } else {
                    dp[j] = dp[j - 1];
                }
            }
            // No match found for current character of t in s. No point in checking others.
            if (dp[move - 1] == 0) {
                return 0;
            }
            j = k;
        }
        return dp[move - 1];
    }

    public static void main(String[] args) {
    // Test Case 1: Standard case with multiple overlapping subsequence paths
    // "rabbbit" -> "rabbit" (3 ways to remove individual 'b' characters)
    String text1_1 = "rabbbit";
    String text1_2 = "rabbit";
    int result1 = new Distinct_Subsequences().numDistinct(text1_1, text1_2);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 3

    // Test Case 2: Complex string with wide duplicate distributions
    // "babgbag" -> "bag" (5 ways to form the subsequence)
    String text2_1 = "babgbag";
    String text2_2 = "bag";
    int result2 = new Distinct_Subsequences().numDistinct(text2_1, text2_2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 5

    // Test Case 3: Target string cannot be formed due to missing values (Should short-circuit to 0)
    String text3_1 = "abc";
    String text3_2 = "ax";
    int result3 = new Distinct_Subsequences().numDistinct(text3_1, text3_2);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: 0

    // Test Case 4: Target string is longer than the source template string (Should short-circuit to 0)
    String text4_1 = "a";
    String text4_2 = "aa";
    int result4 = new Distinct_Subsequences().numDistinct(text4_1, text4_2);
    System.out.println("Test 4 Result: " + result4);
    // Expected Output: 0
}
}
