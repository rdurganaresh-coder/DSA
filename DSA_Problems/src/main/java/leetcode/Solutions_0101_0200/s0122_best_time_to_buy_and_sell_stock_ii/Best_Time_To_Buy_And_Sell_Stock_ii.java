package leetcode.Solutions_0101_0200.s0122_best_time_to_buy_and_sell_stock_ii;

// #Medium #Top_Interview_Questions #Array #Dynamic_Programming #Greedy #Dynamic_Programming_I_Day_7
// #Udemy_Arrays #Top_Interview_150_Array/String
// #2025_03_06_Time_1_ms_(76.91%)_Space_45.72_MB_(69.34%)

public class Best_Time_To_Buy_And_Sell_Stock_ii {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard fluctuating market with multiple profit peaks
    // Buy on day 2 (1) and sell on day 3 (5), profit = 4
    // Buy on day 4 (3) and sell on day 5 (6), profit = 3. Total = 7.
    int[] prices1 = {7, 1, 5, 3, 6, 4};
    int result1 = new Best_Time_To_Buy_And_Sell_Stock_ii().maxProfit(prices1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 7

    // Test Case 2: Monotonically increasing prices (Continuous upward trend)
    // Captures (5-1) = 4 profit across the entire range
    int[] prices2 = {1, 2, 3, 4, 5};
    int result2 = new Best_Time_To_Buy_And_Sell_Stock_ii().maxProfit(prices2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 4

    // Test Case 3: Monotonically decreasing prices (Continuous downward trend)
    int[] prices3 = {7, 6, 4, 3, 1};
    int result3 = new Best_Time_To_Buy_And_Sell_Stock_ii().maxProfit(prices3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: 0

    // Test Case 4: Single element array base case
    int[] prices4 = {5};
    int result4 = new Best_Time_To_Buy_And_Sell_Stock_ii().maxProfit(prices4);
    System.out.println("Test 4 Result (Single Node): " + result4);
    // Expected Output: 0

    // Test Case 5: Empty input array edge case boundary
    int[] prices5 = {};
    int result5 = new Best_Time_To_Buy_And_Sell_Stock_ii().maxProfit(prices5);
    System.out.println("Test 5 Result (Empty): " + result5);
    // Expected Output: 0
}
}
