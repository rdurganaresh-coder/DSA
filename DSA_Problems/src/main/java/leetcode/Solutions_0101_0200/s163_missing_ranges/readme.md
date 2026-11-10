Problem Description
The Missing Ranges problem asks you to find gaps in a sorted list of unique integers within a specified inclusive range. Given a sorted array nums of unique integers and two integers lower and upper representing the inclusive range [lower, upper], your task is to return the smallest sorted list of ranges that exactly cover all the missing numbers in this range, excluding the numbers present in nums.

Each range should be formatted as a string: if the range contains only one number, use just that number (e.g., "2"); if it contains multiple numbers, use the format "start->end" (e.g., "4->49").
All values in nums are within the range [lower, upper].
The solution must not reuse numbers from nums in the output ranges.
Each missing number should be covered by exactly one range in the output list.
Thought Process
When approaching this problem, the first idea may be to check every number from lower to upper and see if it is present in nums. If not, we could group consecutive missing numbers into ranges. However, iterating over every number is inefficient, especially if the range is large.

Since nums is sorted and contains unique numbers, we can efficiently identify missing ranges by examining the gaps between consecutive elements, as well as the edges (before the first and after the last element). By comparing each number in nums to the previous number (starting from lower - 1), we can spot where numbers are missing and add those ranges to our result.

The optimized approach avoids unnecessary checks by leveraging the sorted order, focusing only on the transitions between present numbers.

Solution Approach
We can solve this problem efficiently by:

Initialize a variable prev to lower - 1. This helps us check for missing numbers before the first element in nums.
Iterate through nums and one extra step (simulate a final step with upper + 1), so we can check for missing numbers after the last element.
For each curr (either a value from nums or upper + 1 at the end):
If curr - prev > 1, there is at least one missing number between prev and curr.
If only one number is missing, add it as a single number string ("n").
If more than one number is missing, add the range as "start->end".
Update prev to curr after each iteration.
This method ensures we cover all missing ranges efficiently, in a single pass through nums.

Example Walkthrough
Suppose nums = [0, 1, 3, 50, 75], lower = 0, and upper = 99.

Set prev = -1 (since lower - 1 = -1).
Iterate through nums plus upper + 1 = 100:
curr = 0: 0 - (-1) = 1 (no missing number)
curr = 1: 1 - 0 = 1 (no missing number)
curr = 3: 3 - 1 = 2 (missing 2). Add "2" to the result.
curr = 50: 50 - 3 = 47 (missing 4 to 49). Add "4->49" to the result.
curr = 75: 75 - 50 = 25 (missing 51 to 74). Add "51->74" to the result.
curr = 100: 100 - 75 = 25 (missing 76 to 99). Add "76->99" to the result.
The final output is ["2", "4->49", "51->74", "76->99"].
Time and Space Complexity
Brute-force approach:

Time Complexity: O(upper - lower + 1) (checking every number in the range)
Space Complexity: O(1) or O(n) for output
Optimized approach:
Time Complexity: O(n), where n is the length of nums (since we do a single pass through nums)
Space Complexity: O(1) extra (besides the output list)
The optimized approach is efficient even for large ranges, as it only depends on the size of nums.

Summary
The Missing Ranges problem is efficiently solved by leveraging the sorted nature of nums and focusing on the gaps between elements. By keeping track of the previous number and comparing it to the current, we can quickly identify and format missing ranges, ensuring a single pass and minimal extra space. This approach is both concise and robust, making it suitable for large input ranges.