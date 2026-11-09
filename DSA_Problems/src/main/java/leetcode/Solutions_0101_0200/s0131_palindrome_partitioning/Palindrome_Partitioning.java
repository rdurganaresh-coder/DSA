package leetcode.Solutions_0101_0200.s0131_palindrome_partitioning;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #String #Dynamic_Programming
// #Backtracking #Big_O_Time_O(N*2^N)_Space_O(2^N*N)
// #2024_11_13_Time_7_ms_(98.55%)_Space_56.9_MB_(57.45%)

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("java:S5413")
public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtracking(List<List<String>> res, List<String> currArr, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(currArr));
        }
        for (int end = start; end < s.length(); end++) {
            if (!isPanlindrome(s, start, end)) {
                continue;
            }
            currArr.add(s.substring(start, end + 1));
            backtracking(res, currArr, s, end + 1);
            currArr.remove(currArr.size() - 1);
        }
    }

    private boolean isPanlindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard string with multiple overlapping palindrome options
    // Expected Output: [["a", "a", "b"], ["aa", "b"]]
    String s1 = "aab";
    List<List<String>> result1 = new Palindrome_Partitioning().partition(s1);
    System.out.println("Test 1 Result: " + result1);

    // Test Case 2: Single character base case string
    // Expected Output: [["a"]]
    String s2 = "a";
    List<List<String>> result2 = new Palindrome_Partitioning().partition(s2);
    System.out.println("Test 2 Result: " + result2);

    // Test Case 3: Empty string boundary case
    // Expected Output: [[]] (An empty list containing an empty path list)
    String s3 = "";
    List<List<String>> result3 = new Palindrome_Partitioning().partition(s3);
    System.out.println("Test 3 Result: " + result3);

    // Test Case 4: Long uniform character run (Triggers multiple combination cuts)
    // Expected Output contains paths like ["a","a","a"], ["a","aa"], ["aa","a"], ["aaa"]
    String s4 = "aaa";
    List<List<String>> result4 = new Palindrome_Partitioning().partition(s4);
    System.out.println("Test 4 Result: " + result4);
}
}
