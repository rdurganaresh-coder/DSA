package leetcode.Solutions_0101_0200.s0159_longest_substring_with_at_most_two_distinct_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 159 - Longest Substring with At Most Two Distinct Characters
 * Time Complexity: O(N) where N is the length of the string.
 * Space Complexity: O(1) since the map contains at most 3 elements.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Map to keep track of characters and their frequencies in the active window
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        
        int maxLength = 0;
        int left = 0;

        // Slide the right pointer across the entire string length
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            // If we have more than 2 distinct characters, shrink the window from the left
            while (charFrequencyMap.size() > 2) {
                char leftChar = s.charAt(left);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                
                // If count becomes 0, remove the character from the map to drop distinct size
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                left++; // Shrink window bounds forward
            }

            // Calculate current window size and compare with max recorded length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // --- Main Method Executing Comprehensive Test Cases ---
    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters solver = new LongestSubstringWithAtMostTwoDistinctCharacters();

        System.out.println("==================================================================");
        System.out.println(" RUNNING TEST CASES FOR LONGEST SUBSTRING WITH AT MOST 2 DISTINCT ");
        System.out.println("==================================================================\n");

        // Test Case 1: Standard input with interspersed characters
        runTestCase(solver, "eceba", 3, "Test 1: Standard overlapping distinct groups (Sub: 'ece')");

        // Test Case 2: Out of order longest block near the tail
        runTestCase(solver, "ccaabbb", 5, "Test 2: Target answer at trailing window zone (Sub: 'aabbb')");

        // Test Case 3: Completely identical string setup
        runTestCase(solver, "aaaaaa", 6, "Test 3: Single distinct character throughout structural bounds");

        // Test Case 4: Completely distinct character mapping sequence
        runTestCase(solver, "abcdef", 2, "Test 4: Strict sequential individual distinct characters");

        // Test Case 5: Empty configuration validation
        runTestCase(solver, "", 0, "Test 5: Edge boundary validation check on empty string");
    }

    /**
     * Reusable Scenario Matrix Execution Engine
     */
    private static void runTestCase(LongestSubstringWithAtMostTwoDistinctCharacters solver, String input, int expected, String description) {
        System.out.println("👉 " + description);
        System.out.println("   Input String : \"" + input + "\"");
        
        int result = solver.lengthOfLongestSubstringTwoDistinct(input);
        
        System.out.println("   Result Value : " + result + " (Expected: " + expected + ")");
        System.out.println(result == expected ? "   STATUS       : ✅ PASSED" : "   STATUS       : ❌ FAILED");
        System.out.println("------------------------------------------------------------------\n");
    }
}
