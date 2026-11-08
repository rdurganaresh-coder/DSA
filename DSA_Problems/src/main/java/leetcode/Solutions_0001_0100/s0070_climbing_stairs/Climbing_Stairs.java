package leetcode.Solutions_0001_0100.s0070_climbing_stairs;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Dynamic_Programming #Math #Memoization
// #Algorithm_I_Day_12_Dynamic_Programming #Dynamic_Programming_I_Day_2
// #Level_1_Day_10_Dynamic_Programming #Udemy_Dynamic_Programming #Top_Interview_150_1D_DP
// #Big_O_Time_O(n)_Space_O(n) #2024_11_11_Time_0_ms_(100.00%)_Space_40.3_MB_(41.06%)

public class Climbing_Stairs {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] cache = new int[n];
        // creating a cache or DP to store the result
        // so that we dont have to iterate multiple times
        // for the same values;

        // for 0 and 1 the result array i.e cache values would be 1 and 2
        // in loop we are just getting ith values i.e 5th step values from
        // i-1 and i-2 which are 4th step and 3rd step values.
        cache[0] = 1;
        cache[1] = 2;
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n - 1];
    }

    public static void main(String[] args) {
    // Test Case 1: Minimum standard input (n = 1)
    int result1 = new Climbing_Stairs().climbStairs(1);
    System.out.println("Test 1 (n = 1): " + result1);
    // Expected Output: 1

    // Test Case 2: Standard small input (n = 2)
    // Ways: [1+1, 2]
    int result2 = new Climbing_Stairs().climbStairs(2);
    System.out.println("Test 2 (n = 2): " + result2);
    // Expected Output: 2

    // Test Case 3: Standard medium input (n = 3)
    // Ways: [1+1+1, 1+2, 2+1]
    int result3 = new Climbing_Stairs().climbStairs(3);
    System.out.println("Test 3 (n = 3): " + result3);
    // Expected Output: 3

    // Test Case 4: Larger input tracking standard Fibonacci scale (n = 5)
    int result4 = new Climbing_Stairs().climbStairs(5);
    System.out.println("Test 4 (n = 5): " + result4);
    // Expected Output: 8
}
}
