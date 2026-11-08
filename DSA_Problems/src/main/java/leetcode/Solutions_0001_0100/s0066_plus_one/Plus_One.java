package leetcode.Solutions_0001_0100.s0066_plus_one;

import java.util.Arrays;

// #Easy #Top_Interview_Questions #Array #Math #Programming_Skills_II_Day_3 #Udemy_Arrays
// #Top_Interview_150_Math #2025_03_05_Time_0_ms_(100.00%)_Space_41.78_MB_(81.75%)

public class Plus_One {
    public int[] plusOne(int[] digits) {
        int num = 1;
        int carry = 0;
        int sum;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                sum = digits[i] + carry + num;
            } else {
                sum = digits[i] + carry;
            }
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry != 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = carry;
            System.arraycopy(digits, 0, ans, 1, ans.length - 1);
            return ans;
        }
        return digits;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard conversion without carrying over columns
    int[] digits1 = {1, 2, 3};
    int[] result1 = new Plus_One().plusOne(digits1);
    System.out.println("Test 1 Result: " + Arrays.toString(result1));
    // Expected Output: [1, 2, 4]

    // Test Case 2: Standard conversion with internal carry operations
    int[] digits2 = {4, 3, 2, 9};
    int[] result2 = new Plus_One().plusOne(digits2);
    System.out.println("Test 2 Result: " + Arrays.toString(result2));
    // Expected Output: [4, 3, 3, 0]

    // Test Case 3: Single element base case
    int[] digits3 = {0};
    int[] result3 = new Plus_One().plusOne(digits3);
    System.out.println("Test 3 Result: " + Arrays.toString(result3));
    // Expected Output: [1]

    // Test Case 4: Array-wide overflow triggering length extensions
    int[] digits4 = {9, 9, 9};
    int[] result4 = new Plus_One().plusOne(digits4);
    System.out.println("Test 4 Result: " + Arrays.toString(result4));
    // Expected Output: [1, 0, 0, 0]
}
}
