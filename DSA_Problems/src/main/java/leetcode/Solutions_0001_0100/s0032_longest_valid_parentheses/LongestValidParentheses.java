package leetcode.Solutions_0001_0100.s0032_longest_valid_parentheses;
// #Hard #Top_100_Liked_Questions #String #Dynamic_Programming #Stack #Big_O_Time_O(n)_Space_O(1)
// #2024_11_10_Time_1_ms_(99.74%)_Space_42.2_MB_(80.93%)

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        char ch;
        for (int i = 0; i < n; i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                left = 0;
                right = 0;
            }
            if (left == right) {
                max = Math.max(max, left + right);
            }
        }
        left = 0;
        right = 0;
        for (int i = n - 1; i >= 0; i--) {
            ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                right++;
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
            if (left == right) {
                max = Math.max(max, left + right);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard LeetCode Example 1
        String s1 = "(()";
        System.out.println("Input: \"" + s1 + "\" -> Output: " + longestValidParentheses(s1) + " (Expected: 2)");

        // Test Case 2: Standard LeetCode Example 2
        String s2 = ")()())";
        System.out.println("Input: \"" + s2 + "\" -> Output: " + longestValidParentheses(s2) + " (Expected: 4)");

        // Test Case 3: Empty String Edge Case
        String s3 = "";
        System.out.println("Input: \"" + s3 + "\" -> Output: " + longestValidParentheses(s3) + " (Expected: 0)");

        // Test Case 4: Completely Invalid/Closed Parentheses
        String s4 = ")))";
        System.out.println("Input: \"" + s4 + "\" -> Output: " + longestValidParentheses(s4) + " (Expected: 0)");

        // Test Case 5: Fully Valid and Well-Formed Nested Parentheses
        String s5 = "(())";
        System.out.println("Input: \"" + s5 + "\" -> Output: " + longestValidParentheses(s5) + " (Expected: 4)");

        // Test Case 6: Multiple Valid Substrings Separated by Invalid Ones
        String s6 = "()(()())";
        System.out.println("Input: \"" + s6 + "\" -> Output: " + longestValidParentheses(s6) + " (Expected: 8)");
    }
}
