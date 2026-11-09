package leetcode.Solutions_0101_0200.s0139_word_break;

import java.util.ArrayList;
import java.util.Arrays;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #String #Hash_Table
// #Dynamic_Programming #Trie #Memoization #Algorithm_II_Day_15_Dynamic_Programming
// #Dynamic_Programming_I_Day_9 #Udemy_Dynamic_Programming #Top_Interview_150_1D_DP
// #Big_O_Time_O(M+max*N)_Space_O(M+N+max) #2024_11_15_Time_1_ms_(99.42%)_Space_42.1_MB_(80.42%)

import java.util.List;

public class Word_Break {
    private Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length() + 1];
        return dp(s, 0, wordDict);
    }

    public boolean dp(String s, int i, List<String> wordDict) {
        if (i == s.length()) {
            return true;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length() || !s.substring(i, i + len).equals(word)) {
                continue;
            }
            if (dp(s, i + len, wordDict)) {
                memo[i] = true;
                return true;
            }
        }
        memo[i] = false;
        return false;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard segmentation with exact word match segments
    // "leetcode" can be segmented as "leet" and "code" (True)
    String s1 = "leetcode";
    List<String> wordDict1 = new ArrayList<>(Arrays.asList("leet", "code"));
    boolean result1 = new Word_Break().wordBreak(s1, wordDict1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: true

    // Test Case 2: Segmentation with reusable dictionary words
    // "applepenapple" can be segmented as "apple", "pen", "apple" (True)
    String s2 = "applepenapple";
    List<String> wordDict2 = new ArrayList<>(Arrays.asList("apple", "pen"));
    boolean result2 = new Word_Break().wordBreak(s2, wordDict2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: true

    // Test Case 3: Partial mismatch where early branches fail
    // "catsandog" cannot be completely formed (False)
    String s3 = "catsandog";
    List<String> wordDict3 = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
    boolean result3 = new Word_Break().wordBreak(s3, wordDict3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: false

    // Test Case 4: Empty string boundary case
    // Base case length validation (True)
    String s4 = "";
    List<String> wordDict4 = new ArrayList<>(Arrays.asList("apple"));
    boolean result4 = new Word_Break().wordBreak(s4, wordDict4);
    System.out.println("Test 4 Result (Empty String): " + result4);
    // Expected Output: true
}
}
