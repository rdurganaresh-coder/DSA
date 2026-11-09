# Problem Description
Given a string s, find the length of the longest substring that contains at most two distinct characters. You must return a single integer representing the maximum length of such a substring.

* The substring must be contiguous (no skipping characters).
* There is only one valid length for the answer for each input.
* All characters are allowed, and the input may include any printable character.
* Input: s (a string)
* Output: Integer (length of the longest valid substring)

# Thought Process
Let's break the problem down. We're looking for the longest continuous segment in s that has no more than two different types of characters.

A brute-force approach would be to check every possible substring and count the number of unique characters in each. However, this would be very slow because there are O(n2) substrings and counting unique characters for each would be expensive.

Instead, we can use a "sliding window" approach. This means we keep track of a window (a range of indices) in the string that always contains at most two distinct characters. As we scan the string from left to right, we expand the window to include new characters, and shrink it from the left when we have more than two distinct characters.

The key insight here is that by using a hash map (dictionary) to count characters in our window, we can efficiently know when we have more than two distinct characters, and adjust the window accordingly.

## Solution Approach
Let's walk through the optimized solution step by step:

# Initialize Pointers and Data Structures:
* Start two pointers, left and right, both at 0. These define the current window.
* Use a hash map (dictionary) to keep track of the count of each character in the current window.
* Keep a variable max_len to record the maximum window size found.
# Expand the Window:
* Move right forward one character at a time, adding the character at right to the hash map and updating its count.
# Shrink the Window if Needed:
* If the hash map contains more than two distinct characters, move left forward, reducing the count of the character at left in the hash map.
* If a character's count drops to zero, remove it from the hash map.
* Continue moving left until the window is valid again (at most two distinct characters).
# Update the Maximum:
* After each step, update max_len if the current window is larger than any seen before.
# Return Result:
* Once the process is complete, return max_len as the answer.
We use a hash map because it allows us to quickly check how many distinct characters are in our window (just check the size of the map), and to efficiently increment or decrement counts as we move the window.

# Example Walkthrough
## Let's use the input s = "eceba".

* Start: left = 0, right = 0, window = "", map = {}.
* right = 0: Add 'e' → map = {'e': 1}. Window = "e". Valid (1 distinct). max_len = 1.
* right = 1: Add 'c' → map = {'e': 1, 'c': 1}. Window = "ec". Valid (2 distinct). max_len = 2.
* right = 2: Add 'e' → map = {'e': 2, 'c': 1}. Window = "ece". Valid (2 distinct). max_len = 3.
* right = 3: Add 'b' → map = {'e': 2, 'c': 1, 'b': 1}. Now 3 distinct. Start shrinking:
* left = 0: Remove 'e' (count now 1), map = {'e': 1, 'c': 1, 'b': 1}. Still 3 distinct.
left = 1: Remove 'c' (count now 0), remove from map. map = {'e': 1, 'b': 1}. Now 2 distinct. left = 2.
max_len remains 3.
* right = 4: Add 'a' → map = {'e': 1, 'b': 1, 'a': 1}. 3 distinct. Shrink:
left = 2: Remove 'e' (count now 0), remove from map. map = {'b': 1, 'a': 1}. left = 3.
max_len remains 3.
* Done. The answer is 3, corresponding to "ece".

## Time and Space Complexity
Brute-force approach: For every substring (O(n2)), count unique characters (up to O(n)), so total O(n3).
Optimized sliding window approach: Each character is added and removed from the hash map at most once, so it's O(n) time. Space is O(1) because the hash map holds at most 3 keys (since we only care about 2 distinct at a time).
### Summary
By shifting from a brute-force strategy to a sliding window with a hash map, we efficiently find the longest substring with at most two distinct characters in linear time. The key is to manage the window so that it always contains at most two types of characters, expanding and shrinking as needed. This approach is both simple and powerful, making it a great example of using data structures to optimize string problems.