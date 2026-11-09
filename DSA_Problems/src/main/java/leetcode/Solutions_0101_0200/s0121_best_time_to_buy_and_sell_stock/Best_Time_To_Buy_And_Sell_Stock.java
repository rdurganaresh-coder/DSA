package leetcode.Solutions_0101_0200.s0121_best_time_to_buy_and_sell_stock;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Array #Dynamic_Programming
// #Data_Structure_I_Day_3_Array #Dynamic_Programming_I_Day_7 #Level_1_Day_5_Greedy #Udemy_Arrays
// #Top_Interview_150_Array/String #Big_O_Time_O(N)_Space_O(1)
// #2024_11_13_Time_1_ms_(99.78%)_Space_61.8_MB_(27.61%)

public class Best_Time_To_Buy_And_Sell_Stock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard case with fluctuating prices
    // Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    int[] prices1 = {7, 1, 5, 3, 6, 4};
    int result1 = new Best_Time_To_Buy_And_Sell_Stock().maxProfit(prices1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 5

    // Test Case 2: Monotonically decreasing prices (No profit possible)
    int[] prices2 = {7, 6, 4, 3, 1};
    int result2 = new Best_Time_To_Buy_And_Sell_Stock().maxProfit(prices2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 0

    // Test Case 3: Single element array base case
    int[] prices3 = {5};
    int result3 = new Best_Time_To_Buy_And_Sell_Stock().maxProfit(prices3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: 0 (Cannot sell on the same day you buy)

    // Test Case 4: Empty input array edge case
    int[] prices4 = {};
    int result4 = new Best_Time_To_Buy_And_Sell_Stock().maxProfit(prices4);
    System.out.println("Test 4 Result (Empty): " + result4);
    // Expected Output: 0
}
}
