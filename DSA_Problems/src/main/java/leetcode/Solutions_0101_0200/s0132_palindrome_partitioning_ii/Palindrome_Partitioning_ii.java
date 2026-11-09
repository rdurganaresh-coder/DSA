package leetcode.Solutions_0101_0200.s0132_palindrome_partitioning_ii;

// #Hard #String #Dynamic_Programming #2022_06_24_Time_2_ms_(99.89%)_Space_42.1_MB_(81.48%)

import java.util.Arrays;

public class Palindrome_Partitioning_ii {
    public int minCut(String s) {
        int n = s.length();
        char[] t = s.toCharArray();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        int i = 0;
        while (i < n) {
            expandAround(t, i, i, dp);
            expandAround(t, i, i + 1, dp);
            i++;
        }
        return dp[n];
    }

    private void expandAround(char[] t, int i, int j, int[] dp) {
        while (i >= 0 && j < t.length && t[i] == t[j]) {
            dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
    // Test Case 1: Standard case requiring a single partition cut
    // "aab" -> Cut after "aa" to get "aa" and "b" (1 cut total)
    String s1 = "aab";
    int result1 = new Palindrome_Partitioning_ii().minCut(s1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 1

    // Test Case 2: Already fully palindromic string (No cuts needed)
    String s2 = "a";
    int result2 = new Palindrome_Partitioning_ii().minCut(s2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 0

    // Test Case 3: Alternating distinct characters (Every character must be split)
    // "abc" -> "a" | "b" | "c" (2 cuts total)
    String s3 = "abc";
    int result3 = new Palindrome_Partitioning_ii().minCut(s3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: 2

    // Test Case 4: Long identical string (Should return 0)
    String s4 = "aaaaa";
    int result4 = new Palindrome_Partitioning_ii().minCut(s4);
    System.out.println("Test 4 Result: " + result4);
    // Expected Output: 0
}
}
