package leetcode.Solutions_0001_0100.s0069_sqrtx;

// #Easy #Top_Interview_Questions #Math #Binary_Search #Binary_Search_I_Day_4
// #Top_Interview_150_Math #2025_03_05_Time_1_ms_(86.67%)_Space_41.11_MB_(29.05%)

public class Sqrtx {
    public int mySqrt(int x) {
        int start = 1;
        int end = x / 2;
        int sqrt = start + (end - start) / 2;
        if (x == 0) {
            return 0;
        }
        while (start <= end) {
            if (sqrt == x / sqrt) {
                return sqrt;
            } else if (sqrt > x / sqrt) {
                end = sqrt - 1;
            } else if (sqrt < x / sqrt) {
                start = sqrt + 1;
            }
            sqrt = start + (end - start) / 2;
        }
        if (sqrt > x / sqrt) {
            return sqrt - 1;
        } else {
            return sqrt;
        }
    }

    public static void main(String[] args) {
    // Test Case 1: Minimum base edge case (x = 0)
    int result1 = new Sqrtx().mySqrt(0);
    System.out.println("Test 1 Result (sqrt of 0): " + result1);
    // Expected Output: 0

    // Test Case 2: Minimum base edge case (x = 1)
    int result2 = new Sqrtx().mySqrt(1);
    System.out.println("Test 2 Result (sqrt of 1): " + result2);
    // Expected Output: 1

    // Test Case 3: Perfect square input (x = 4)
    int result3 = new Sqrtx().mySqrt(4);
    System.out.println("Test 3 Result (sqrt of 4): " + result3);
    // Expected Output: 2

    // Test Case 4: Non-perfect square input requiring truncation (x = 8)
    int result4 = new Sqrtx().mySqrt(8);
    System.out.println("Test 4 Result (sqrt of 8): " + result4);
    // Expected Output: 2 (since 2.828... rounds down to 2)

    // Test Case 5: Large near-maximum integer value to check boundary overflow
    int result5 = new Sqrtx().mySqrt(2147395600);
    System.out.println("Test 5 Result (sqrt of large number): " + result5);
    // Expected Output: 46340
}
}
