package leetcode.Solutions_0101_0200.s0135_candy;

// #Hard #Array #Greedy #Top_Interview_150_Array/String
// #2025_03_06_Time_3_ms_(83.95%)_Space_45.91_MB_(43.68%)

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] < candies[i] + 1) {
                candies[i - 1] = candies[i] + 1;
            }
        }
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }

public static void main(String[] args) {
    // Test Case 1: Alternating peak ratings profile
    // Candies allocated: [1, 2, 1] -> Total: 4
    int[] ratings1 = {1, 0, 2};
    int result1 = new Candy().candy(ratings1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 4

    // Test Case 2: Monotonically decreasing ratings profile (requires the backward pass)
    // Candies allocated: [3, 2, 1] -> Total: 6
    int[] ratings2 = {1, 2, 2};
    int result2 = new Candy().candy(ratings2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 4 (Ratings 1 and 2 get 1, 2. Flat rating gets 1 candy)

    // Test Case 3: Single element base configuration array
    int[] ratings3 = {5};
    int result3 = new Candy().candy(ratings3);
    System.out.println("Test 3 Result (Single child): " + result3);
    // Expected Output: 1

    // Test Case 4: Complete mountain-peak configuration array
    // Candies allocated: [1, 2, 3, 2, 1] -> Total: 9
    int[] ratings4 = {1, 3, 4, 3, 2};
    int result4 = new Candy().candy(ratings4);
    System.out.println("Test 4 Result (Mountain peak): " + result4);
    // Expected Output: 9

 }
}
