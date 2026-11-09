package leetcode.Solutions_0101_0200.s0140_word_break_ii;

import java.util.ArrayList;

// #Hard #Top_Interview_Questions #String #Hash_Table #Dynamic_Programming #Backtracking #Trie
// #Memoization #2022_06_24_Time_1_ms_(99.05%)_Space_42.2_MB_(65.12%)

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Word_Break_ii {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        dfs(s, wordSet, 0, new StringBuilder(), result);
        return result;
    }

    private void dfs(
            String s, Set<String> wordSet, int index, StringBuilder sb, List<String> result) {
        if (index == s.length()) {
            if (sb.charAt(sb.length() - 1) == ' ') {
                sb.setLength(sb.length() - 1);
            }
            result.add(sb.toString());
            return;
        }
        int len = sb.length();
        for (int i = index + 1; i <= s.length(); ++i) {
            String subs = s.substring(index, i);
            if (wordSet.contains(subs)) {
                sb.append(subs).append(" ");
                dfs(s, wordSet, i, sb, result);
            }
            sb.setLength(len);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Standard multi-sentence segmentation with reusable overlapping words
        String s1 = "catsanddog";
        List<String> wordDict1 = new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"));
        List<String> result1 = new Word_Break_ii().wordBreak(s1, wordDict1);
        System.out.println("Test 1 Result: " + result1);
        // Expected Output: ["cat sand dog", "cats and dog"]

        // Test Case 2: Segmentation with completely repeated dictionary words
        String s2 = "pineapplepenapple";
        List<String> wordDict2 = new ArrayList<>(List.of("apple", "pen", "applepen", "pine", "pineapple"));
        List<String> result2 = new Word_Break_ii().wordBreak(s2, wordDict2);
        System.out.println("Test 2 Result: " + result2);
        // Expected Output: ["pine apple pen apple", "pineapple pen apple", "pine applepen apple"]

        // Test Case 3: Absolute failure case where the sentence cannot be completely broken up
        String s3 = "catsandog";
        List<String> wordDict3 = new ArrayList<>(List.of("cats", "dog", "sand", "and", "cat"));
        List<String> result3 = new Word_Break_ii().wordBreak(s3, wordDict3);
        System.out.println("Test 3 Result: " + result3);
        // Expected Output: []

        // Test Case 4: Empty string boundary configuration
        String s4 = "";
        List<String> wordDict4 = new ArrayList<>(List.of("apple"));
        List<String> result4 = new Word_Break_ii().wordBreak(s4, wordDict4);
        System.out.println("Test 4 Result (Empty): " + result4);
        // Expected Output: [""]
    }
}
