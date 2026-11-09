# Problem Description
The Leetcode problem "Read N Characters Given read4 II - Call Multiple Times" asks you to implement a file reading system using a provided API called read4. The read4 API reads up to 4 characters from a file and writes them into a buffer. Your task is to implement a read method that can be called multiple times, each time reading up to n characters into a given buffer. The catch is that you must correctly handle the situation where the read method is called several times in a row, possibly reading partial data from the file each time, and not skipping or duplicating any characters.

The read4 API is already defined and reads up to 4 characters from the file.
Your read method may be called multiple times; you must not lose or duplicate characters between calls.
You cannot modify the read4 API.
Each call to read should read up to n characters into the buffer and return the actual number of characters read.
Thought Process
At first glance, this problem seems similar to the simpler "Read N Characters Given read4" problem, where you only need to read n characters once. In that scenario, you could simply call read4 repeatedly until you have enough characters or reach the end of the file. However, since read can be called multiple times, we need to keep track of any extra characters that were read from the file (using read4) but not used in the current read call. These leftover characters must be saved and used in subsequent calls.

The key insight is that you need a way to "buffer" the extra characters between calls. This means you need to store any unused characters from read4 in a persistent buffer (as part of your object's state), and use these before calling read4 again in future read calls.

Brute-force approaches that simply call read4 as many times as possible in each read call will fail, as they won't account for leftover characters between calls. The optimized approach is to use an internal buffer and pointers to track how much data has been read and consumed.

## Solution Approach
To solve this problem, we'll use an internal buffer to store leftover characters from previous read4 calls. We'll also use pointers or indices to track how much of the buffer has been consumed. Here's a step-by-step breakdown:

Internal Buffer: Create a buffer (array or list) of size 4 to hold the characters read by read4.
Pointers: Maintain two integer variables:
buf_ptr: Points to the current position in the internal buffer.
buf_count: The number of valid characters in the internal buffer (from last read4 call).
Reading Logic:
Each time read is called, first use any leftover characters in the internal buffer (from previous read4 calls).
If more characters are needed, call read4 again and refill the internal buffer.
Continue until either you've read n characters or reached the end of the file (i.e., read4 returns less than 4).
Multiple Calls: By maintaining the state (internal buffer and pointers) as instance variables, the method can be called multiple times and always know where it left off.
This approach ensures that no character is lost or duplicated between calls, and that the solution works efficiently even when read is called repeatedly.

## Example Walkthrough
Let's walk through an example. Suppose the file contains the string "abcde".

First call: read(buf, 1)
Internal buffer is empty. Call read4, which reads 'a','b','c','d' into the internal buffer.
Copy 'a' to buf. Now buf_ptr = 1, buf_count = 4.
Return 1 (one character read).
Second call: read(buf, 3)
Internal buffer has 'b','c','d' at positions 1,2,3.
Copy 'b','c','d' to buf. Now buf_ptr = 4 (end of buffer).
Return 3 (three characters read).
Third call: read(buf, 2)
Internal buffer is empty. Call read4, which reads 'e' into the buffer (buf_count = 1).
Copy 'e' to buf. No more data in file.
Return 1 (end of file reached).
This ensures that all characters are read exactly once, in order, even across multiple calls.

## Time and Space Complexity
Brute-force approach (not suitable here): If you didn't use an internal buffer, you'd risk skipping or duplicating characters, and potentially call read4 more times than necessary. Time complexity would still be O(N), but the logic would be incorrect.

### Optimized approach:

Time Complexity: O(N), where N is the total number of characters read across all calls. Each character is processed once, and read4 is only called when needed.
Space Complexity: O(1), since the internal buffer size is fixed at 4, regardless of the input size.
The solution is efficient and scales well for repeated calls.
#### Summary
The key to solving "Read N Characters Given read4 II - Call Multiple Times" is to maintain an internal buffer that persists across multiple read calls. By carefully managing this buffer and tracking how much of it has been consumed, you can ensure that every character from the file is read exactly once, in order, and no characters are lost or duplicated. This approach is efficient, elegant, and leverages the constraints of the read4 API to deliver correct results even in the face of repeated, partial reads.