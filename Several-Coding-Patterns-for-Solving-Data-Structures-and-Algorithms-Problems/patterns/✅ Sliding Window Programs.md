# Sliding Window Technique: Comprehensive Overview & Templates

## Overview
The **Sliding Window Technique (SWT)** is a popular method in algorithmic problems because of its high efficiency (mostly linear time complexity). 

It helps to avoid computing repetitive problems by calculating only the new data that enters the window and discarding the data that moves out, usually one element at a time.

There are **two main categories** of Sliding Window problems:
* **Fixed-Sized Window:** The window remains at a constant size (say `k`) while it slides along a data structure. *Analogy: Imagine sliding a glass window panel along a long frame.*
* **Variable-Sized Window:** The window fluctuates in size while moving along a data structure. *Analogy: Imagine a spring compressing and expanding while moving along a plane.*

---

## Sample Problem: Longest Substring Without Repeating Characters
> **Problem Statement:** Given a string `s`, find the length of the longest substring without repeating characters.

### Algorithm Strategy
1. Use a `HashMap` to keep track of the latest index of each letter.
2. Keeping the `left` pointer at rest, move the `right` pointer by one letter at a time.
3. When a repeating character is encountered, update the `maxLength` and move the `left` pointer to `max{left pointer, old last occurrence of this character}`. We use `Math.max` because we never want to pull the `left` pointer backward (e.g., in the string `"abba"`).
4. Return `max{right - left, maxLength}` outside the loop to handle strings containing completely unique characters.

**Complexity Analysis:**
* **Time Complexity:** $O(n)$ where $n = \text{s.length()}$
* **Space Complexity:** $O(a)$ where $a$ is the size of the unique character set

### Java Template Code

```java
import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        var n = s.length();
        
        if (n < 2) {
            return n;
        }
            
        var left = 0;
        var right = 0;
        var maxLength = 0;
        var map = new HashMap<Character, Integer>(); // map of char to its latest index

        while (right < n) {
            var ch = s.charAt(right);
            
            if (map.containsKey(ch)) {
                maxLength = Math.max(maxLength, right - left); // record max window size
                left = Math.max(left, map.get(ch) + 1); // shrink window from left
            }
            
            map.put(ch, right); 
            right++; // expand window to the right
        }
        
        return Math.max(maxLength, right - left);
    }
}
```

---

## Question Bank
The template above can be slightly tweaked and modified to solve the following patterned LeetCode problems:

## Question Bank

### 1. Fixed-Sized Window Problems

| LeetCode # | Problem Name | Source Code |
| :--- | :--- | :--- |
| **30** | [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)|[Code](../../DSA_Problems/src/main/java/com/durga/leetcode/Sliding_Window/SubstringWithConcatenationOfAllWords.java) |
| **187** | Repeated DNA Sequences | |
| **438** | Find All Anagrams in a String | |
| **567** | Permutation in String | |
| **643** | Maximum Average Subarray I | |
| **995** | Minimum Number of K Consecutive Bit Flips | |
| **1100** | Find K-Length Substrings With No Repeated Characters | Premium |
| **1151** | Minimum Swaps to Group All 1's Together | Premium |
| **1176** | Diet Plan Performance | Premium |
| **1343** | Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold | |
| **1423** | Maximum Points You Can Obtain from Cards | |
| **1456** | Maximum Number of Vowels in a Substring of Given Length | |
| **1652** | Defuse the Bomb | |
| **1876** | Substrings of Size Three with Distinct Characters | |
| **2090** | K Radius Subarray Averages | |
| **2134** | Minimum Swaps to Group All 1's Together II | |
| **2269** | Find the K-Beauty of a Number | |
| **2379** | Minimum Recolors to Get K Consecutive Black Blocks | |
| **2461** | Maximum Sum of Distinct Subarrays With Length K | |
| **3191** | Minimum Operations to Make Binary Array Elements Equal to One I | |
| **3206** | Alternating Groups I | |
| **3208** | Alternating Groups II | |
| **3254** | Find the Power of K-Size Subarrays I | |
| **3439** | Reschedule Meetings for Maximum Free Time I | |

### 2. Variable-Sized Window Problems

| LeetCode # | Problem Name | Notes |
| :--- | :--- | :--- |
| **3** | Longest Substring Without Repeating Characters | |
| **76** | Minimum Window Substring | |
| **159** | Longest Substring with At Most Two Distinct Characters | |
| **209** | Minimum Size Subarray Sum | |
| **340** | Longest Substring with At Most K Distinct Characters | Premium |
| **424** | Longest Repeating Character Replacement | |
| **487** | Max Consecutive Ones II | Premium |
| **795** | Number of Subarrays with Bounded Maximum | |
| **862** | Shortest Subarray with Sum at Least K | |
| **904** | Fruit Into Baskets | |
| **992** | Subarrays with K Different Integers | |
| **1004** | Max Consecutive Ones III | |
| **1208** | Get Equal Substrings Within Budget | |
| **1297** | Maximum Number of Occurrences of a Substring | |
| **1358** | Number of Substrings Containing All Three Characters | |
| **1438** | Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit | |
| **1493** | Longest Subarray of 1's After Deleting One Element | |
| **1574** | Shortest Subarray to be Removed to Make Array Sorted | |
| **1695** | Maximum Erasure Value | |
| **1838** | Frequency of the Most Frequent Element | |
| **1852** | Distinct Numbers in Each Subarray | Premium |
| **2024** | Maximize the Confusion of an Exam | |
| **2062** | Count Vowel Substrings of a String | |
| **2302** | Count Subarrays With Score Less Than K | |
| **2444** | Count Subarrays With Fixed Bounds | |
| **2516** | Take K of Each Character From Left and Right | |
| **2537** | Count the Number of Good Subarrays | |
| **2799** | Count Complete Subarrays in an Array | |
| **2962** | Count Subarrays Where Max Element Appears at Least K Times | |
| **3095** | Shortest Subarray With OR at Least K I | |
| **3097** | Shortest Subarray With OR at Least K II | |
| **3305** | Count of Substrings Containing Every Vowel and K Consonants I | |
| **3306** | Count of Substrings Containing Every Vowel and K Consonants II | |
